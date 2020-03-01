package lab5.utils;

import java.util.Random;

public class RandomIntegerGenerator {
  public static int generate(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }
}
