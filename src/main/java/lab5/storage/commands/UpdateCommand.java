package lab5.storage.commands;

import lab5.lib.ValidationException;
import lab5.storage.*;

public class UpdateCommand extends AbstractAddCommand {
  private static String info = "обновить значение элемента коллекции, id которого равен заданному";
  private FlatStorage storage;
  private int id;


  public UpdateCommand(FlatOptions options, FlatStorage storage, int id) {
    super(options, storage);
    this.id = id;
    this.storage = storage;
  }

  public void execute() throws ValidationException, NullPointerException {
    if (storage.get(id) == null) {
      throw new ValidationException("Space marine with specified id does not exist");
    }
    Flat flat = this.generateFlat();
    storage.updateFlat(flat, id);
  }

  public static String getInfo() {
    return info;
  }
}
