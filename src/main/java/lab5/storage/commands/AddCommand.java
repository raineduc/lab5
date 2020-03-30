package lab5.storage.commands;

import lab5.lib.ValidationException;
import lab5.storage.*;

public class AddCommand extends AbstractAddCommand {
    private static String info = "добавить новый элемент в коллекцию";

    public AddCommand(StorageManager manager, FlatOptions options) {
      super(manager, options);
    }

    public void execute(FlatStorage storage) throws ValidationException, NullPointerException {
      Flat flat = this.generateFlat();
      storage.addFlat(flat);
    }

    public static String getInfo() {
      return info;
    }
}
