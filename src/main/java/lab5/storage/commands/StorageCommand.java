package lab5.storage.commands;

import lab5.lib.Command;
import lab5.lib.ValidationException;
import lab5.storage.FlatStorage;
import lab5.storage.StorageManager;

public abstract class StorageCommand implements Command {
  protected StorageManager storageManager;

  public StorageCommand(StorageManager manager) {
    this.storageManager = manager;
  }

  public void execute() throws ValidationException, NullPointerException {
    storageManager.handleCommand(this);
  }

  abstract public void execute(FlatStorage storage) throws  ValidationException, NullPointerException;
}
