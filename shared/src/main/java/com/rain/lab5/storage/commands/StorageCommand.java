package com.rain.lab5.storage.commands;

import com.rain.lab5.lib.Command;
import com.rain.lab5.lib.ValidationException;
import com.rain.lab5.storage.FlatStorage;
import com.rain.lab5.storage.StorageManager;

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
