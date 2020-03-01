package lab5.storage.commands;

import lab5.lib.Command;
import lab5.storage.View;
import lab5.lib.ValidationException;
import lab5.storage.FlatStorage;

public class CountByNumberOfRooms implements Command {
  private final FlatStorage storage;
  private final Integer number;
  private final Invoker<Integer> invoker;
  private static String info = "вывести количество " +
          "элементов, значение поля numberOfRooms которых равно заданному";
  public CountByNumberOfRooms(FlatStorage storage, Integer number, Invoker<Integer> invoker) {
    this.invoker = invoker;
    this.storage = storage;
    this.number = number;
  }

  @Override
  public void execute() throws ValidationException, NullPointerException {
    int count = storage.countByNumberOfRooms(number);
    invoker.receive(count);
  }

  public static String getInfo() {
    return info;
  }
}
