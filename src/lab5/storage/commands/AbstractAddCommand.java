package lab5.storage.commands;

import lab5.lib.Command;
import lab5.lib.ValidationException;
import lab5.storage.*;
import lab5.utils.IDGenerator;
import lab5.utils.IntIDGenerator;

public abstract class AbstractAddCommand implements Command {
  private String name;
  private  Coordinates coordinates;
  private View view;
  private House house;
  private int area;
  private Integer numberOfRoms;
  private boolean balcony;
  private double timeToMetroByTransport;
  private String houseName;
  private Integer houseYear;

  public AbstractAddCommand(String name,
                            int area,
                            Integer numberOfRooms,
                            boolean balcony,
                            double timeToMetroByTransport,
                            View view,
                            String houseName,
                            Integer houseYear,
                            Coordinates coordinates) {
    this.name = name;
    this.coordinates = coordinates;
    this.view = view;
    this.houseName = houseName;
    this.houseYear = houseYear;
    this.area = area;
    this.numberOfRoms = numberOfRooms;
    this.balcony = balcony;
    this.timeToMetroByTransport = timeToMetroByTransport;
  }

  public AbstractAddCommand(FlatOptions options) {
    this.name = options.name;
    this.coordinates = options.coordinates;
    this.view = options.view;
    this.houseName = options.houseName;
    this.houseYear = options.houseYear;
    this.area = options.area;
    this.numberOfRoms = options.numberOfRooms;
    this.balcony = options.balcony;
    this.timeToMetroByTransport = options.timeToMetroByTransport;
  }

  public House getHouse() {
    return house;
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

  public View getView() {
    return view;
  }

  public Integer getNumberOfRoms() {
    return numberOfRoms;
  }

  public boolean isBalcony() {
    return balcony;
  }

  public double getTimeToMetroByTransport() {
    return timeToMetroByTransport;
  }

  public Flat generateFlat() throws ValidationException, NullPointerException {
    IDGenerator<Integer> idGenerator = new IntIDGenerator();
    Flat flat = new Flat(
            name,
            area,
            numberOfRoms,
            balcony,
            timeToMetroByTransport,
            view,
            houseName,
            houseYear,
            coordinates,
            idGenerator
    );

    return flat;
  }

  public Flat generateFlat(IDGenerator<Integer> idGenerator) throws ValidationException, NullPointerException {
    Flat flat = new Flat(
            name,
            area,
            numberOfRoms,
            balcony,
            timeToMetroByTransport,
            view,
            houseName,
            houseYear,
            coordinates,
            idGenerator
    );

    return flat;
  }
}
