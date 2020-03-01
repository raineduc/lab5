package lab5.storage.commands;

import lab5.lib.ValidationException;
import lab5.storage.*;

public class UpdateCommand extends AbstractAddCommand {
  private static String info = "обновить значение элемента коллекции, id которого равен заданному";

  private FlatStorage storage;
  private int id;

  public UpdateCommand(FlatStorage storage,
                       int id,
                       String name,
                       int area,
                       Integer numberOfRooms,
                       boolean balcony,
                       double timeToMetroByTransport,
                       View view,
                       House house,
                       Coordinates coordinates) {
    super(name, area, numberOfRooms, balcony, timeToMetroByTransport, view, house, coordinates);
    this.id = id;
    this.storage = storage;
  }

  public void execute() throws ValidationException, NullPointerException {
    Flat flat = this.generateFlat();
    storage.updateFlat(flat, id);
  }

  public static String getInfo() {
    return info;
  }
}
