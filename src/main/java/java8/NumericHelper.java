package java8;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

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

  public static List<String> transformNumbers(final List<Double> numbers, final Function<Double, Double> fx) {
    return numbers.stream()
        .map(fx)
        .map(Object::toString)
        .collect(Collectors.toList());
  }

  public static boolean customCompareFunction(BiPredicate<Integer, Integer> biPredicate, Integer value1, Integer value2) {
    return biPredicate.test(value1, value2);
  }
}
