package java8;

import java8.classes.Camera;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
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
    System.out.println(camera.snap(new Color(125, 125, 125)));
  }

  public Double imperativeStyleOfFindFirstDoubleValue(Double[] array) {
    Double result = 0.0;

    for (Double e : array) {
      if (e > 2.0) {
        result = e;
        break;
      }
    }

    return result;
  }

  public Double functionStyleOfFindFirstDouble(final Double[] array) {
    return Arrays.stream(array)
        .filter(number -> number > 2)
        .findFirst()
        .orElse(null);
  }

  public Optional<String> returnOptionalValue(final List<String> list) {
    return list.stream()
        .filter(value -> value.startsWith("e"))
        .findFirst();
  }

  public List<String> returnListFormMapForOperations(Map<String, String> map) {
     return map.values()
         .stream()
         .filter(value -> value.contains("map"))
         .collect(toList());
  }

}
