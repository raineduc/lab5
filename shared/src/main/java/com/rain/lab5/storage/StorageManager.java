package com.rain.lab5.storage;

import com.rain.lab5.storage.commands.StorageCommand;
import com.rain.lab5.lib.ValidationException;
import com.rain.lab5.utils.IDGenerator;

public interface StorageManager {
  void handleCommand(StorageCommand command) throws ValidationException;
  IDGenerator<Integer> getIdGenerator();
}
