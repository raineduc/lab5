package lab5.storage.marshalling_shapes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="coordinates")
@XmlAccessorType(XmlAccessType.FIELD)
public class CoordinatesShape {
  public long x;
  public Long y;
}
