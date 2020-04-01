package lab5.storage.commands;

import lab5.storage.FlatStorage;
import lab5.storage.StorageManager;

public class HasElementCommand extends StorageCommand {
  private final Invoker<Boolean> invoker;
  private final Integer id;
  public HasElementCommand(StorageManager manager, Integer id, Invoker<Boolean> invoker) {
    super(manager);
    this.id = id;
    this.invoker = invoker;
  }

  public void execute(FlatStorage storage) {
    invoker.receive(storage.has(id));
  }
}
