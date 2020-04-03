package com.rain.lab5.utils;

public class StringUtils {
  public static String repeat(int times, String str) {
    return new String(new char[times]).replace("\0", str);
  }
}
