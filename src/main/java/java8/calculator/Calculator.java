package java8.calculator;

import java.util.function.DoubleBinaryOperator;

public enum Calculator {
  ADD("+", (d1, d2) -> d1 + d2),
  SUB("-", (d1, d2) -> d1 - d2),
  MUL("*", (d1, d2) -> d1 * d2),
  DIV("/", (d1, d2) -> d1 / d2);

  private final String symbol;
  private final DoubleBinaryOperator operator;

  Calculator(String symbol, DoubleBinaryOperator operator) {
    this.symbol = symbol;
    this.operator = operator;
  }

  public double getResult(double d1, double d2) {
    return operator.applyAsDouble(d1, d2);
  }

  public String getSymbol() {
    return symbol;
  }
}
