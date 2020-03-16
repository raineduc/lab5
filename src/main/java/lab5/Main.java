package lab5;

import lab5.database.XmlManager;
import lab5.lib.ValidationException;
import lab5.storage.Flat;
import lab5.storage.FlatStorage;
import lab5.storage.marshalling_shapes.Flats;
import lab5.ui.console.Console;

import java.nio.file.Path;
import java.util.LinkedHashMap;

public class Main {
  public static void main(String[] args) {
    FlatStorage storage;

    if (args.length > 0) {
      Path path = Path.of(args[0]);
      try {
        XmlManager<Flats> manager = new XmlManager<>(path.toFile(),
                Flats.class);
        storage = new FlatStorage(manager);
      } catch (ValidationException e) {
        storage = null;
        System.out.println(e.getMessage());
        System.exit(1);
      }
    } else {
      storage = new FlatStorage();
    }
    Console console = new Console(storage);
    console.open();
  }
}
