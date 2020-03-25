package lab5.storage.jaxb_adapters;

import lab5.storage.Coordinates;
import lab5.storage.Flat;
import lab5.storage.FlatOptions;
import lab5.storage.marshalling_shapes.CoordinatesShape;
import lab5.storage.marshalling_shapes.FlatShape;
import lab5.storage.marshalling_shapes.FlatsShape;
import lab5.storage.marshalling_shapes.HouseShape;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatsAdapter extends XmlAdapter<FlatsShape, LinkedHashMap<Integer, Flat>> {
  @Override
  public LinkedHashMap<Integer, Flat> unmarshal(FlatsShape shape) throws Exception {
    LinkedHashMap<Integer, Flat> unmarshalledMap = new LinkedHashMap<>();
    for (Map.Entry<Integer, FlatShape> entry: shape.getFlats().entrySet()) {
      unmarshalledMap.put(entry.getKey(), createFlat(entry.getValue()));
    }
    return unmarshalledMap;
  }

  public FlatsShape marshal(LinkedHashMap<Integer, Flat> map) throws Exception {
    LinkedHashMap<Integer, FlatShape> marsalledMap = new LinkedHashMap<>(map.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey,
                    (Map.Entry<Integer, Flat> e) -> createFilledShape(e.getValue()))));

    FlatsShape shape = new FlatsShape();

    shape.setFlats(marsalledMap);

    return shape;
  }

  public Flat createFlat(FlatShape flatShape) throws Exception {
    FlatOptions options = new FlatOptions()
            .setName(flatShape.name)
            .setArea(flatShape.area)
            .setNumberOfRooms(flatShape.numberOfRooms)
            .setBalcony(flatShape.balcony)
            .setTimeToMetroByTransport(flatShape.timeToMetroByTransport)
            .setView(flatShape.view)
            .setHouseName(flatShape.house.name)
            .setHouseYear(flatShape.house.year)
            .setCoordinates(new Coordinates(flatShape.coordinates.x,
                    flatShape.coordinates.y));

    return new Flat(options, () -> flatShape.id);
  }

  public FlatShape createFilledShape(Flat flat) {
    FlatShape shape = new FlatShape();

    shape.area = flat.getArea();
    shape.balcony = flat.isBalcony();
    shape.name = flat.getName();
    shape.numberOfRooms = flat.getNumberOfRooms();
    shape.timeToMetroByTransport = flat.getTimeToMetroByTransport();
    shape.view = flat.getView();
    shape.house = new HouseShape();
    shape.house.name = flat.getHouse().getName();
    shape.house.year = flat.getHouse().getYear();
    shape.coordinates = new CoordinatesShape();
    shape.coordinates.x = flat.getCoordinates().getXCoordinate();
    shape.coordinates.y = flat.getCoordinates().getYCoordinate();
    shape.creationDate = flat.getCreationDate().toString();
    shape.id = flat.getId();

    return shape;
  }
}
