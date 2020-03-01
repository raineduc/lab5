package lab5.ui.console;

import lab5.lib.Command;
import lab5.lib.ValidationException;
import lab5.storage.Flat;
import lab5.storage.FlatStorage;

import java.nio.file.Path;
import java.util.*;

public class Console {
  private Scanner scanner = new Scanner(System.in);
  private CommandHistory history = new CommandHistory();
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
        this.executeCommand(parser.parse(currentLine));
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

  public void executeCommand(Map.Entry<MnemonicDefinition, Command> commandEntry) {
    Command command = commandEntry.getValue();
    MnemonicDefinition definition = commandEntry.getKey();

    try {
      if (command == null) {
        throw new ValidationException("Такой команды не существует");
      }
      command.execute();
      history.push(definition.getMnemonic());
    } catch (ValidationException e) {
      this.show(e.getMessage());
    } catch (NullPointerException e) {
      this.show(e.getMessage());
    }
  }

  public String[] getLastCommands() {
    return history.getLastCommands(7);
  }

  public void executeScript(Path filename) {

  }
}
