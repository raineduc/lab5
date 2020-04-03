package com.rain.lab5.storage.commands;

import com.rain.lab5.lib.ValidationException;
import com.rain.lab5.storage.FlatStorage;
import com.rain.lab5.storage.FlatValidator;
import com.rain.lab5.storage.StorageManager;

public class RemoveCommand extends StorageCommand {
  private int id;
  private static String info = "удалить элемент из коллекции по его id";
  public RemoveCommand(StorageManager manager, int id) {
    super(manager);
    this.id = id;
  }

  @Override
  public void execute(FlatStorage storage) throws ValidationException, NullPointerException {
    FlatValidator.validateID(id);
    storage.removeFlat(id);
  }

  public static String getInfo() {
    return info;
  }
}
