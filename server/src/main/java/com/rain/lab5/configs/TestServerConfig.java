package com.rain.lab5.configs;

import com.rain.lab5.ServerConfiguration;

public class TestServerConfig implements ServerConfiguration {
  private final int PORT = 3000;

  public int getPort() {
    return PORT;
  }
}
