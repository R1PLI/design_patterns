package java8.venkat;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class StringJoiners {
	public String returnElementsInUpperCase(List<String> list) {
		return list.stream()
			.map(String::toUpperCase)
			.collect(joining(", "));
	}
}
