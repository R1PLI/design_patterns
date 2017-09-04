package java8.venkat;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

public class StringJoiners {
	public static void main(String[] args) {
		List<String> friends = new ArrayList<>(asList("Dmytro", "Mikhail", "Rostislav",
			"Kyrilo", "Bonia"));


		//Regular version
		for(String name : friends) {
			System.out.print(name + ", ");
		}
		System.out.println();

		//A bit of refactor
		for(int i = 0; i < friends.size() - 1; i++) {
			System.out.print(friends.get(i) + ", ");
		}
		if(friends.size() > 0)
			System.out.println(friends.get(friends.size() - 1));

		//String.join usage
		System.out.println(String.join(", ", friends));

		//using collect(joining)
		System.out.println(
			friends.stream()
				.map(String::toUpperCase)
				.collect(joining(", ")));
	}
}
