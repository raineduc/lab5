package com.rain.lab5.storage.commands;

import com.rain.lab5.storage.Flat;
import com.rain.lab5.storage.FlatStorage;
import com.rain.lab5.storage.StorageManager;

import java.util.Collection;

public class GetAllCommand extends StorageCommand {
  private Invoker<Collection<Flat>> invoker;
  private static String info = "Получить все элементы коллекции";
  private boolean isDescending;

  public GetAllCommand(StorageManager manager, Invoker<Collection<Flat>> invoker) {
    super(manager);
    this.invoker = invoker;
    this.isDescending = false;
  }

  public GetAllCommand(StorageManager manager, Invoker<Collection<Flat>> invoker, boolean isDescending) {
    super(manager);
    this.invoker = invoker;
    this.isDescending = isDescending;
  }

  public void execute(FlatStorage storage) throws NullPointerException {
    Collection<Flat> flats = isDescending ? storage.getAllDescending() : storage.getAll();
    invoker.receive(flats);
  }

  public static String getInfo() {
    return info;
  }
}
