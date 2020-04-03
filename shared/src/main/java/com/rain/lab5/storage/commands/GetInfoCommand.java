package com.rain.lab5.storage.commands;

import com.rain.lab5.storage.FlatStorage;
import com.rain.lab5.storage.StorageManager;

import java.util.HashMap;

public class GetInfoCommand extends StorageCommand {
  private Invoker<HashMap<String, String>> invoker;
  private static String info = "Получить информацию о коллекции";

  public GetInfoCommand(StorageManager manager, Invoker<HashMap<String, String>> invoker) {
    super(manager);
    this.invoker = invoker;
  }

  @Override
  public void execute(FlatStorage storage) throws NullPointerException {
    HashMap<String, String> info = storage.getInfo();
    invoker.receive(info);
  }

  public static String getInfo() {
    return info;
  }
}
