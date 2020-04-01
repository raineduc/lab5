package lab5.storage;

import lab5.lib.ValidationException;
import lab5.storage.commands.StorageCommand;
import lab5.storage.marshalling_shapes.Flats;
import lab5.utils.IDGenerator;

public class LocalStorageManager implements StorageManager {
  private FlatStorage storage;
  private IDGenerator<Integer> generator;

  public LocalStorageManager(lab5.database.Manager<Flats> databaseManager, IDGenerator<Integer> generator)
          throws ValidationException {
    storage = new FlatStorage(databaseManager);
    this.generator = generator;
  }

  public LocalStorageManager(IDGenerator<Integer> generator) {
    storage = new FlatStorage();
    this.generator = generator;
  }

  public IDGenerator<Integer> getIdGenerator() {
    return generator;
  }

  public void handleCommand(StorageCommand command) throws ValidationException {
    command.execute(storage);
  }
}
