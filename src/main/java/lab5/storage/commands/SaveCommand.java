package lab5.storage.commands;

import lab5.lib.Command;
import lab5.lib.ValidationException;
import lab5.storage.FlatStorage;

public class SaveCommand implements Command {
  private FlatStorage storage;
  private static String info = "сохранить коллекцию в файл";

  public SaveCommand(FlatStorage storage) {
    this.storage = storage;
  }

  public void execute() throws ValidationException {
    storage.save();
  }

  public static String getInfo() {
    return info;
  }
}
