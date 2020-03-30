package lab5.storage.commands;

import lab5.lib.ValidationException;
import lab5.storage.FlatStorage;
import lab5.storage.StorageManager;

public class ClearCommand extends StorageCommand {
  private static String info = "очистить коллекцию";

  public ClearCommand(StorageManager manager) {
    super(manager);
  }

  public void execute(FlatStorage storage) throws NullPointerException {
    storage.clear();
  }

  public static String getInfo() {
    return info;
  }
}
