package math;

import org.apache.http.message.BasicNameValuePair;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.lang.String.valueOf;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

public class Main {
	public LongSummaryStatistics biggestFactorForPrimeNumber(BigInteger primeNumber) {
		long n = primeNumber.longValue();

		List<Long> factors = new ArrayList<>();
		for (long i = 2; i <= n; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}

		return factors.stream().collect(LongSummaryStatistics::new, LongSummaryStatistics::accept, LongSummaryStatistics::combine);
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

	//least common multiple
	private static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}

	//Greatest common divisor
	private static int gcd(int a, int b) {
		return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
	}

	public int differenceBetweenSumOfSqAndSqOfSum() {
		return Math.abs(sumOfSquares() - squareOfSums());
	}

	private static int sumOfSquares() {
		return rangeClosed(0, 100).boxed()
			.map(item -> item * item)
			.reduce(0, Integer::sum);
	}

	private static int squareOfSums() {
		int SumOfElement = rangeClosed(0, 100).boxed()
			.reduce(0, Integer::sum);

		return SumOfElement * SumOfElement;
	}

	public int findPrime(int soughtPosition) {
		int i = 2; //the number to check if prime
		int c = 1; //the counter for prime numbers have found so far

		while (true) {
			if (precisionIsPrime(i)) {
				c++;
			}
			//if c == 10001 we have found the 10001:st prime number
			if (c == soughtPosition) {
				return i;
			}
			i++;
		}
	}

	public static boolean isPrime(long number) {
		return rangeClosed(2, getEndNumber(number)).noneMatch(i -> number % i == 0);
	}

	public static boolean precisionIsPrime(long number) {
		return rangeClosed(2, getEndNumberPrecision(number)).noneMatch(i -> number % i == 0);
	}

	private static int getEndNumberPrecision(long i) {
		return (int) Math.ceil(Math.sqrt(i));
	}

	private static int getEndNumber(long i) {
		return (int) (Math.sqrt(i));
	}

	//The idea is to find sum of elements that evenly divisible by input number
	//Then should find the division coefficient
	//And last one - multiply each number by this coefficient to receive sought product
	public int productOfAbc(final int s) {
		int a;
		int b;
		int c;
		int k;
		int sum;

		for (int m = 2; m <= 500; m++) {
			for (int n = 1; n < m; n++) {
				a = m * m - n * n;
				b = 2 * m * n;
				c = m * m + n * n;
				sum = a + b + c;
				if (isEvenlyDivisible(s, sum)) {
					k = s / sum;
					return productWithCoefficient(k, a, b, c);
				}
			}
		}
		return -1;
	}

	private boolean isEvenlyDivisible(int divisible, int divisor) {
		return divisible % divisor == 0;
	}

	private int productWithCoefficient(int coefficient, int... params) {
		return (int) Math.pow(coefficient, 3) * params[0] * params[1] * params[2];
	}

	public long findPrimeSumBelowTwoMillions(int i) {
		return LongStream.rangeClosed(2, i)
			.filter(Main::isPrime)
			.sum();
	}
}
