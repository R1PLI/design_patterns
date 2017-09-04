package java8.venkat;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class LambdaExpressions {
	public static void main(String[] args) {
		List<String> friends = asList("Natan, Emanuel");

		//regular
		final Predicate<String> startsWithN = name -> name.startsWith("N");
		final Predicate<String> startsWithB = name -> name.startsWith("B");
		final long countFriendsStartN =
			friends.stream()
				.filter(startsWithN).count();
		final long countFriendsStartB =
			friends.stream()
				.filter(startsWithB).count();

		//with use of Predicate<T>
		final long countFriendsStartN1 =
			friends.stream()
				.filter(checkIfStartsWith("N")).count();
		final long countFriendsStartB1 =
			friends.stream()
				.filter(checkIfStartsWith("B")).count();


		//using Function<T, R>
		final Function<String, Predicate<String>> startsWithLetter =
			letter -> name -> name.startsWith(letter);

		final long countFriendsStartN2 =
			friends.stream()
				.filter(startsWithLetter.apply("N")).count();
		final long countFriendsStartB2 =
			friends.stream()
				.filter(startsWithLetter.apply("B")).count();

	}

	public static Predicate<String> checkIfStartsWith(final String letter) {
		return name -> name.startsWith(letter);
	}

}
