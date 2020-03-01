package lab5.ui.console;

import lab5.lib.Command;
import lab5.lib.ValidationException;
import lab5.storage.FlatStorage;
import lab5.storage.commands.*;
import lab5.ui.console.commands.*;
import lab5.ui.console.invokers.CountInvoker;
import lab5.ui.console.invokers.GetInfoInvoker;
import lab5.ui.console.invokers.ShowInvoker;
import lab5.ui.console.invokers.SumOfTimeInvoker;

import static lab5.ui.console.Mnemonics.*;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class CommandParser {
  private GetInfoInvoker getInfoInvoker;
  private FlatStorage storage;
  private Console console;
  private ShowInvoker showInvoker;
  private SumOfTimeInvoker sumOfTimeInvoker;
  private CountInvoker countInvoker;
  private HashMap<String, MnemonicDefinition> mnemonicDefinitions = new HashMap<>();

  public CommandParser(Console console, FlatStorage storage) {
    this.storage = storage;
    this.console = console;
    this.showInvoker = new ShowInvoker(console);
    this.getInfoInvoker = new GetInfoInvoker(console);
    this.sumOfTimeInvoker = new SumOfTimeInvoker(console);
    this.countInvoker = new CountInvoker(console);
    this.createMnemonics();
  }

  public void createMnemonics() {
    mnemonicDefinitions.put(HELP, new MnemonicDefinition(HELP, HelpCommand.getInfo()));
    mnemonicDefinitions.put(INFO, new MnemonicDefinition(INFO, GetInfoCommand.getInfo()));
    mnemonicDefinitions.put(SHOW, new MnemonicDefinition(SHOW, GetAllCommand.getInfo()));
    mnemonicDefinitions.put(ADD, new MnemonicDefinition(ADD, AddCommand.getInfo(), "{element}"));
    mnemonicDefinitions.put(UPDATE, new MnemonicDefinition(UPDATE, UpdateCommand.getInfo(), "id {element}"));
    mnemonicDefinitions.put(REMOVE, new MnemonicDefinition(REMOVE, RemoveCommand.getInfo(), "id"));
    mnemonicDefinitions.put(CLEAR, new MnemonicDefinition(CLEAR, ClearCommand.getInfo()));
    mnemonicDefinitions.put(SAVE, new MnemonicDefinition(SAVE, SaveCommand.getInfo()));
    mnemonicDefinitions.put(EXECUTE, new MnemonicDefinition(EXECUTE, ExecuteCommand.getInfo()));
    mnemonicDefinitions.put(EXIT, new MnemonicDefinition(EXIT, ExitCommand.getInfo()));
    mnemonicDefinitions.put(ADD_IF_MIN, new MnemonicDefinition(ADD_IF_MIN, AddIfMinCommand.getInfo(), "{element}"));
    mnemonicDefinitions.put(REMOVE_LOWER, new MnemonicDefinition(REMOVE_LOWER, RemoveLowerCommand.getInfo()));
    mnemonicDefinitions.put(GET_HISTORY, new MnemonicDefinition(GET_HISTORY, GetHistoryCommand.getInfo()));
    mnemonicDefinitions.put(SUM_OF_TIME, new MnemonicDefinition(SUM_OF_TIME, RemoveLowerCommand.getInfo()));
    mnemonicDefinitions.put(COUNT, new MnemonicDefinition(COUNT, CountByNumberOfRoomsCommand.getInfo()));
    mnemonicDefinitions.put(PRINT_DESCENDING, new MnemonicDefinition(PRINT_DESCENDING, CountByNumberOfRoomsCommand.getInfo()));
  }

  public Entry<MnemonicDefinition, Command> parse(String line) throws NullPointerException, ValidationException {
    String[] command = line.trim().split("\\s+?");
    String mnemonic = command[0].toLowerCase();

    String[] arguments = command.length > 0 ? Arrays.copyOfRange(command, 1, command.length) : new String[0];

    return new SimpleEntry<MnemonicDefinition, Command>(mnemonicDefinitions.get(mnemonic), this.matchCommand(mnemonic, arguments));
  }

  public Command matchCommand(String mnemonic, String[] arguments) throws ArrayIndexOutOfBoundsException, ValidationException {
    try {
      switch (mnemonic) {
        case HELP:
          return new HelpCommand(mnemonicDefinitions.values(), console);
        case INFO:
          return new GetInfoCommand(storage, getInfoInvoker);
        case SHOW:
          return new GetAllCommand(storage, showInvoker);
        case EXIT:
          return new ExitCommand(console);
        case REMOVE:
          return new RemoveCommand(storage, Integer.parseInt(arguments[0]));
        case CLEAR:
          return new ClearCommand(storage);
        case GET_HISTORY:
          return new GetHistoryCommand(console);
        case SUM_OF_TIME:
          return new SumOfTimeCommand(storage, sumOfTimeInvoker);
        case COUNT:
          return new CountByNumberOfRoomsCommand(storage, Integer.parseInt(arguments[0]), countInvoker);
        case PRINT_DESCENDING:
          return new GetAllCommand(storage, showInvoker, true);
        default:
          throw new ValidationException("There is no such command");
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new ValidationException("Insufficient amount of arguments");
    } catch (NumberFormatException e) {
      throw new ValidationException("Provided number is too large or incorrect");
    }
  }
}

