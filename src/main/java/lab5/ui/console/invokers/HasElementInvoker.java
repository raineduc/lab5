package lab5.ui.console.invokers;

import lab5.lib.ValidationException;
import lab5.storage.commands.Invoker;

public class HasElementInvoker implements Invoker<Boolean> {
  private Boolean result;

  public void receive(Boolean data) {
    result = data;
  }

  public Boolean getResult() {
    return result;
  }
}
