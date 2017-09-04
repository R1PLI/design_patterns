package java8.venkat;

public class StringsIteration {
	public static void main(String[] args) {
		String str = "w00t";

		//using chars()
		str.chars().forEach(ch -> System.out.println(ch));

		System.out.println("-----");

		//using chars() + method reference
		str.chars().forEach(StringsIteration::printChar);

		System.out.println("-----");

		//using mapper to object to return characters, not numbers
		str.chars()
			.mapToObj(ch -> Character.valueOf((char)ch))
			.forEach(System.out::println);

		System.out.println("-----");

		//using mapper to object and simplify transformation expression
		str.chars()
			.mapToObj(ch -> (char) ch)
			.forEach(System.out::println);
		System.out.println("-----");

		//using filter
		str.chars()
			.filter(Character::isDigit)
			.forEach(StringsIteration::printChar);
	}

	private static void printChar(int aChar) {
		System.out.println((char)(aChar));
	}
}
