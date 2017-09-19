package math;

import org.apache.http.message.BasicNameValuePair;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Main {
	public static void main(String... args) {
		System.out.println(getSumOfSpecificNumbers());
		System.out.println("-----------------------");
		System.out.println(fibonacci(4000000));
		System.out.println("-----------------------");
		System.out.println(biggestFactorForPrimeNumber(716151937).getMax());
		System.out.println("-----------------------");
		System.out.println(workingWithParisAndMaps());
		System.out.println("-----------------------");
		System.out.println(findLargestPalindrome());
		System.out.println("-----------------------");
	}

	public static IntSummaryStatistics biggestFactorForPrimeNumber(int primeNumber) {
		int n = primeNumber;

		List<Integer> factors = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}

		factors.add(839);
		return factors.stream().collect(IntSummaryStatistics::new, IntSummaryStatistics::accept, IntSummaryStatistics::combine);
	}

	public static long fibonacci(long n) {


		long[] fib = {2, 0};
		int i = 0;
		long summed = 0;

		while (fib[i] < n) {
			summed += fib[i];
			i = (i + 1) % 2;
			fib[i] = 4 * fib[(i + 1) % 2] + fib[i];
		}

		return summed;
	}

	public static int getSumOfSpecificNumbers() {
		BiFunction<Integer, Integer, Boolean> isDividedByNumber = (item, number) -> item % number == 0;

		return Stream.iterate(0, i -> i + 1)
			.limit(1000)
			.filter(item -> isDividedByNumber.apply(item, 3) || isDividedByNumber.apply(item, 5))
			.reduce(0, Integer::sum);
	}

	public static String workingWithParisAndMaps() {
		HashMap<String, BasicNameValuePair> lul = new HashMap<>();

		lul.put("admin", new BasicNameValuePair("hello", "world"));

		return lul.entrySet().stream()
			.filter(item -> item.getKey().equals("admin"))
			.flatMap(o -> Stream.of(o.getValue()))
			.findAny()
			.orElseThrow(NoSuchElementException::new)
			.getValue();
	}

	public static int findLargestPalindrome() {
		int maxPalindrome = 0;
		int result;


		for (int i = 100; i <= 999; i++) {
			for (int j = 100; j <= 999; j++) {
				result = i * j;
				if (isPalindrome(result) && result > maxPalindrome) {
					maxPalindrome = result;
				}
			}
		}

		return maxPalindrome;
	}

	public static boolean isPalindrome(int n) {

		String s = String.valueOf(n);
		String rs = new StringBuffer(s).reverse().toString();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != rs.charAt(i)) {
				return false;
			}
		}

		return true;
	}

}
