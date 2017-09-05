package java8.venkat;

import java8.venkat.dto.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class CollectionFilter {
	public static void main(String... args) throws IOException {
		final List<Person> people = asList(
			new Person("John", 20),
			new Person("Sara", 21),
			new Person("Jane", 21),
			new Person("Greg", 35));

		final Function<Person, Integer> byAge = Person::getAge;
		final Function<Person, String> byTheirName = Person::getName;

		printPeople("Sorted is ASC order by age and name:",
			people.stream()
				.sorted(comparing(byAge).thenComparing(byTheirName))
				.collect(toList())
		);

		System.out.println("-------------");

		//bad way to filter and add to collections
		List<Person> olderThan20 = new ArrayList<>();
		people.stream().filter(person -> person.getAge() > 20)
			.forEach(olderThan20::add);

		System.out.println("People older than 20: " + olderThan20);

		System.out.println("-------------");

		//good way to filter
		List<Person> olderThan20_2 = people.stream()
			.filter(person -> person.getAge() > 20)
			.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println("People older than 20: " + olderThan20_2);

		System.out.println("-------------");

		//a bit refactor for good way to filter
		List<Person> olderThan20_3 = people.stream()
			.filter(person -> person.getAge() > 20)
			.collect(toList());
		System.out.println("People older than 20: " + olderThan20_3);

		System.out.println("-------------");

		//using group by
		Map<Integer, List<Person>> peopleByAge =
			people.stream()
				.collect(Collectors.groupingBy(Person::getAge));
		System.out.println(peopleByAge);

		System.out.println("-------------");

		//improving group by
		Map<Integer, List<String>> nameOfPeopleByAge =
			people.stream()
				.collect(
					groupingBy(Person::getAge, mapping(Person::getName, toList())));
		System.out.println("People grouped by age: " + nameOfPeopleByAge);

		System.out.println("-------------");

		//working with files
		Files.list(Paths.get("."))
			.forEach(System.out::println);

		System.out.println("-------------");

		//filter files only by directories
		Files.list(Paths.get("."))
			.filter(Files::isDirectory)
			.forEach(System.out::println);

		System.out.println("-------------");
	}

	private static void printPeople(
		final String message, final List<Person> people) {

		System.out.println(message);
		people.forEach(System.out::println);
	}
}
