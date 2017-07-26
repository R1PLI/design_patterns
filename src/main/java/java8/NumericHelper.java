package java8;

import java.util.Random;
import java.util.UUID;

public class NumericHelper {
  public static boolean isEven(int number) {
    return number % 2 == 0;
  }

  public static Integer multiplying(Integer value, Integer multiply) {
    return value * multiply;
  }

  public static boolean isOdd(int number) {
    return number % 2 != 0;
  }

  public static int getRandomNumber() {
    Random random = new Random();
    return 1 + random.nextInt(100);
  }

  public static UUID getRandomUUID() {
    return UUID.randomUUID();
  }
}
