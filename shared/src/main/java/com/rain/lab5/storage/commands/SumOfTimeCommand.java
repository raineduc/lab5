package com.rain.lab5.storage.commands;

import com.rain.lab5.storage.FlatStorage;
import com.rain.lab5.storage.StorageManager;

public class SumOfTimeCommand extends StorageCommand {
  private Invoker<Double> invoker;

  public SumOfTimeCommand(StorageManager manager, Invoker<Double> invoker) {
    super(manager);
    this.invoker = invoker;
  }

  public void execute(FlatStorage storage) {
    invoker.receive(storage.sumOfTimeToMetroByTransport());
  }
}
