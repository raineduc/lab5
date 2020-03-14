package lab5.ui.console.invokers;


import lab5.ui.console.Console;

import java.util.HashMap;

public class GetInfoInvoker extends ConsoleInvoker<HashMap<String, String>> {
  public GetInfoInvoker(Console console) {
    super(console);
  }

  @Override
  public void receive(HashMap<String, String> info) {
    for (String key: info.keySet()) {
      console.addCommandResult(key + info.get(key));
    }
  }
}
