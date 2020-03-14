package lab5.lib;

public interface Command {
  void execute() throws ValidationException, NullPointerException;
  static String getInfo() {
    return "This is a common command";
  }
}
