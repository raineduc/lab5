package lab5.ui.console.invokers;

import lab5.storage.Flat;
import lab5.ui.console.Console;

import java.util.Collection;
import java.util.Stack;

public class ShowInvoker extends ConsoleInvoker<Collection<Flat>> {
  public ShowInvoker(Console console) {
    super(console);
  }

  @Override
  public void receive(Collection<Flat> flats) {
    for (Flat flat: flats) {
      console.show(flat.toString());
    }
  }
}
