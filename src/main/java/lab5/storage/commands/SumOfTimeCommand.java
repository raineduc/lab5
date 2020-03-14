package lab5.storage.commands;

import lab5.lib.Command;
import lab5.storage.FlatStorage;

public class SumOfTimeCommand implements Command {
  private FlatStorage storage;
  private Invoker<Double> invoker;

  public SumOfTimeCommand(FlatStorage storage, Invoker<Double> invoker) {
    this.storage = storage;
    this.invoker = invoker;
  }

  public void execute() {
    invoker.receive(storage.sumOfTimeToMetroByTransport());
  }
}
