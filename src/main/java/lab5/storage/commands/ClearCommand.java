package lab5.storage.commands;

import lab5.lib.Command;
import lab5.lib.ValidationException;
import lab5.storage.FlatStorage;

public class ClearCommand implements Command {
  private FlatStorage storage;
  private static String info = "очистить коллекцию";
  public ClearCommand(FlatStorage storage) {
    this.storage = storage;
  }

  public void execute() throws ValidationException, NullPointerException {
    storage.clear();
  }

  public static String getInfo() {
    return info;
  }
}
