package com.rain.lab5.ui.console.commands;

import com.rain.lab5.lib.Command;
import com.rain.lab5.ui.console.Console;

public class ExitCommand implements Command {
  private final Console console;
  private static String info = "завершить программу (без сохранения в файл)";

  public ExitCommand(Console console) {
    this.console = console;
  }

  public void execute() {
    console.exit();
  }

  public static String getInfo() {
    return info;
  }
}
