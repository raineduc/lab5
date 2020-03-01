package lab5.manager;

import lab5.lib.ValidationException;
import lab5.lib.Command;

public class StorageManager {
  private CommandHistory history = new CommandHistory();

  public void executeCommand(Command command) throws ValidationException, NullPointerException {
    command.execute();
    history.push(command);
  }

  public Command[] getLastCommands(int number) {
    return history.getLastCommands(number);
  }
}
