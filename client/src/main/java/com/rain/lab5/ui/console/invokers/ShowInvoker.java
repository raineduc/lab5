package com.rain.lab5.ui.console.invokers;

import com.rain.lab5.storage.Flat;
import com.rain.lab5.ui.console.Console;

import java.util.Collection;

public class ShowInvoker extends ConsoleInvoker<Collection<Flat>> {
  public ShowInvoker(Console console) {
    super(console);
  }

  @Override
  public void receive(Collection<Flat> flats) {
    for (Flat flat: flats) {
      console.addCommandResult(flat.toString());
    }
  }
}
