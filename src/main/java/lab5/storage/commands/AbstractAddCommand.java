package lab5.storage.commands;

import lab5.lib.ValidationException;
import lab5.storage.*;
import lab5.utils.IDGenerator;

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
