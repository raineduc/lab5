package lab5.storage;

import lab5.lib.ValidationException;
import org.jetbrains.annotations.NotNull;

public class FlatValidator {
  public static void validate(String name,
                              Coordinates coordinates,
                              int area,
                              View view,
                              House house) throws ValidationException, NullPointerException {
    FlatValidator.validateName(name);
    FlatValidator.validateCoordinates(coordinates);
    FlatValidator.validateArea(area);
    FlatValidator.validateView(view);
    FlatValidator.validateHouse(house);
  }
  public static void validateName(@NotNull String name) throws ValidationException, NullPointerException {
    if (name.length() == 0) {
      throw new ValidationException("SpaceMarine's name should not be empty");
    }
  }
  public static void validateCoordinates(Coordinates coordinates) throws ValidationException, NullPointerException {
    if (coordinates.getXCoordinate() > 528) {
      throw new ValidationException("X coordinate has max value is 528");
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
    if (timeToMetroByTransport <= 0) {
      throw new ValidationException("Time to metro by transport  must have value in interval (0,11)");
    }
  }

  public static void validateView(View view) throws NullPointerException {
    if (view == null) {
      throw new NullPointerException("View must not be null");
    }
  }
  public static void validateHouse(House house) throws NullPointerException {
    if (house == null) {
      throw new NullPointerException("House must not be null");
    }
  }
}
