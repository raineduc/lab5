package lab5.ui.console.commands;

import lab5.lib.Command;
import lab5.lib.ValidationException;
import lab5.ui.console.Console;

import java.io.IOException;
import java.nio.file.Path;
import java.util.NoSuchElementException;

public class ExecuteScriptCommand implements Command {
  private Console console;
  private Path filename;
  private static String info = "считать и исполнить скрипт из указанного файла";

  public ExecuteScriptCommand(Console console, Path filename) {
    this.console = console;
    this.filename = filename;
  }

  public void execute() throws ValidationException {
    console.executeScript(filename);
    console.clearCommandResults();;
  }

  public static String getInfo() {
    return info;
  }
}
