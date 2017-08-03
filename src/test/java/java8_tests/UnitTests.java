package java8_tests;

import java8.CodingPractice;
import java8.CollectionHelper;
import java8.NumericHelper;
import java8.calculator.Calculator;
import java8.classes.Camera;
import java8.classes.Mailer;
import java8.classes.Resource;
import java8.venkat.VenkatsPractice;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.*;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static java8.CollectionHelper.convertListToMap;
import static org.assertj.core.api.Assertions.assertThat;

public class UnitTests {

  private CodingPractice codingPractice;
  private VenkatsPractice venkatsPractice;
  private NumericHelper numericHelper;
  private CollectionHelper collectionHelper;
  private List<Integer> numbers;
  private List<Double> doubleValues;
  private List<String> strings;
  private List<BigDecimal> prices;

  @Before
  public void setUp() {
    codingPractice = new CodingPractice();
    venkatsPractice = new VenkatsPractice();
    numericHelper = new NumericHelper();
    collectionHelper = new CollectionHelper();
  }

  @Test
  public void sumOfElementsShouldReturnInteger() {
    numbers = asList(1, 3);

    assertThat(codingPractice.summingOfElements(numbers, 2)).isInstanceOf(Integer.class);
  }

  @Test
  public void getSumOfEvenElementsInListMultiplyingByTwo() {
    numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    assertThat(codingPractice.summingOfElements(numbers, 2)).isEqualTo(60);
  }

  @Test
  public void getSumOfEvenElementsInListMultiplyingByVariousNumber() {
    numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    assertThat(codingPractice.summingOfElements(numbers, 8)).isEqualTo(240);
  }

  @Test
  public void checkIfNotDuplicates() {
    numbers = asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

    assertThat(codingPractice.removeDuplicatesValuesInListMultiplyByTwo(numbers)).containsOnly(2, 4, 6, 8, 10);
  }

  // strategy pattern tests

  @Test
  public void highOrderFunctionTest() {
    numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    assertThat(codingPractice.totalValues(numbers, e -> true)).isEqualTo(55);
  }

  @Test
  public void highOrderFunctionWithEvenNumbersTest() {
    numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    final Predicate<Integer> isEven = number -> (number % 2 == 0);

    assertThat(codingPractice.totalValues(numbers, NumericHelper::isEven)).isEqualTo(30);
    assertThat(codingPractice.totalValues(numbers, isEven)).isEqualTo(30);
  }

  @Test
  public void highOrderFunctionWithOddNumbersTest() {
    numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    assertThat(codingPractice.totalValues(numbers, NumericHelper::isOdd)).isEqualTo(25);
  }

  //decorator pattern tests

  @Test
  public void defaultColorTest() {
    System.out.println("=============================");
    codingPractice.printSnap(new Camera());
    System.out.println("=============================\n");
  }

  @Test
  public void decoratorColorBrighterTest() {
    System.out.println("=============================");
    codingPractice.printSnap(new Camera(Color::brighter));
    System.out.println("=============================\n");
  }

  @Test
  public void decoratorColorDarkerTest() {
    System.out.println("=============================");
    codingPractice.printSnap(new Camera(Color::darker));
    System.out.println("=============================\n");
  }

  //builder pattern tests

  @Test
  public void mailerTest() {
    System.out.println("=============================");
    Mailer.send(mailer ->
        mailer.from("builder")
            .to("to me")
            .subject("hi")
            .body("...that's it"));
    System.out.println("=============================\n");
  }

  //execute around method pattern tests

  @Test
  public void cleanUpTest() {
    System.out.println("=============================");
    Resource.use(resource ->
        resource
            .op1()
            .op2()
    );
    System.out.println("=============================\n");
  }

  @Test
  public void compareToMethods() {
    Double[] doubles = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};

    assertThat(codingPractice.imperativeStyleOfFindFirstDoubleValue(doubles)).isEqualTo(codingPractice.functionStyleOfFindFirstDouble(doubles));
  }

  @Test
  public void checkForEmptyList() {
    Double[] doubles1 = {};
    assertThat(codingPractice.imperativeStyleOfFindFirstDoubleValue(doubles1)).isEqualTo(0.0);
  }

  @Test
  public void testForOptionalValue() {
    strings = asList("dimon", "overwatch");

    System.out.println(codingPractice.returnOptionalValue(strings).map(s -> "Hey, " + s + " davai").orElse("No such values here!"));
  }

  @Test
  @SuppressWarnings( {"unchecked", "SimplifyStreamApiCallChains"})
  public void mapTests() {

    strings = asList("dimap", "overwatch", "dimap", "overwatch", "dimap", "overwatch", "dimap", "overwatch", "dimap", "overwatch", "dimap", "overwatch", "dimap", "overwatch", "dimap", "overwatch");

    System.out.println(convertListToMap(strings).values());


    assertThat(convertListToMap(strings).values().stream().collect(toSet())).isEqualToComparingOnlyGivenFields(asList("dimap", "overwatch"));
  }

  @Test
  public void calculatorTest() {
    System.out.println(Calculator.ADD.getResult(5, 6));
    System.out.println(Calculator.SUB.getResult(5, 6));
    System.out.println(Calculator.MUL.getResult(5, 6));
    System.out.println(Calculator.DIV.getResult(5, 0));
    assertThat(Calculator.ADD.getSymbol()).isEqualTo("+");
  }

  @Test
  public void functionTests() {
    BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;
    System.out.println(adder.apply(4, 3));

    BinaryOperator<Integer> bi = BinaryOperator.maxBy(Comparator.naturalOrder());
    System.out.println(bi.apply(4, 3));

    Consumer<String> consumer = System.out::println;
    consumer.accept("Hello from Consumer!");

    BiConsumer<String, String> biConsumer = (x, y) -> {
      System.out.print(x);
      System.out.println(y);
    };
    biConsumer.accept("Hello from ", "BiConsumer!");

    BiFunction<String, String, String> biFunction = String::concat;
    System.out.println(biFunction.apply("Hello, ", "World!"));
  }

  @Test
  public void transformFunctionTest() {
    Double[] doubles = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
    System.out.println("String list with sqrt numbers " + NumericHelper.transformNumbers(asList(doubles), Math::sqrt));
    System.out.println("String list with exp numbers " + NumericHelper.transformNumbers(asList(doubles), Math::exp));
  }

  @Test
  public void biPredicateTest() {
    BiPredicate<Integer, Integer> bi = (x, y) -> Double.valueOf(x) > Double.valueOf(y);
    BiPredicate<Integer, Integer> biPredicate = (x, y) -> x > y;
    BiPredicate<Integer, Integer> biPredicateMinus2 = (x, y) -> x - 2 > y;

    assertThat(bi.test(3, 4)).isFalse();
    assertThat(bi.negate().test(3, 4)).isTrue();
    assertThat(biPredicate.and(biPredicateMinus2).test(8, 3)).isTrue();
    assertThat(biPredicate.or(biPredicateMinus2).test(8, 3)).isTrue();
    assertThat(NumericHelper.customCompareFunction((value1, value2) -> value1 / 2 == value2, 8, 4)).isTrue();
  }

  @Test
  public void stringJoiner() {
    strings = asList("dimon", "overwatch");

    assertThat(strings.stream()
        .map(String::toUpperCase)
        .collect(joining(", "))
    ).isEqualTo("DIMON, OVERWATCH");
  }

  @Test
  public void venkatTests() {
    prices = Arrays.asList(
        new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
        new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
        new BigDecimal("45"), new BigDecimal("12")
    );

    assertThat(venkatsPractice.imperativeStyleDiscount(prices)).isEqualTo(venkatsPractice.functionalStyleDiscount(prices));
  }

  @Test
  public void mapWithNullElementsTest() {
    doubleValues = asList(1.0, 2.0, null, 4.0, 5.0, 6.0, null, 8.0, 9.0, 10.0);

    try {
      System.out.println(doubleValues.stream()
          .map(Double::intValue)
          .reduce(0, Integer::sum));
    } catch (Exception e) {
      assertThat(e).isInstanceOf(NullPointerException.class);
    }
  }

  @Test
  public void shouldNotReturnNullPointerTest() {
    doubleValues = asList(1.0, 2.0, null, 4.0, 5.0, 6.0, null, 8.0, 9.0, 10.0);

    try {
      System.out.println(doubleValues.stream()
          .filter(Objects::nonNull)
          .map(Double::intValue)
          .reduce(0, Integer::sum));
    } catch (Exception e) {
      assertThat(e).isNotInstanceOf(NullPointerException.class);
    }
  }

  //boxed transforms IntStream to Stream<Integer>

  @Test
  public void closedRangeStreamTest() {
    assertThat(IntStream.rangeClosed(1, 4)
        .boxed()
        .collect(toList())
    ).isEqualTo(asList(1, 2, 3, 4));
  }

  @Test
  public void rangeStreamTest() {
    assertThat(IntStream.range(1, 4)
        .boxed()
        .collect(toList())
    ).isEqualTo(asList(1, 2, 3));
  }
}
