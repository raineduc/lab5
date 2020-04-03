package com.rain.lab5.ui.console.commands;

import com.rain.lab5.lib.Command;
import com.rain.lab5.lib.ValidationException;
import com.rain.lab5.ui.console.Console;

import java.nio.file.Path;

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
