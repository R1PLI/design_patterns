package java8.venkat;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringsIteration {
	public List<Character> splitStringIntoChars(String str) {
		return str.chars()
			.mapToObj(ch -> (char) ch)
			.collect(toList());
	}

	public List<Character> collectOnlyDigits(String str) {
		return str.chars()
			.filter(Character::isDigit)
			.mapToObj(ch -> (char) ch)
			.collect(toList());
	}
}
