package lab5.ui.console;

public class MnemonicDefinition {
  private String syntax;
  private String description;
  private String mnemonic;

  public MnemonicDefinition(String mnemonic, String description) {
    this.syntax = mnemonic;
    this.mnemonic = mnemonic;
    this.description = description;
  }

  public MnemonicDefinition(String mnemonic, String description, String argumentsSyntax) {
    this.syntax = mnemonic + " " + argumentsSyntax;
    this.mnemonic = mnemonic;
    this.description = description;
  }

  public String getMnemonic() {
    return mnemonic;
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
