package lab5.storage.marshalling_shapes;

import lab5.storage.Flat;
import lab5.storage.jaxb_adapters.FlatsAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
