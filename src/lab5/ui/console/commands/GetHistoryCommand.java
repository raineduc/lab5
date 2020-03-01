package lab5.ui.console.commands;

import lab5.lib.Command;
import lab5.lib.ValidationException;
import lab5.ui.console.Console;

public class GetHistoryCommand implements Command {
  private Console console;

  public GetHistoryCommand(Console console) {
    this.console = console;
  }

  public void execute() {
    console.show(console.getLastCommands());
  }

  public static String getInfo() {
    return "выводит последние 7 команд (без их аргументов)";
  }
}
