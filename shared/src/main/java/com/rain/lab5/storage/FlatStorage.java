package com.rain.lab5.storage;

import com.rain.lab5.database.Manager;
import com.rain.lab5.storage.marshalling_shapes.Flats;
import com.rain.lab5.database.SourceEmptyException;
import com.rain.lab5.lib.ValidationException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@XmlRootElement(name = "flats")
@XmlAccessorType(XmlAccessType.NONE)
public class FlatStorage {
  private HashMap<String, String> info = new HashMap<>();
  @XmlElement()
  private LinkedHashMap<Integer, Flat> storage;
  private Date initializationDate = new Date();
  private Manager<Flats> databaseManager;

  public FlatStorage(Manager<Flats> databaseManager)
          throws ValidationException {
    try {
      storage = databaseManager.read().getFlats();
      for (Flat flat: storage.values()) {
        FlatValidator.validate(
                flat.getName(),
                flat.getCoordinates(),
                flat.getArea(),
                flat.getView(),
                flat.getNumberOfRooms(),
                flat.getTimeToMetroByTransport(),
                flat.getHouse()
        );
      }
    } catch (SourceEmptyException e) {
      storage = new LinkedHashMap<>();
    }
    catch (ValidationException | NullPointerException e) {
      throw new ValidationException("Source has invalid data");
    }
    info.put("type", "LinkedHashMap");
    info.put("date", initializationDate.toString());
    info.put("size", "0");

    this.databaseManager = databaseManager;
  }

  public FlatStorage() {
    storage = new LinkedHashMap<>();
    info.put("type", "LinkedHashMap");
    info.put("date", initializationDate.toString());
    info.put("size", "0");
  }

  public void addFlat(Flat flat) {
    storage.put(flat.getId(), flat);
  }

  public boolean addFlatIf(Flat flat, Predicate<LinkedHashMap<Integer, Flat>> flatPredicate) {
    if (flatPredicate.test(storage)) {
       storage.put(flat.getId(), flat);
       return true;
    }

    return false;
  }

  public void updateFlat(Flat flat, int id) throws ValidationException {
    Flat currentFlat = null;
    for (Flat marine: storage.values()) {
      if (marine.getId() == id) {
        currentFlat = marine;
        break;
      }
    }
    if (currentFlat == null) {
      throw new ValidationException("Space marine with specified id does not exist");
    }
    storage.replace(currentFlat.getId(), flat);
  }

  public void removeFlat(int id) {
    storage.remove(id);
  }

  public void removeAllIf(Predicate<Flat> flatPredicate) {
    for (int key: storage.keySet()) {
      if (flatPredicate.test(storage.get(key))) {
        storage.remove(key);
      }
    }
  }

  public int countByNumberOfRooms(Integer number) {
    int count = 0;
    for (Flat flat: storage.values()) {
      if (flat.getNumberOfRooms() == number) {
        count += 1;
      }
    }

    return count;
  }

  public double sumOfTimeToMetroByTransport() {
    double sum = 0;
    for (Flat flat: storage.values()) {
      sum += flat.getTimeToMetroByTransport();
    }

    return sum;
  }

  public Collection<Flat> getAllDescending() {
    return storage.values().stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
  }

  public Collection<Flat> getAll() {
    return storage.values();
  }

  public Map.Entry<Integer, Flat> getMin() {
    Set<Map.Entry<Integer, Flat>> entries = storage.entrySet();
    return Collections.min(entries, Comparator.comparing(obj -> obj.getValue().getId()));
  }

  public void clear() {
    storage.clear();
  }

  public HashMap<String, String> getInfo() {
    info.replace("size", ((Integer) storage.size()).toString());
    return info;
  }

  public Flat get(int id) {
    return storage.get(id);
  }

  public boolean has(Integer id) {
    if (storage.get(id) != null) return true;
    return false;
  }

  public void save() throws ValidationException {
    if (databaseManager == null) {
      throw new ValidationException("Database is not provided or not available");
    }

    Flats flats = new Flats();
    flats.setFlats(storage);

    databaseManager.save(flats);
  }
}
