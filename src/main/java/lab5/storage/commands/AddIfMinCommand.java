package lab5.storage.commands;

import lab5.lib.ValidationException;
import lab5.storage.*;

public class AddIfMinCommand extends AbstractAddCommand {
  private static String info = "добавить новый элемент в коллекцию, " +
          "если его значение меньше, чем у наименьшего элемента этой коллекции";

  public AddIfMinCommand(StorageManager manager, FlatOptions options) {
    super(manager, options);
  }

  @Override
  public void execute(FlatStorage storage) throws ValidationException, NullPointerException {
    Flat flat = this.generateFlat();
    storage.addFlatIf(flat, (map) -> {
      boolean isMin = true;
      for (Flat currentFlat: map.values()) {
        if (currentFlat.getArea() < flat.getArea()) {
          isMin = false;
          break;
        }
      }
      return isMin;
    });
  }

  public static String getInfo() {
    return info;
  }
}
