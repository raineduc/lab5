package com.rain.lab5.lib;

public interface Validator<T extends Throwable, S> {
  void validate(S var) throws T;
}
