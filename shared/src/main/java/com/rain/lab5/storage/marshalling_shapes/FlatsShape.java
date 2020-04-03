package com.rain.lab5.storage.marshalling_shapes;

import java.util.LinkedHashMap;

public class FlatsShape {

  private LinkedHashMap<Integer, FlatShape> flats;

  public LinkedHashMap<Integer, FlatShape> getFlats() {
    return flats;
  }

  public void setFlats(LinkedHashMap<Integer, FlatShape> flats) {
    this.flats = flats;
  }
}
