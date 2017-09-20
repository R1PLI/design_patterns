package math;

import org.apache.http.message.BasicNameValuePair;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.lang.String.valueOf;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

public class Main {
	public IntSummaryStatistics biggestFactorForPrimeNumber(int primeNumber) {
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

	public long getSumForEvenFibonacciNumber(long n) {


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

	public int getSumOfSpecificNumbers() {
		BiFunction<Integer, Integer, Boolean> isDividedByNumber = (item, number) -> item % number == 0;

		return Stream.iterate(0, i -> i + 1)
			.limit(1000)
			.filter(item -> isDividedByNumber.apply(item, 3) || isDividedByNumber.apply(item, 5))
			.reduce(0, Integer::sum);
	}

	public String workingWithParisAndMaps() {
		HashMap<String, BasicNameValuePair> lul = new HashMap<>();

		lul.put("admin", new BasicNameValuePair("hello", "world"));

		return lul.entrySet().stream()
			.filter(item -> item.getKey().equals("admin"))
			.flatMap(o -> Stream.of(o.getValue()))
			.findAny()
			.orElseThrow(NoSuchElementException::new)
			.getValue();
	}

	public int findLargestPalindrome(final int rangeStart, final int rangeEnd) {
		AtomicInteger result = new AtomicInteger(0);

		range(rangeStart, rangeEnd).forEach(i ->
			range(rangeStart, rangeEnd)
				.map(j -> i * j)
				.filter(Main::isPalindrome)
				.filter(palindrome -> palindrome > result.get())
				.forEach(result::set)
		);

		return result.get();
	}

	public int findLargestPalindromeImperative(int rangeStart, int rangeEnd) {
		int maxPalindrome = 0;
		int result;

		for (int i = rangeStart; i < rangeEnd; i++) {
			for (int j = rangeStart; j < rangeEnd; j++) {
				result = i * j;
				if (isPalindrome(result) && result > maxPalindrome) {
					maxPalindrome = result;
				}
			}
		}

		return maxPalindrome;
	}

	private static boolean isPalindrome(int n) {

		String s = valueOf(n);
		String rs = new StringBuffer(s).reverse().toString();

		return range(0, s.length())
			.noneMatch(i -> s.charAt(i) != rs.charAt(i));
	}

	public int lcm(int[] input) {
		AtomicInteger result = new AtomicInteger(input[0]);

		rangeClosed(1, input.length)
			.map(item -> lcm(result.get(), item))
			.forEach(result::set);

		return result.get();
	}

	private static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}

	private static int gcd(int a, int b) {
		return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
	}
}
