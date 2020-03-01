package lab5.ui.console.invokers;

import lab5.ui.console.Console;

public class SumOfTimeInvoker extends ConsoleInvoker<Double> {
  public SumOfTimeInvoker(Console console) {
    super(console);
  }

  public void receive(Double sum) {
    console.show(sum.toString());
  }
}
