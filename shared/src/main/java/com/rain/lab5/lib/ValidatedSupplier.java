package com.rain.lab5.lib;

public interface ValidatedSupplier<T> {
  T get() throws ValidationException;
}
