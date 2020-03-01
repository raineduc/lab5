package lab5.manager;

import lab5.lib.Command;

import java.util.Arrays;
import java.util.Stack;

public class CommandHistory {
  private Stack<Command> commandStack = new Stack<>();

  public void push(Command command) {
    commandStack.push(command);
  }
  public Command pop() {
    return commandStack.pop();
  }

  public Command[] getLastCommands(int number) {
    Command[] commands = new Command[number];
    return Arrays.copyOfRange(commandStack.toArray(n -> new Command[n]), 0, number);
  }
}
