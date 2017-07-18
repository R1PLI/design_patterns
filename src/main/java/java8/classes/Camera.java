package java8.classes;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Camera {

  private Function<Color, Color> filter;

  @SafeVarargs
  public Camera(Function<Color, Color>... filters) {
    setFilters(filters);
  }

  @SafeVarargs
  private final void setFilters(Function<Color, Color>... filters) {
    filter = Stream.of(filters)
        .reduce(Function.identity(), Function::andThen);
  }


  public Color snap(Color input) {
    return filter.apply(input);
  }
}
