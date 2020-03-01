package lab5.storage.commands;

public interface Invoker<T> {
  public void receive(T data);
}