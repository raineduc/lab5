package com.rain.lab5.storage;

public class FlatOptions {
  private String name;
  private int area;
  private Integer numberOfRooms;
  private boolean balcony;
  private double timeToMetroByTransport;
  private View view;
  private String houseName;
  private Coordinates coordinates;
  private Integer houseYear;

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
