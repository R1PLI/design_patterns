package java8.venkat;

import java.math.BigDecimal;
import java.util.List;


public class VenkatsPractice {

  public BigDecimal imperativeStyleDiscount(List<BigDecimal> list) {
    BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
    for (BigDecimal price : list) {
      if (price.compareTo(BigDecimal.valueOf(20)) > 0) {
        totalOfDiscountedPrices =
            totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
      }
    }
    return totalOfDiscountedPrices;
  }

  public BigDecimal functionalStyleDiscount(List<BigDecimal> list) {
    return list.stream()
        .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
        .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
