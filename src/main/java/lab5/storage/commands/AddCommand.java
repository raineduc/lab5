package lab5.storage.commands;

import lab5.lib.ValidationException;
import lab5.storage.*;

public class AddCommand extends AbstractAddCommand {
    private FlatStorage storage;
    private static String info = "добавить новый элемент в коллекцию";

    public AddCommand(FlatOptions options, FlatStorage storage) {
      super(options, storage);
      this.storage = storage;
    }

    public void execute() throws ValidationException, NullPointerException {
      Flat flat = this.generateFlat();
      storage.addFlat(flat);
    }

    public static String getInfo() {
      return info;
    }
}
