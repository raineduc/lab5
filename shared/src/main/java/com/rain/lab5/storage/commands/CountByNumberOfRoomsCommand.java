package com.rain.lab5.storage.commands;

import com.rain.lab5.storage.StorageManager;
import com.rain.lab5.storage.FlatStorage;

public class CountByNumberOfRoomsCommand extends StorageCommand {
  private final Integer number;
  private final Invoker<Integer> invoker;
  private static String info = "вывести количество " +
          "элементов, значение поля numberOfRooms которых равно заданному";
  public CountByNumberOfRoomsCommand(StorageManager manager, Integer number, Invoker<Integer> invoker) {
    super(manager);
    this.invoker = invoker;
    this.number = number;
  }

  @Override
  public void execute(FlatStorage storage) throws NullPointerException {
    int count = storage.countByNumberOfRooms(number);
    invoker.receive(count);
  }

  public static String getInfo() {
    return info;
  }
}
