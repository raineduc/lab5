package lab5.storage.commands;

import lab5.lib.Command;
import lab5.lib.ValidationException;
import lab5.storage.FlatStorage;
import lab5.storage.FlatValidator;

public class RemoveCommand implements Command {
  private int id;
  private FlatStorage storage;
  private static String info = "удалить элемент из коллекции по его id";
  public RemoveCommand(FlatStorage storage, int id) {
    this.storage = storage;
    this.id = id;
  }

  @Override
  public void execute() throws ValidationException, NullPointerException {
    FlatValidator.validateID(id);
    storage.removeFlat(id);
  }

  public static String getInfo() {
    return info;
  }
}
