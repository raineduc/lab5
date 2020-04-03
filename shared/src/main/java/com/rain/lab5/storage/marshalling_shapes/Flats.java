package com.rain.lab5.storage.marshalling_shapes;

import com.rain.lab5.storage.Flat;
import com.rain.lab5.storage.jaxb_adapters.FlatsAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.LinkedHashMap;

@XmlRootElement(name="flatRoot")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flats {

  @XmlJavaTypeAdapter(FlatsAdapter.class)
  private LinkedHashMap<Integer, Flat> flats;

  public LinkedHashMap<Integer, Flat> getFlats() {
    return flats;
  }

  public void setFlats(LinkedHashMap<Integer, Flat> flats) {
    this.flats = flats;
  }
}
