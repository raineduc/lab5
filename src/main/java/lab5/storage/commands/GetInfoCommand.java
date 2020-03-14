package lab5.storage.commands;

import lab5.lib.Command;
import lab5.lib.ValidationException;
import lab5.storage.FlatStorage;

import java.util.HashMap;

public class GetInfoCommand implements Command {
  private Invoker<HashMap<String, String>> invoker;
  private FlatStorage storage;
  private static String info = "Получить информацию о коллекции";

  public GetInfoCommand(FlatStorage storage, Invoker<HashMap<String, String>> invoker) {
    this.storage = storage;
    this.invoker = invoker;
  }

  @Override
  public void execute() throws ValidationException, NullPointerException {
    HashMap<String, String> info = storage.getInfo();
    invoker.receive(info);
  }

  public static String getInfo() {
    return info;
  }
}
