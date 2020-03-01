package lab5.ui.console.invokers;

import lab5.ui.console.Console;

public class CountInvoker extends ConsoleInvoker<Integer> {
  public CountInvoker(Console console) {
    super(console);
  }

  public void receive(Integer count) {
    console.show(count.toString());
  }
}