package lab5.storage;

import lab5.lib.ValidationException;
import lab5.storage.jaxb_adapters.FlatsAdapter;
import lab5.utils.IDGenerator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
  private FlatOptions options;

  public Flat(String name,
              int area,
              Integer numberOfRooms,
              boolean balcony,
              double timeToMetroByTransport,
              View view,
              String houseName,
              Integer houseYear,
              Coordinates coordinates,
              IDGenerator<Integer> idGenerator) throws ValidationException, NullPointerException {
    this.house = new House(houseName, houseYear);

    FlatValidator.validate(name, coordinates, area, view, numberOfRooms, timeToMetroByTransport, house);

    this.id = idGenerator.generate();
    this.name = name;
    this.area = area;
    this.numberOfRooms = numberOfRooms;
    this.balcony = balcony;
    this.timeToMetroByTransport = timeToMetroByTransport;
    this.view = view;
    this.coordinates = coordinates;
    this.house = new House(houseName, houseYear);
  }

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

  public int getArea() {
    return area;
  }

  public String getName() {
    return name;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public boolean isBalcony() {
    return balcony;
  }

  public House getHouse() {
    return house;
  }

  public String toString() {
    return "{\n" +
            "  name: " + name + "\n" +
            "  view: " + view.toString() + "\n" +
            "  id: " + id + "\n" +
            "  number of rooms: " + numberOfRooms + "\n" +
            "  time to metro by transport: " + timeToMetroByTransport + "\n" +
            "  area: " + area + "\n" +
            "  balcony: " + balcony + "\n" +
            "  house:\n" + house.toString(2) + "\n" +
            "  coordinates:\n" + coordinates.toString(2) + "\n" +
            "}";
  }
}
