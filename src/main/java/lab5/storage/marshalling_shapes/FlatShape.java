package lab5.storage.marshalling_shapes;

import lab5.lib.ValidationException;
import lab5.storage.Coordinates;
import lab5.storage.Flat;
import lab5.storage.House;
import lab5.storage.View;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement(name = "flatShape")
@XmlAccessorType(XmlAccessType.FIELD)
public class FlatShape {
  public Integer id;
  public String name;
  public CoordinatesShape coordinates;
  public String creationDate;
  public Integer area;
  public Integer numberOfRooms;
  public Boolean balcony;
  public Double timeToMetroByTransport;
  public View view;
  public HouseShape house;
}
