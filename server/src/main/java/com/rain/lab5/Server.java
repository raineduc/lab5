package com.rain.lab5;

import com.rain.lab5.storage.commands.StorageCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  private ServerSocket socket;
  private ServerConfiguration config;
  private final Logger logger = LoggerFactory.getLogger(Server.class);

  public Server(ServerConfiguration configuration) {
    this.config = configuration;
  }

  protected void handleRequests() throws IOException {
    try(Socket clientSocket = socket.accept(); ObjectInputStream objectInput = new ObjectInputStream(clientSocket.getInputStream())) {
      StorageCommand command = (StorageCommand) objectInput.readObject();
      logger.info("A command has been received");
    } catch (IOException e) {
      logger.error("Can not handle request, the reason of that: {}", e.getMessage());
    } catch (ClassNotFoundException e) {
      logger.error("Can not deserialize a requested command: {}", e.getMessage());
    }
  }

  public void open() throws IOException {
    socket = new ServerSocket(config.getPort());
    logger.info("Server has opened on port {}", config.getPort());
  }

  public void close() throws IOException {
    socket.close();
  }
}
