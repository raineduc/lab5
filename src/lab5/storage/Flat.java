package lab5.storage;

import lab5.lib.ValidationException;
import lab5.utils.IDGenerator;

import java.time.LocalDateTime;

public class Flat implements Comparable<Flat>  {
  private int id;
  private String name;
  private Coordinates coordinates;
  private LocalDateTime creationDate = LocalDateTime.now();
  private int area;
  private Integer numberOfRooms; //Максимальное значение поля: 11, Значение поля должно быть больше 0
  private boolean balcony;
  private double timeToMetroByTransport; //Значение поля должно быть больше 0
  private View view; //Поле может быть null
  private House house; //Поле не может быть null

  public Flat(String name,
              int area,
              Integer numberOfRooms,
              boolean balcony,
              double timeToMetroByTransport,
              View view,
              House house,
              Coordinates coordinates,
              IDGenerator<Integer> idGenerator) throws ValidationException, NullPointerException {
    FlatValidator.validate(name, coordinates, area, view, house);

    this.id = idGenerator.generate();
    this.name = name;
    this.area = area;
    this.numberOfRooms = numberOfRooms;
    this.balcony = balcony;
    this.timeToMetroByTransport = timeToMetroByTransport;
    this.view = view;
    this.house = house;
    this.coordinates = coordinates;
  }



  public LocalDateTime getCreationDate() {
    return this.creationDate;
  }

  public View getView() {
    return view;
  }

  public int getId() {
    return id;
  }

  public Integer getNumberOfRooms() {
    return numberOfRooms;
  }

  public double getTimeToMetroByTransport() {
    return timeToMetroByTransport;
  }

  public int compareTo(Flat flat) {
    return this.id - flat.getId();
  }


  public String toString() {
    return "{\n" +
            "  view: " + view.toString() +
            "  id: " + id +
            "  number of rooms: " + numberOfRooms +
            "  time to metro by transport: " + timeToMetroByTransport +
            "  area: " + area +
            "  balcony: " + balcony +
            "  house:\n" + house.toString(2) + "\n" +
            "  coordinates:\n" + coordinates.toString(2) + "\n" +
            "}";
  }
}
