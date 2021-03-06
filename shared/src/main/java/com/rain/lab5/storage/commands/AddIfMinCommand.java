package com.rain.lab5.storage.commands;

import com.rain.lab5.lib.ValidationException;
import com.rain.lab5.storage.Flat;
import com.rain.lab5.storage.FlatOptions;
import com.rain.lab5.storage.FlatStorage;
import com.rain.lab5.storage.StorageManager;

public class AddIfMinCommand extends AbstractAddCommand {
  private static String info = "добавить новый элемент в коллекцию, " +
          "если его значение меньше, чем у наименьшего элемента этой коллекции";

  public AddIfMinCommand(StorageManager manager, FlatOptions options) {
    super(manager, options);
  }

  @Override
  public void execute(FlatStorage storage) throws ValidationException, NullPointerException {
    Flat flat = this.generateFlat();
    storage.addFlatIf(flat, (map) -> {
      boolean isMin = true;
      for (Flat currentFlat: map.values()) {
        if (currentFlat.getArea() < flat.getArea()) {
          isMin = false;
          break;
        }
      }
      return isMin;
    });
  }

  public static String getInfo() {
    return info;
  }
}
