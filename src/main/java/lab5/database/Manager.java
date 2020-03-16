package lab5.database;

import lab5.lib.ValidationException;

public interface Manager<T> {
  T read() throws ValidationException, SourceEmptyException;
  void save(T object) throws ValidationException;
}
