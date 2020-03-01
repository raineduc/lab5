package lab5.ui.console;

public class MnemonicDefinition {
  private String syntax;
  private String description;

  public MnemonicDefinition(String syntax, String description) {
    this.syntax = syntax;
    this.description = description;
  }

  public String getSyntax() {
    return syntax;
  }

  public String getDescription() {
    return description;
  }

  public String getInfo() {
    return "|| " + this.getSyntax() + " || - " + this.getDescription();
  }
}
