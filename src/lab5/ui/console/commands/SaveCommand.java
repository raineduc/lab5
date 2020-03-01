package lab5.ui.console.commands;

import lab5.lib.Command;
import lab5.storage.Flat;
import lab5.storage.FlatStorage;
import lab5.storage.commands.GetAllCommand;
import lab5.ui.console.Console;

import java.util.Collection;
import java.util.Stack;

public class SaveCommand implements Command {
  private final Console console;
  private final FlatStorage storage;
  private static String info = "сохранить коллекцию в файл";

  public SaveCommand(Console console, FlatStorage storage) {
    this.storage = storage;
    this.console = console;
  }

  public void execute() {
    GetAllCommand getAllCommand = new GetAllCommand(storage, (Collection<Flat> stack) -> {
      console.save(stack);
    });
    console.executeCommand(getAllCommand);
  }

  public static String getInfo() {
    return info;
  }
}
