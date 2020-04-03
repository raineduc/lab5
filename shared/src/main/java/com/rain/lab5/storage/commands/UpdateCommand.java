package com.rain.lab5.storage.commands;

import com.rain.lab5.lib.ValidationException;
import com.rain.lab5.storage.Flat;
import com.rain.lab5.storage.FlatOptions;
import com.rain.lab5.storage.FlatStorage;
import com.rain.lab5.storage.StorageManager;

public class UpdateCommand extends AbstractAddCommand {
  private static String info = "обновить значение элемента коллекции, id которого равен заданному";
  private int id;


  public UpdateCommand(StorageManager manager, FlatOptions options, int id) {
    super(manager, options);
    this.id = id;
  }

  public void execute(FlatStorage storage) throws ValidationException, NullPointerException {
    if (storage.get(id) == null) {
      throw new ValidationException("Space marine with specified id does not exist");
    }
    Flat flat = this.generateFlat();
    storage.updateFlat(flat, id);
  }

  public static String getInfo() {
    return info;
  }
}
