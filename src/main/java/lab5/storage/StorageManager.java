package lab5.storage;

import lab5.lib.ValidationException;
import lab5.storage.commands.StorageCommand;
import lab5.utils.IDGenerator;

public interface StorageManager {
  void handleCommand(StorageCommand command) throws ValidationException;
  IDGenerator<Integer> getIdGenerator();
}
