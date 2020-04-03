package com.rain.lab5.storage_management;

import com.rain.lab5.database.Manager;
import com.rain.lab5.storage.FlatStorage;
import com.rain.lab5.storage.StorageManager;
import com.rain.lab5.storage.commands.StorageCommand;
import com.rain.lab5.storage.marshalling_shapes.Flats;
import com.rain.lab5.lib.ValidationException;
import com.rain.lab5.utils.IDGenerator;

public class LocalStorageManager implements StorageManager {
  private FlatStorage storage;
  private IDGenerator<Integer> generator;

  public LocalStorageManager(Manager<Flats> databaseManager, IDGenerator<Integer> generator)
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
