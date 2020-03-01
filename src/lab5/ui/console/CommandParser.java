package lab5.ui.console;

import lab5.lib.Command;
import lab5.storage.FlatStorage;
import lab5.storage.commands.*;
import lab5.ui.console.commands.ExecuteCommand;
import lab5.ui.console.commands.ExitCommand;
import lab5.ui.console.commands.HelpCommand;
import lab5.ui.console.commands.SaveCommand;
import lab5.ui.console.invokers.GetInfoInvoker;
import lab5.ui.console.invokers.ShowInvoker;

import java.util.Arrays;
import java.util.HashMap;

public class CommandParser {
  private final HelpInvoker helpInvoker;
  private GetInfoInvoker getInfoInvoker;
  private FlatStorage storage;
  private Console console;
  private ShowInvoker showInvoker;
  private HashMap<String, MnemonicDefinition> mnemonicDefinitions = new HashMap<>();

  public CommandParser(Console console, FlatStorage storage) {
    this.storage = storage;
    this.console = console;
    this.showInvoker = new ShowInvoker(console);
    this.getInfoInvoker = new GetInfoInvoker(console);
    this.helpInvoker = new HelpInvoker(console);
    this.createMnemonics();
  }

  public void createMnemonics() {
    mnemonicDefinitions.put(Mnemonics.HELP, new MnemonicDefinition("help", HelpCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.INFO, new MnemonicDefinition("info", GetInfoCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.SHOW, new MnemonicDefinition("show", GetAllCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.ADD, new MnemonicDefinition("add {element}", AddCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.UPDATE, new MnemonicDefinition("update id {element}", UpdateCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.REMOVE, new MnemonicDefinition("remove_by_id id", RemoveCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.CLEAR, new MnemonicDefinition("clear", ClearCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.SAVE, new MnemonicDefinition("save", SaveCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.EXECUTE, new MnemonicDefinition("exit", ExecuteCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.EXIT, new MnemonicDefinition("exit", ExitCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.ADD_IF_MIN, new MnemonicDefinition("add_if_min {element}", AddIfMinCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.REMOVE_LOWER, new MnemonicDefinition(Mnemonics.REMOVE_LOWER, RemoveLowerCommand.getInfo()));
//    mnemonicDefinitions.put(Mnemonics.GET_HISTORY, new MnemonicDefinition("history", ));
    mnemonicDefinitions.put(Mnemonics.SUM_OF_TIME, new MnemonicDefinition(Mnemonics.SUM_OF_TIME, RemoveLowerCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.COUNT, new MnemonicDefinition(Mnemonics.COUNT, GetMinIdCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.PRINT_DESCENDING, new MnemonicDefinition(Mnemonics.PRINT_DESCENDING, CountByNumberOfRooms.getInfo()));
  }

  public Command parse(String line) {
    String[] command = line.trim().split("\\s+?");
    String mnemonic = command[0];
    String[] arguments = Arrays.copyOfRange(command, 1, command.length);
    return this.matchCommand(mnemonic, arguments);
  }

  public Command matchCommand(String mnemonic, String[] arguments) {
    Command command;
    switch (mnemonic) {
      case Mnemonics.HELP:
        command = new HelpCommand(mnemonicDefinitions.values(), console);
        break;
      case Mnemonics.INFO:
        command = new GetInfoCommand(storage, getInfoInvoker);
        break;
      case Mnemonics.SHOW:
        command = new GetAllCommand(storage, showInvoker);
        break;
      case Mnemonics.EXIT:
        command = new ExitCommand(console);
        break;
      default:
        command = null;
    }

    return command;
  }
}

