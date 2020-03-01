package lab5.utils;

import java.util.ArrayList;
import java.util.Random;

public class IntIDGenerator implements IDGenerator<Integer> {
  private ArrayList<Integer> blackList;

  public IntIDGenerator() {
    blackList = new ArrayList<>();
  }

  public IntIDGenerator(ArrayList<Integer> blackList) {
    this.blackList = blackList;
  }

  public void addIDToBlackList(Integer id) {
    blackList.add(id);
  }

  public Integer generate() {
    Integer generated = null;
    Random generator = new Random();

    do generated = generator.nextInt(); while (blackList.contains(generated));
    return generated;
  }
}
