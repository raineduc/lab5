package lab5.storage;

import lab5.utils.IDGenerator;

public class FlatOptions {
  public String name;
  public int area;
  public Integer numberOfRooms;
  public boolean balcony;
  public double timeToMetroByTransport;
  public View view;
  public String houseName;
  public Coordinates coordinates;
  public IDGenerator<Integer> idGenerator;
  public Integer houseYear;

  public FlatOptions(String name,
                     int area,
                     Integer numberOfRooms,
                     boolean balcony,
                     double timeToMetroByTransport,
                     View view,
                     String houseName,
                     Integer houseYear,
                     Coordinates coordinates
  ) {
    this.name = name;
    this.area = area;
    this.numberOfRooms = numberOfRooms;
    this.balcony = balcony;
    this.timeToMetroByTransport = timeToMetroByTransport;
    this.view = view;
    this.houseName = houseName;
    this.houseYear = houseYear;
    this.coordinates = coordinates;
  }
}
