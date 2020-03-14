package lab5;

import lab5.storage.FlatStorage;
import lab5.ui.console.Console;

public class Main {
  public static void main(String[] args) {
    FlatStorage storage = new FlatStorage();
    Console console = new Console(storage);
    console.open();
  }
}
