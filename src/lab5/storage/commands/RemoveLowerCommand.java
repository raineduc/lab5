package lab5.storage.commands;

import lab5.lib.Command;
import lab5.storage.*;
import lab5.lib.ValidationException;

import java.util.Collections;
import java.util.Map;

public class RemoveLowerCommand extends AbstractAddCommand {
  private FlatStorage storage;
  private View view;
  private static String info = "удалить из коллекции все элементы, значение поля meleeWeapon которого эквивалентно заданному";

  public RemoveLowerCommand(FlatStorage storage,
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
    Flat comparableFlat = this.generateFlat();
    storage.removeAllIf((flat) -> flat.compareTo(comparableFlat) < 0);
  }

  public static String getInfo() {
    return info;
  }
}