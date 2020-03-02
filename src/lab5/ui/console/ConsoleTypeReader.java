package lab5.ui.console;

import lab5.lib.ValidationException;
import lab5.lib.Validator;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleTypeReader {
  private Scanner scanner;
  private ConsoleMode mode;

  public ConsoleTypeReader(Scanner scanner, ConsoleMode mode) {
    this.mode = mode;
    this.scanner = scanner;
  }

  public int readInteger(Validator<ValidationException, Integer> validator, String varName) throws ValidationException, NoSuchElementException {
    try {
      int value = scanner.nextInt();
      validator.validate(value);
      scanner.nextLine();
      return value;
    } catch (InputMismatchException e) {
      if (mode == ConsoleMode.DIRECT_INPUT) scanner.next();
      throw new ValidationException("Provided integer " + varName + " is too large or incorrect");
    }
  }

  public double readDouble(Validator<ValidationException, Double> validator, String varName) throws ValidationException, NoSuchElementException {
    try {
      double value = scanner.nextDouble();
      validator.validate(value);
      scanner.nextLine();
      return value;
    } catch (InputMismatchException e) {
      if (mode == ConsoleMode.DIRECT_INPUT) scanner.next();
      throw new ValidationException("Provided double " + varName + " is too large or incorrect");
    }
  }

  public boolean readBoolean(Validator<ValidationException, Boolean> validator, String varName) throws ValidationException, InputMismatchException, NoSuchElementException {
    try {
      boolean value = scanner.nextBoolean();
      validator.validate(value);
      scanner.nextLine();
      return value;
    } catch (InputMismatchException e) {
      if (mode == ConsoleMode.DIRECT_INPUT) scanner.next();
      throw new ValidationException(varName + " boolean value is incorrect. Type true or false");
    }
  }

  public String readString(Validator<ValidationException, String> validator, String varName) throws ValidationException, NoSuchElementException {
    try {
      String value = scanner.nextLine();
      validator.validate(value);
      return value;
    } catch (InputMismatchException e) {
      if (mode == ConsoleMode.DIRECT_INPUT) scanner.next();
      throw new ValidationException("There are no strings more");
    }
  }

  public Long readLong(Validator<ValidationException, Long> validator, String varName) throws ValidationException, NoSuchElementException {
    try {
      Long value = scanner.nextLong();
      validator.validate(value);
      scanner.nextLine();
      return value;
    } catch (InputMismatchException e) {
      if (mode == ConsoleMode.DIRECT_INPUT) scanner.next();
      throw new ValidationException("Provided long " + varName + " is too large or incorrect");
    }
  }

  public <T extends Enum<T>> T readEnum(Class<T> enumClass) throws ValidationException, NoSuchElementException {
    String value = scanner.nextLine();
    try {
      return Enum.valueOf(enumClass, value);
    } catch (IllegalArgumentException e) {
      throw new ValidationException("Provided value does not correspond to existing enum constants" + " " + e.getMessage());
    }
  }
}
