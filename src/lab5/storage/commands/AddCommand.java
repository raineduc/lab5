package lab5.storage.commands;

import lab5.lib.ValidationException;
import lab5.storage.*;

public class AddCommand extends AbstractAddCommand {
    private FlatStorage storage;
    private static String info = "добавить новый элемент в коллекцию";
    public AddCommand(
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

    public AddCommand(FlatOptions options, FlatStorage storage) {
      super(options);
      this.storage = storage;
    }

    public void execute() throws ValidationException, NullPointerException {
      Flat flat = this.generateFlat();
      storage.addFlat(flat);
    }

    public static String getInfo() {
      return info;
    }
}
