package com.rain.lab5.ui.console.invokers;

import com.rain.lab5.ui.console.Console;

public class SumOfTimeInvoker extends ConsoleInvoker<Double> {
  public SumOfTimeInvoker(Console console) {
    super(console);
  }

  public void receive(Double sum) {
    console.addCommandResult(sum.toString());
  }
}
