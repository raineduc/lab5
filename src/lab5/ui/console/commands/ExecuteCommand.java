package lab5.ui.console.commands;

import lab5.lib.Command;
import lab5.ui.console.Console;

import java.nio.file.Paths;

public class ExecuteCommand implements Command {
  private final Console console;
  private final String filename;
  private static String info = " считать и исполнить скрипт из указанного файла";

  public ExecuteCommand(Console console, String filename) {
    this.filename = filename;
    this.console = console;
  }

  public void execute() {
    console.executeScript(Paths.get(filename));
  }

  public static String getInfo() {
    return info;
  }
}
