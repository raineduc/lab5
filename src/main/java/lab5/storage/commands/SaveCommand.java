package lab5.storage.commands;

import lab5.lib.ValidationException;
import lab5.storage.FlatStorage;
import lab5.storage.StorageManager;

public class SaveCommand extends StorageCommand {
  private static String info = "сохранить коллекцию в файл";

  public SaveCommand(StorageManager manager) {
    super(manager);
  }

  public void execute(FlatStorage storage) throws ValidationException {
    storage.save();
  }

  public static String getInfo() {
    return info;
  }
}
