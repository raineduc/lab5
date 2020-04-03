package com.rain.lab5.ui.console;

import java.util.Arrays;
import java.util.Stack;

public class CommandHistory {
  private Stack<String> commandStack = new Stack<>();

  public void push(String command) {
    commandStack.push(command);
  }
  public String pop() {
    return commandStack.pop();
  }

  public String[] getLastCommands(int number) {
    return Arrays.copyOfRange(commandStack.toArray(String[]::new), 0, Math.min(commandStack.size(), number));
  }
}
