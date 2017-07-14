package java8;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class CodingPractice {

  public Integer summingOfElements(final List<Integer> numbers, Integer multiplier) {
    return numbers.stream()
        .filter(NumericHelper::isEven)
        .mapToInt(number -> NumericHelper.multiplying(number, multiplier))
        .sum();
  }

  public Set<Integer> removeDuplicatesValuesInListMuliplyByTwo(final List<Integer> numbers) {
    return numbers.stream()
        .map(number -> number * 2)
        .collect(toSet());
  }
}
