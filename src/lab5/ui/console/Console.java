package lab5.ui.console;

import lab5.lib.Command;
import lab5.lib.ValidationException;
import lab5.storage.Flat;
import lab5.storage.FlatStorage;

import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Console {
  private Scanner scanner = new Scanner(System.in);
  private HashMap<String, String> availableCommands = new HashMap<>();
  private FlatStorage storage;
  private CommandParser parser;

  public Console(FlatStorage storage) {
    this.storage = storage;
    this.parser = new CommandParser(this, storage);
  }


  public void open() {
    while (true) {
      try {
        String currentLine = scanner.nextLine();
        Command parsedCommand = parser.parse(currentLine);
        this.executeCommand(parsedCommand);
      } catch (IllegalStateException e) {
        break;
      }
    }
  }

  public void exit() {
    scanner.close();
  }

  public void show(String line) {
    System.out.println(line);
  }

  public void show(String[] lines) {
    for (String line: lines) {
      System.out.println(line);
    }
  }

  public void save(Collection<Flat> stack) {

  }

  public void executeCommand(Command command) {
    try {
      if (command == null) {
        throw new ValidationException("Такой команды не существует");
      }
      command.execute();
    } catch (ValidationException e) {
      this.show(e.getMessage());
    } catch (NullPointerException e) {
      this.show(e.getMessage());
    }
  }

  public void executeScript(Path filename) {

  }
}
