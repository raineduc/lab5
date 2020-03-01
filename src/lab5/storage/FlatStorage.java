package lab5.storage;

import lab5.lib.ValidationException;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlatStorage {
  private HashMap<String, String> info = new HashMap<>();
  private LinkedHashMap<Integer, Flat> storage = new LinkedHashMap<>();
  private Date initializationDate = new Date();

  public FlatStorage() {
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
    storage.replace(flat.getId(), flat);
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

  public List<Flat> getAllDescending() {
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
}
