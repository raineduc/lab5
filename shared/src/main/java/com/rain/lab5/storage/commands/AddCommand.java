package com.rain.lab5.storage.commands;

import com.rain.lab5.lib.ValidationException;
import com.rain.lab5.storage.Flat;
import com.rain.lab5.storage.FlatOptions;
import com.rain.lab5.storage.FlatStorage;
import com.rain.lab5.storage.StorageManager;

public class AddCommand extends AbstractAddCommand {
    private static String info = "добавить новый элемент в коллекцию";

    public AddCommand(StorageManager manager, FlatOptions options) {
      super(manager, options);
    }

    public void execute(FlatStorage storage) throws ValidationException, NullPointerException {
      Flat flat = this.generateFlat();
      storage.addFlat(flat);
    }

    public static String getInfo() {
      return info;
    }
}
