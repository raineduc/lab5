package lab5.ui.console.commands;

import lab5.lib.Command;
import lab5.storage.commands.Invoker;
import lab5.ui.console.Console;
import lab5.ui.console.MnemonicDefinition;

import java.util.ArrayList;
import java.util.Collection;

public class HelpCommand implements Command {
  private final Collection<MnemonicDefinition> definitions;
  private final Console console;
  private static String info = "вывести справку по доступным командам";

  public HelpCommand(Collection<MnemonicDefinition> definitions, Console console) {
    this.definitions = definitions;
    this.console = console;
  }

  public void execute() {
    for (MnemonicDefinition definition: definitions) {
      console.addCommandResult(definition.getInfo());
    }
  }

  public static String getInfo() {
    return info;
  }
}
