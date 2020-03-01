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

  public AbstractAddCommand(String name,
                            int area,
                            Integer numberOfRooms,
                            boolean balcony,
                            double timeToMetroByTransport,
                            View view,
                            House house,
                            Coordinates coordinates) {
    this.name = name;
    this.coordinates = coordinates;
    this.view = view;
    this.house = house;
    this.area = area;
    this.numberOfRoms = numberOfRooms;
    this.balcony = balcony;
    this.timeToMetroByTransport = timeToMetroByTransport;
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
            house,
            coordinates,
            idGenerator
    );

    return flat;
  }
}
