package lab5.storage.commands;

import lab5.storage.*;
import lab5.lib.ValidationException;

public class RemoveLowerCommand extends AbstractAddCommand {
  private static String info = "удалить из коллекции все элементы, значение поля meleeWeapon которого эквивалентно заданному";

  public RemoveLowerCommand(StorageManager manager, FlatOptions options) {
    super(manager, options);
  }

  @Override
  public void execute(FlatStorage storage) throws ValidationException, NullPointerException {
    Flat comparableFlat = this.generateFlat();
    storage.removeAllIf((flat) -> flat.compareTo(comparableFlat) < 0);
  }

  public static String getInfo() {
    return info;
  }
}
