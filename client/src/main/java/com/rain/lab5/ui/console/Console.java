package com.rain.lab5.ui.console;

import com.rain.lab5.lib.Command;
import com.rain.lab5.lib.ValidationException;
import com.rain.lab5.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


/**
 * Works with command line
 * @author Raineduc
 */
public class Console {
  private Scanner scanner = new Scanner(System.in);
  private CommandHistory history = new CommandHistory();
  private CommandParser parser;
  private ConsoleMode mode = ConsoleMode.DIRECT_INPUT;
  private ArrayList<String> commandResults = new ArrayList<>();
  private ArrayList<Path> paths = new ArrayList<>();


  public Console(StorageManager manager) {
    this.parser = new CommandParser(this, manager);
  }

  /**
   *
   * @return Scanner This returns java.utils.Scanner
   */
  protected Scanner getScanner() {
    return scanner;
  }


  /**
   *
   * @return This returns ConsoleMode
   */
  protected ConsoleMode getMode() {
    return mode;
  }


  /**
   * Opens interactive mode via Scanner
   */
  public void open() {
    while (true) {
      try {
        if (mode != ConsoleMode.DIRECT_INPUT) {
          mode = ConsoleMode.DIRECT_INPUT;
          parser.setScanner(scanner);
        }
        showContinuously(">> ");
        String currentLine = scanner.nextLine();
        this.executeCommand(parser.parse(currentLine));
      } catch (IllegalStateException e) {
        break;
      } catch (ValidationException e) {
        show(e.getMessage());
        if (mode == ConsoleMode.DIRECT_INPUT) scanner = new Scanner(System.in);
      } catch (NoSuchElementException e) {
        show("Input is not available");
      }
    }
  }

  /**
   * Close scanner
   */
  public void exit() {
    scanner.close();
  }

  /**
   * Send string to output without line break symbol
   * @param line Calls Object.toString() internally
   */
  public void showContinuously(Object line) {
    System.out.print(line);
  }

  /**
   * Send strong to output with line break symbol
   * @param line Calls Object.toString() internally
   */
  public void show(Object line) {
    System.out.println(line);
  }

  /**
   *
   * @param line Calls Object.toString()
   * @param consoleMode Show if current mode equals to provided console mode
   */

  public void show(Object line, ConsoleMode consoleMode) {
    if (mode == consoleMode) show(line);
  }

  /**
   *
   * @param lines Show line with line breaks
   * @param consoleMode Show if current mode equals to provided console mode
   */
  public void show(Object[] lines, ConsoleMode consoleMode) {
    if (mode == consoleMode) show(lines);
  }

  /**
   *
   * @param lines Show lines with line breaks
   */
  public void show(Object[] lines) {
    for (Object line : lines) {
      System.out.println(line);
    }
  }

  public void executeCommand(@NotNull Map.Entry<MnemonicDefinition, Command> commandEntry) {
    executeCommand(commandEntry, true);
  }

  public void executeCommand(@NotNull Map.Entry<MnemonicDefinition, Command> commandEntry, boolean shouldBeStored) {
    ConsoleMode currentMode = mode;
    Command command = commandEntry.getValue();
    MnemonicDefinition definition = commandEntry.getKey();

    try {
      command.execute();
      if (shouldBeStored) {
        history.push(definition.getMnemonic());
      }
      if (commandResults != null) {
        for (String line: commandResults) show(mode == currentMode ? "  " + line : line);
      }
      show(commandEntry.getKey().getMnemonic() + " Done");
    } catch (ValidationException | NullPointerException e) {
      this.show(e.getMessage());
    }
  }

  public String[] getLastCommands() {
    return history.getLastCommands(7);
  }

  public void executeScript(Path filename) throws ValidationException {
    try {
      for (Path path: paths) {
        if (Files.isSameFile(path, filename)) {
          throw new ValidationException("You've got a script cycle");
        }
      }
      paths.add(filename);
      mode = ConsoleMode.SCRIPT;
      Scanner scriptScanner = new Scanner(filename);
      parser.setScanner(scriptScanner);
      while (scriptScanner.hasNextLine()) {
        parser.setScanner(scriptScanner);
        String currentLine = scriptScanner.nextLine();
        if (currentLine.length() == 0) continue;
        show(currentLine);
        this.executeCommand(parser.parse(currentLine));
      }

      scriptScanner.close();
      paths.remove(filename);
    } catch (IOException e) {
      throw new ValidationException("File is not available");
    } catch (NoSuchElementException e) {
      throw new ValidationException("Script is invalid. Probably there aren't enough fields for complex arguments");
    }
  }

  public void addCommandResult(String commandResult) {
    commandResults.add(commandResult);
  }

  public void clearCommandResults() {
    commandResults.clear();
  }
}
