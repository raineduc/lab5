package lab5.storage;

import static lab5.utils.StringUtils.repeat;

public class House {
  private String name; //Поле может быть null
  private Integer year; //Поле не может быть null, Значение поля должно быть больше 0
  private int numberOfFloors; //Максимальное значение поля: 29, Значение поля должно быть больше 0

  public String getName() {
    return name;
  }

  public Integer getYear() {
    return year;
  }

  public int getNumberOfFloors() {
    return numberOfFloors;
  }

  public String generateStringShape(int indent) {
    return repeat(indent, " ") + "{\n" +
            repeat(indent, " ") + "  year: " + this.getYear() + "\n" +
            repeat(indent, " ") + "  number of floors: " + this.getNumberOfFloors() + "\n" +
            repeat(indent, " ") + "}";

  }

  public String toString() {
    return this.generateStringShape(0);
  }

  public String toString(int indent) {
    return this.generateStringShape(indent);
  }
}
