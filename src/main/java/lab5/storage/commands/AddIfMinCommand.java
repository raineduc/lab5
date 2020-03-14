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
          String houseName,
          Integer houseYear,
          Coordinates coordinates
  ) {
    super(name, area, numberOfRooms, balcony, timeToMetroByTransport, view, houseName, houseYear, coordinates);
    this.storage = storage;
  }

  public AddIfMinCommand(FlatOptions options, FlatStorage storage) {
    super(options);
    this.storage = storage;
  }

  @Override
  public void execute() throws ValidationException, NullPointerException {
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
