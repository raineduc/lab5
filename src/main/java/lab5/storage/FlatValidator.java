package lab5.storage;

import lab5.lib.ValidationException;
import org.jetbrains.annotations.NotNull;

public class FlatValidator {
  public static void validate(String name,
                              Coordinates coordinates,
                              int area,
                              View view,
                              Integer numberOfRooms,
                              double timeToMetroByTransport,
                              House house) throws ValidationException, NullPointerException {
    FlatValidator.validateName(name);
    FlatValidator.validateCoordinates(coordinates);
    FlatValidator.validateArea(area);
    FlatValidator.validateView(view);
    FlatValidator.validateNumberOfRooms(numberOfRooms);
    FlatValidator.validateTimeToMetroByTransport(timeToMetroByTransport);
    FlatValidator.validateHouse(house);
  }
  public static void validateName(String name) throws ValidationException {
    if (name == null) {
      throw new ValidationException("Name must not be null");
    }

    if (name.length() == 0) {
      throw new ValidationException("SpaceMarine's name should not be empty");
    }
  }
  public static void validateCoordinates(Coordinates coordinates) throws ValidationException {
    if (coordinates.getXCoordinate() > 528) {
      throw new ValidationException("X coordinate has max value is 528");
    }

    if (coordinates.getYCoordinate() == null) {
      throw new ValidationException("Y coordinate must not be null");
    }

    if (coordinates.getYCoordinate() > 743) {
      throw new ValidationException("Y coordinate has max value is 743");
    }
  }
  public static void validateArea(int area) throws ValidationException {
    if (area <= 0 || area > 707) {
      throw new ValidationException("Area must have value in interval (0,707)");
    }
  }

  public static void validateNumberOfRooms(Integer numberOfRooms) throws ValidationException {
    if (numberOfRooms <= 0 || numberOfRooms > 11) {
      throw new ValidationException("number of rooms must have value in interval (0,11)");
    }
  }

  public static void validateTimeToMetroByTransport(double timeToMetroByTransport) throws ValidationException {
    if (timeToMetroByTransport <= 0 || timeToMetroByTransport >= 11) {
      throw new ValidationException("Time to metro by transport  must have value in interval (0,11)");
    }
  }

  public static void validateView(View view) throws ValidationException {
    if (view == null) {
      throw new ValidationException("View must not be null");
    }
  }
  public static void validateHouse(House house) throws ValidationException {
    if (house == null) {
      throw new ValidationException("House must not be null");
    }

    validateHouseName(house.getName());
    validateHouseYear(house.getYear());
  }

  public static void validateHouseName(String houseName) throws ValidationException {
    if (houseName == null) {
      throw new ValidationException("House's name must not be null");
    }
  }
  public static void validateHouseYear(Integer year) throws ValidationException {
    if (year == null) {
      throw new ValidationException("House's year must not be null");
    }

    if (year <= 0) {
      throw new ValidationException("House's year must be positive");
    }
  }

  public static void validateID(int id) throws ValidationException {
    if (id < 0) {
      throw new ValidationException("id must be positive");
    }
  }
}
