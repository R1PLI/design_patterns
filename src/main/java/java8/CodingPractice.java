package java8;

import java8.classes.Camera;

import java.awt.*;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toSet;

public class CodingPractice {

  public Integer summingOfElements(final List<Integer> numbers, Integer multiplier) {
    return numbers.stream()
        .filter(NumericHelper::isEven)
        .mapToInt(number -> NumericHelper.multiplying(number, multiplier))
        .sum();
  }

  public Set<Integer> removeDuplicatesValuesInListMultiplyByTwo(final List<Integer> numbers) {
    return numbers.stream()
        .map(number -> number * 2)
        .collect(toSet());
  }

  //lightweight strategy
  public int totalValues(List<Integer> values, Predicate<Integer> selector) {
    return values.stream()
        .filter(selector)
        .reduce(0, Integer::sum);
  }

  public void doWork(int value, Function<Integer, Integer> func) {
    System.out.println(func.apply(value));
  }

  //decorator
  public void printSnap(Camera camera) {
    System.out.println(camera.snap(new Color(125,125,125)));
  }
}
