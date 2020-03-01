package lab5.ui.console.invokers;

import lab5.storage.commands.Invoker;
import lab5.ui.console.Console;

public abstract class ConsoleInvoker<T> implements Invoker<T> {
  protected Console console;

  public ConsoleInvoker(Console console) {
    this.console = console;
  }
}
