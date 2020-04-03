package com.rain.lab5.ui.console.commands;

import com.rain.lab5.lib.Command;
import com.rain.lab5.ui.console.Console;

public class GetHistoryCommand implements Command {
  private Console console;

  public GetHistoryCommand(Console console) {
    this.console = console;
  }

  public void execute() {
    for (String command: console.getLastCommands()) {
      console.addCommandResult(command);
    }
  }

  public static String getInfo() {
    return "выводит последние 7 команд (без их аргументов)";
  }
}
