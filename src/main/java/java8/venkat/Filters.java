package java8.venkat;

import java.util.List;
import java.util.Optional;

public class Filters {

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
		if(foundName != null) {
			System.out.println(foundName);
		} else {
			System.out.println("No name found");
		}
	}

	public static void pickNameNew(
		final List<String> names, final String startingLetter) {
		final Optional<String> foundName =
			names.stream()
				.filter(name ->name.startsWith(startingLetter))
				.findFirst();

		System.out.println(String.format("A name starting with %s: %s",
			startingLetter, foundName.orElse("No name found")));
	}
}
