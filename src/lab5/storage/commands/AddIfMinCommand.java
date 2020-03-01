package lab5.storage.commands;

import lab5.lib.ValidationException;
import lab5.storage.*;

public class AddIfMinCommand extends AbstractAddCommand {
  private FlatStorage storage;
  private static String info = "добавить новый элемент в коллекцию, " +
          "если его значение меньше, чем у наименьшего элемента этой коллекции";

  public AddIfMinCommand(
          FlatStorage storage,
          String name,
          int area,
          Integer numberOfRooms,
          boolean balcony,
          double timeToMetroByTransport,
          View view,
          House house,
          Coordinates coordinates
  ) {
    super(name, area, numberOfRooms, balcony, timeToMetroByTransport, view, house, coordinates);
    this.storage = storage;
  }

  @Override
  public void execute() throws ValidationException, NullPointerException {
    Flat flat = this.generateFlat();
    storage.addFlatIf(flat, (map) -> {
      boolean isMin = true;
      for (Flat currentFlat: map.values()) {
        if (currentFlat.getId() < flat.getId()) {
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
