package lab5.storage;

import lab5.lib.ValidationException;
import lab5.utils.IDGenerator;

import java.time.LocalDateTime;

public class Flat implements Comparable<Flat>  {
  private int id;
  private LocalDateTime creationDate = LocalDateTime.now();
  private House house; //Поле не может быть null
  private FlatOptions options;

  public Flat(FlatOptions options, IDGenerator<Integer> idGenerator) throws ValidationException, NullPointerException {
    this.id = idGenerator.generate();
    this.house = new House(options.getHouseName(), options.getHouseYear());
    FlatValidator.validate(options, house);
    this.options = options;
  }

  public LocalDateTime getCreationDate() {
    return this.creationDate;
  }

  public View getView() {
    return options.getView();
  }

  public int getId() {
    return id;
  }

  public Integer getNumberOfRooms() {
    return options.getNumberOfRooms();
  }

  public double getTimeToMetroByTransport() {
    return options.getTimeToMetroByTransport();
  }

  public int compareTo(Flat flat) {
    return this.id - flat.getId();
  }

  public int getArea() {
    return options.getArea();
  }

  public String getName() {
    return options.getName();
  }

  public Coordinates getCoordinates() {
    return options.getCoordinates();
  }

  public boolean isBalcony() {
    return options.isBalcony();
  }

  public House getHouse() {
    return house;
  }

  public String toString() {
    return "{\n" +
            "  name: " + getName() + "\n" +
            "  view: " + getView().toString() + "\n" +
            "  id: " + id + "\n" +
            "  number of rooms: " + getNumberOfRooms() + "\n" +
            "  time to metro by transport: " + getTimeToMetroByTransport() + "\n" +
            "  area: " + getArea() + "\n" +
            "  balcony: " + isBalcony() + "\n" +
            "  house:\n" + house.toString(2) + "\n" +
            "  coordinates:\n" + getCoordinates().toString(2) + "\n" +
            "}";
  }
}
