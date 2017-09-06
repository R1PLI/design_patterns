package java8.venkat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class Filters {

	public static void main(String[] args) {
		List<String> friends = new ArrayList<>(asList("Bla", "Bla"));

		final Optional<String> aLongName =
			friends.stream()
				.reduce((name1, name2) ->
					name1.length() >= name2.length() ? name1 : name2);

		aLongName.ifPresent(name ->
			System.out.println(String.format("A longest name: %s", name)));


		final String steveOrLonger =
			friends.stream()
				.reduce("Steve", (name1, name2) ->
					name1.length() >= name2.length() ? name1 : name2);
	}

	public static void pickNameOld(
		final List<String> names, final String startingLetter) {
		String foundName = null;
		for (String name : names) {
			if (name.startsWith(startingLetter)) {
				foundName = name;
				break;
			}
		}
		System.out.print(String.format("A name starting with %s: ", startingLetter));
		if (foundName != null) {
			System.out.println(foundName);
		} else {
			System.out.println("No name found");
		}
	}

	public static void pickNameNew(
		final List<String> names, final String startingLetter) {
		final Optional<String> foundName =
			names.stream()
				.filter(name -> name.startsWith(startingLetter))
				.findFirst();

		System.out.println(String.format("A name starting with %s: %s",
			startingLetter, foundName.orElse("No name found")));
	}
}
