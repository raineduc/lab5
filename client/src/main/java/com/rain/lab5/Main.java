package com.rain.lab5;

import com.rain.lab5.database.XmlManager;
import com.rain.lab5.lib.ValidationException;
import com.rain.lab5.storage.Flat;
import com.rain.lab5.storage_management.LocalStorageManager;
import com.rain.lab5.storage.commands.GetAllCommand;
import com.rain.lab5.storage.marshalling_shapes.Flats;
import com.rain.lab5.ui.console.Console;
import com.rain.lab5.utils.IntIDGenerator;

import java.nio.file.Path;

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

        storageManager.handleCommand(new GetAllCommand(storageManager, (flats) -> {
          for (Flat flat: flats) {
            generator.addIDToBlackList(flat.getId());
          }
        }));
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
