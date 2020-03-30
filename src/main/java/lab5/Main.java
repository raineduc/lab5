package lab5;

import lab5.database.XmlManager;
import lab5.lib.ValidationException;
import lab5.storage.Flat;
import lab5.storage.FlatStorage;
import lab5.storage.LocalStorageManager;
import lab5.storage.marshalling_shapes.Flats;
import lab5.ui.console.Console;
import lab5.utils.IntIDGenerator;

import java.nio.file.Path;
import java.util.LinkedHashMap;

public class Main {
  public static void main(String[] args) {
    LocalStorageManager storageManager;

    if (args.length > 0) {
      Path path = Path.of(args[0].trim());
      try {
        XmlManager<Flats> manager = new XmlManager<>(path.toFile(),
                Flats.class);
        IntIDGenerator generator = new IntIDGenerator();
        storageManager = new LocalStorageManager(manager, generator);
        for (Flat flat: storageManager.getStorage().getAll()) {
          generator.addIDToBlackList(flat.getId());
        }
      } catch (ValidationException e) {
        storageManager = null;
        System.out.println(e.getMessage());
        System.exit(1);
      }
    } else {
      storageManager = new LocalStorageManager(new IntIDGenerator());
    }
    Console console = new Console(storageManager);
    console.open();
  }
}
