package java8.venkat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


public class Application {
  public static void main(String[] args) {
    final List<BigDecimal> prices = Arrays.asList(
        new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
        new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
        new BigDecimal("45"), new BigDecimal("12"));

    System.out.println("Total of discounted prices: " + imperativeStyleDiscount(prices));
    System.out.println("================================");
    System.out.println("Total of discounted prices: " + imperativeStyleDiscount(prices));
  }

  public static BigDecimal imperativeStyleDiscount(List<BigDecimal> list) {
    BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
    for (BigDecimal price : list) {
      if (price.compareTo(BigDecimal.valueOf(20)) > 0) {
        totalOfDiscountedPrices =
            totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
      }
    }
    return totalOfDiscountedPrices;
  }

  public static BigDecimal functionalStyleDiscount(List<BigDecimal> list) {
    return list.stream()
        .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
        .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
