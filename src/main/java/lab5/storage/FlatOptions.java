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

  public FlatOptions() {
    super();
  }

  public String getName() {
    return name;
  }

  public int getArea() {
    return area;
  }

  public Integer getNumberOfRooms() {
    return numberOfRooms;
  }

  public boolean isBalcony() {
    return balcony;
  }

  public double getTimeToMetroByTransport() {
    return timeToMetroByTransport;
  }

  public View getView() {
    return view;
  }

  public String getHouseName() {
    return houseName;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public Integer getHouseYear() {
    return houseYear;
  }

  public FlatOptions setName(String name) {
    this.name = name;
    return this;
  }

  public FlatOptions setArea(int area) {
    this.area = area;
    return this;
  }

  public FlatOptions setNumberOfRooms(Integer numberOfRooms) {
    this.numberOfRooms = numberOfRooms;
    return this;
  }

  public FlatOptions setBalcony(boolean balcony) {
    this.balcony = balcony;
    return this;
  }

  public FlatOptions setTimeToMetroByTransport(double timeToMetroByTransport) {
    this.timeToMetroByTransport = timeToMetroByTransport;
    return this;
  }

  public FlatOptions setView(View view) {
    this.view = view;
    return this;
  }

  public FlatOptions setHouseName(String houseName) {
    this.houseName = houseName;
    return this;
  }

  public FlatOptions setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
    return this;
  }

  public FlatOptions setHouseYear(Integer houseYear) {
    this.houseYear = houseYear;
    return this;
  }
}
