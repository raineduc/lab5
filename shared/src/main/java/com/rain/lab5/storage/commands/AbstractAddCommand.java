package com.rain.lab5.storage.commands;

import com.rain.lab5.lib.ValidationException;
import com.rain.lab5.storage.Flat;
import com.rain.lab5.storage.FlatOptions;
import com.rain.lab5.storage.StorageManager;
import com.rain.lab5.utils.IDGenerator;

public abstract class AbstractAddCommand extends StorageCommand {
  private FlatOptions options;

  public AbstractAddCommand(StorageManager manager, FlatOptions options) {
    super(manager);
    this.options = options;
  }

  public Flat generateFlat() throws ValidationException, NullPointerException {
    return new Flat(options, storageManager.getIdGenerator());
  }

  public Flat generateFlat(IDGenerator<Integer> idGenerator) throws ValidationException, NullPointerException {
    return new Flat(options, idGenerator);
  }
}
