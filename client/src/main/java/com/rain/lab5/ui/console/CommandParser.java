package com.rain.lab5.ui.console;

import com.rain.lab5.lib.Command;
import com.rain.lab5.lib.ValidatedSupplier;
import com.rain.lab5.lib.ValidationException;
import com.rain.lab5.storage.*;
import com.rain.lab5.storage.commands.*;
import com.rain.lab5.ui.console.commands.ExecuteScriptCommand;
import com.rain.lab5.ui.console.commands.ExitCommand;
import com.rain.lab5.ui.console.commands.GetHistoryCommand;
import com.rain.lab5.ui.console.commands.HelpCommand;
import com.rain.lab5.ui.console.invokers.*;
import com.rain.lab5.storage.commands.SaveCommand;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandParser {
  private ConsoleTypeReader typeReader;
  private Scanner scanner;
  private GetInfoInvoker getInfoInvoker;
  private StorageManager storageManager;
  private Console console;
  private ShowInvoker showInvoker;
  private SumOfTimeInvoker sumOfTimeInvoker;
  private CountInvoker countInvoker;
  private HasElementInvoker hasElementInvoker;
  private HashMap<String, MnemonicDefinition> mnemonicDefinitions = new HashMap<>();

  public CommandParser(Console console, StorageManager storageManager) {
    this.scanner = console.getScanner();
    this.typeReader = new ConsoleTypeReader(scanner, console.getMode());
    this.storageManager = storageManager;
    this.console = console;
    this.showInvoker = new ShowInvoker(console);
    this.getInfoInvoker = new GetInfoInvoker(console);
    this.sumOfTimeInvoker = new SumOfTimeInvoker(console);
    this.countInvoker = new CountInvoker(console);
    this.hasElementInvoker = new HasElementInvoker();
    this.createMnemonics();
  }

  public void createMnemonics() {
    mnemonicDefinitions.put(Mnemonics.HELP, new MnemonicDefinition(Mnemonics.HELP, HelpCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.INFO, new MnemonicDefinition(Mnemonics.INFO, GetInfoCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.SHOW, new MnemonicDefinition(Mnemonics.SHOW, GetAllCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.ADD, new MnemonicDefinition(Mnemonics.ADD, AddCommand.getInfo(), "{element}"));
    mnemonicDefinitions.put(Mnemonics.UPDATE, new MnemonicDefinition(Mnemonics.UPDATE, UpdateCommand.getInfo(), "id {element}"));
    mnemonicDefinitions.put(Mnemonics.REMOVE, new MnemonicDefinition(Mnemonics.REMOVE, RemoveCommand.getInfo(), "id"));
    mnemonicDefinitions.put(Mnemonics.CLEAR, new MnemonicDefinition(Mnemonics.CLEAR, ClearCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.SAVE, new MnemonicDefinition(Mnemonics.SAVE, SaveCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.EXECUTE, new MnemonicDefinition(Mnemonics.EXECUTE, ExecuteScriptCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.EXIT, new MnemonicDefinition(Mnemonics.EXIT, ExitCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.ADD_IF_MIN, new MnemonicDefinition(Mnemonics.ADD_IF_MIN, AddIfMinCommand.getInfo(), "{element}"));
    mnemonicDefinitions.put(Mnemonics.REMOVE_LOWER, new MnemonicDefinition(Mnemonics.REMOVE_LOWER, RemoveLowerCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.GET_HISTORY, new MnemonicDefinition(Mnemonics.GET_HISTORY, GetHistoryCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.SUM_OF_TIME, new MnemonicDefinition(Mnemonics.SUM_OF_TIME, RemoveLowerCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.COUNT, new MnemonicDefinition(Mnemonics.COUNT, CountByNumberOfRoomsCommand.getInfo()));
    mnemonicDefinitions.put(Mnemonics.PRINT_DESCENDING, new MnemonicDefinition(Mnemonics.PRINT_DESCENDING, CountByNumberOfRoomsCommand.getInfo()));
  }

  public Entry<MnemonicDefinition, Command> parse(String line) throws NullPointerException, ValidationException, NoSuchElementException {
    console.clearCommandResults();
    String[] command = line.trim().split("\\s+");
    String mnemonic = command[0].toLowerCase();

    typeReader.setScanner(scanner);

    String[] arguments = command.length > 0 ? Arrays.copyOfRange(command, 1, command.length) : new String[0];

    return new SimpleEntry<MnemonicDefinition, Command>(mnemonicDefinitions.get(mnemonic), this.matchCommand(mnemonic, arguments));
  }

  public Command matchCommand(String mnemonic, String[] arguments) throws ArrayIndexOutOfBoundsException, ValidationException, NoSuchElementException {
    FlatOptions options;
    try {
      switch (mnemonic) {
        case Mnemonics.HELP:
          return new HelpCommand(mnemonicDefinitions.values(), console);
        case Mnemonics.INFO:
          return new GetInfoCommand(storageManager, getInfoInvoker);
        case Mnemonics.SHOW:
          return new GetAllCommand(storageManager, showInvoker);
        case Mnemonics.EXIT:
          return new ExitCommand(console);
        case Mnemonics.REMOVE:
          return new RemoveCommand(storageManager, Integer.parseInt(arguments[0]));
        case Mnemonics.CLEAR:
          return new ClearCommand(storageManager);
        case Mnemonics.GET_HISTORY:
          return new GetHistoryCommand(console);
        case Mnemonics.SUM_OF_TIME:
          return new SumOfTimeCommand(storageManager, sumOfTimeInvoker);
        case Mnemonics.COUNT:
          return new CountByNumberOfRoomsCommand(storageManager, Integer.parseInt(arguments[0]), countInvoker);
        case Mnemonics.PRINT_DESCENDING:
          return new GetAllCommand(storageManager, showInvoker, true);
        case Mnemonics.ADD:
          return new AddCommand(storageManager, this.parseElement());
        case Mnemonics.UPDATE:
          int id = Integer.parseInt(arguments[0].trim());

          storageManager.handleCommand(new HasElementCommand(storageManager, id, hasElementInvoker));

          if (!hasElementInvoker.getResult()) {
            throw new ValidationException("Space marine with specified id does not exist");
          }
          return new UpdateCommand(storageManager, this.parseElement(), id);
        case Mnemonics.ADD_IF_MIN:
          return new AddIfMinCommand(storageManager, this.parseElement());
        case Mnemonics.REMOVE_LOWER:
          return new RemoveLowerCommand(storageManager, this.parseElement());
        case Mnemonics.EXECUTE:
          return new ExecuteScriptCommand(console, Path.of(arguments[0]));
        case Mnemonics.SAVE:
          return new SaveCommand(storageManager);
        default:
          throw new ValidationException("There is no such command");
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new ValidationException("Insufficient amount of arguments");
    } catch (NumberFormatException e) {
      throw new ValidationException("Provided argument is too large or incorrect");
    } catch (InvalidPathException e) {
      throw new ValidationException("Path is invalid");
    } catch (ValidationException e) {
      throw e;
    }
  }

  public FlatOptions parseElement() throws ValidationException, NoSuchElementException {
    FlatOptions flatOptions = new FlatOptions();

    String name = this.<String>read(() -> {
      console.show("Type a name of flat", ConsoleMode.DIRECT_INPUT);
      return typeReader.readString(FlatValidator::validateName, "name");
    });
    flatOptions.setName(name);
    boolean balcony = this.<Boolean>read(() -> {
      console.show("Does it have balcony?", ConsoleMode.DIRECT_INPUT);
      return typeReader.readBoolean((Boolean b) -> {
      }, "balcony");
    });
    flatOptions.setBalcony(balcony);
    Integer numberOfRooms = this.<Integer>read(() -> {
      console.show("Type number of rooms", ConsoleMode.DIRECT_INPUT);
      return typeReader.readInteger(FlatValidator::validateNumberOfRooms, "numberOfRooms");
    });
    flatOptions.setNumberOfRooms(numberOfRooms);
    double timeToMetroByTransport = this.<Double>read(() -> {
      console.show("How much time will it take to metro by transport?", ConsoleMode.DIRECT_INPUT);
      return typeReader.readDouble(FlatValidator::validateTimeToMetroByTransport, "timeToMetroByTransport");
    });
    flatOptions.setTimeToMetroByTransport(timeToMetroByTransport);
    View view = this.<View>read(() -> {
      console.show("which view does it have? Choose one of these", ConsoleMode.DIRECT_INPUT);
      console.show(View.values(), ConsoleMode.DIRECT_INPUT);
      return typeReader.readEnum(View.class);
    });
    flatOptions.setView(view);
    String houseName = this.<String>read(() -> {
      console.show("Type house's name", ConsoleMode.DIRECT_INPUT);
      return typeReader.readString(FlatValidator::validateHouseName, "houseName");
    });
    flatOptions.setHouseName(name);
    Integer houseYear = this.<Integer>read(() -> {
      console.show("Type house's year", ConsoleMode.DIRECT_INPUT);
      return typeReader.readInteger(FlatValidator::validateHouseYear, "houseYear");
    });
    flatOptions.setHouseYear(houseYear);
    int area = this.<Integer>read(() -> {
      console.show("Type area", ConsoleMode.DIRECT_INPUT);
      return typeReader.readInteger(FlatValidator::validateArea, "area");
    });
    flatOptions.setArea(area);
    Coordinates coordinates = this.<Coordinates>read(() -> {
      console.show("Now type a position of the house", ConsoleMode.DIRECT_INPUT);
      return parseCoordinates();
    });
    flatOptions.setCoordinates(coordinates);

    return flatOptions;
  }


  public <T> T read(ValidatedSupplier<T> reader) throws ValidationException {
    T received;
    if (console.getMode() == ConsoleMode.DIRECT_INPUT) {
      while (true) {
        try {
          received = reader.get();
          break;
        } catch (ValidationException e) {
          console.show(e.getMessage());
          console.show("Try again");
        }
      }
    } else {
      received = reader.get();
    }

    return received;
  }

  public Coordinates parseCoordinates() throws ValidationException {
    console.show("Type x coordinate", ConsoleMode.DIRECT_INPUT);
    long xCoordinate = typeReader.readLong((Long i) -> {
    }, "x coordinate");
    console.show("Type y coordinate", ConsoleMode.DIRECT_INPUT);
    Long yCoordinate = typeReader.readLong((Long i) -> {
    }, "y coordinate");
    Coordinates coordinates = new Coordinates(xCoordinate, yCoordinate);
    FlatValidator.validateCoordinates(coordinates);
    return coordinates;
  }

  public void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }
}

