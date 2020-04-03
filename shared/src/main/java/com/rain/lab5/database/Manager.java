package com.rain.lab5.database;

import com.rain.lab5.lib.ValidationException;

public interface Manager<T> {
  T read() throws ValidationException, SourceEmptyException;
  void save(T object) throws ValidationException;
}
