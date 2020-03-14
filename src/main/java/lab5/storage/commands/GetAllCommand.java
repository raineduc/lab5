package lab5.storage.commands;

import lab5.lib.Command;
import lab5.storage.Flat;
import lab5.lib.ValidationException;
import lab5.storage.FlatStorage;

import java.util.Collection;
import java.util.Stack;

public class GetAllCommand implements Command {
  private FlatStorage storage;
  private Invoker<Collection<Flat>> invoker;
  private static String info = "Получить все элементы коллекции";
  private boolean isDescending;
  public GetAllCommand(FlatStorage storage) {
    this.storage = storage;
  }

  public GetAllCommand(FlatStorage storage, Invoker<Collection<Flat>> invoker) {
    this.storage = storage;
    this.invoker = invoker;
    this.isDescending = false;
  }

  public GetAllCommand(FlatStorage storage, Invoker<Collection<Flat>> invoker, boolean isDescending) {
    this.storage = storage;
    this.invoker = invoker;
    this.isDescending = isDescending;
  }

  public void execute() throws ValidationException, NullPointerException {
    Collection<Flat> flats = isDescending ? storage.getAllDescending() : storage.getAll();
    invoker.receive(flats);
  }

  public static String getInfo() {
    return info;
  }
}
