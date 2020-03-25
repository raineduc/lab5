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

  public IDGenerator<Integer> getIdGenerator() {
    return idGenerator;
  }

  public Integer getHouseYear() {
    return houseYear;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setArea(int area) {
    this.area = area;
  }

  public void setNumberOfRooms(Integer numberOfRooms) {
    this.numberOfRooms = numberOfRooms;
  }

  public void setBalcony(boolean balcony) {
    this.balcony = balcony;
  }

  public void setTimeToMetroByTransport(double timeToMetroByTransport) {
    this.timeToMetroByTransport = timeToMetroByTransport;
  }

  public void setView(View view) {
    this.view = view;
  }

  public void setHouseName(String houseName) {
    this.houseName = houseName;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public void setIdGenerator(IDGenerator<Integer> idGenerator) {
    this.idGenerator = idGenerator;
  }

  public void setHouseYear(Integer houseYear) {
    this.houseYear = houseYear;
  }
}
