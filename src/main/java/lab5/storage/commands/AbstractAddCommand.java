package lab5.storage.commands;

import lab5.lib.Command;
import lab5.lib.ValidationException;
import lab5.storage.*;
import lab5.utils.IDGenerator;
import lab5.utils.IntIDGenerator;

public abstract class AbstractAddCommand implements Command {
  private FlatStorage storage;
  private FlatOptions options;


  public AbstractAddCommand(FlatOptions options, FlatStorage storage) {
    this.storage = storage;
    this.options = options;
  }

  public Flat generateFlat() throws ValidationException, NullPointerException {
    return new Flat(options, storage.getGenerator());
  }

  public Flat generateFlat(IDGenerator<Integer> idGenerator) throws ValidationException, NullPointerException {
    return new Flat(options, idGenerator);
  }
}
