package java8_tests;

import java8.CodingPractice;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class UnitTests {

  CodingPractice codingPractice;

  @Before
  public void setUp() {
    codingPractice = new CodingPractice();
  }

  @Test
  public void sumOfElementsShouldReturnInteger() {
    List<Integer> numbers = asList(1, 3);

    assertThat(codingPractice.summingOfElements(numbers, 2)).isInstanceOf(Integer.class);
  }

  @Test
  public void getSumOfEvenElementsInListMultiplyingByTwo() {
    List<Integer> numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    assertThat(codingPractice.summingOfElements(numbers, 2)).isEqualTo(60);
  }

  @Test
  public void getSumOfEvenElementsInListMultiplyingByVariosNumber() {
    List<Integer> numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    assertThat(codingPractice.summingOfElements(numbers, 8)).isEqualTo(240);
  }

  @Test
  public void checkIfNotDuplicates() {
    List<Integer> numbers = asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

    assertThat(codingPractice.removeDuplicatesValuesInListMuliplyByTwo(numbers)).containsOnly(2, 4, 6, 8, 10);
  }
}
