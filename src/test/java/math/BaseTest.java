package math;


import org.joda.time.Instant;
import org.joda.time.Interval;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseTest {

	private static final int TWO_MILLION = 2000000;
	private Main main = new Main();

	@Test
	@DisplayName("Method returns Long type value")
	void findLargestPalindromeInstanceOfTest() {
		assertThat(main.findLargestPalindrome(100, 1000)).isNotInstanceOf(Long.class);
	}

	@Test
	@DisplayName("Validate largest palindrome from product of two 3-digits number")
	void findLargestPalindromeTest() {
		assertThat(main.findLargestPalindrome(100, 1000)).isEqualTo(906609);
	}

	@Test
	@DisplayName("Comparing of imperative and declarative style results")
	void findLargestPalindromeResultComparingTest() {
		assertThat(main.findLargestPalindromeImperative(100, 1000)).isEqualTo(main.findLargestPalindrome(100, 1000));
	}

	@RepeatedTest(value = 10)
	@DisplayName("Comparing of imperative and declarative style time")
	void findLargestPalindromeTimeComparingTest() {
		Instant being = new Instant();
		main.findLargestPalindrome(100, 1000);
		Instant end = new Instant();

		Instant being1 = new Instant();
		main.findLargestPalindromeImperative(100, 1000);
		Instant end1 = new Instant();

		System.out.println("functional method time in mills " + new Interval(being, end).toDurationMillis());
		System.out.println("imperative method time in mills " + new Interval(being1, end1).toDurationMillis());
		System.out.println("-------------------");
	}

	@Test
	@DisplayName("Statistic should have count 0 for if 0 passed as parameter")
	void biggestFactorForPrimeNumberTest() {
		assertThat(main.biggestFactorForPrimeNumber(BigInteger.ZERO).getCount()).isEqualTo(0);
	}

	@Test
	@DisplayName("Should return max factor for prime number")
	void biggestFactoryForPrimeNumberValidTest() {
		assertThat(main.biggestFactorForPrimeNumber(new BigInteger("600851475143")).getMax()).isEqualTo(6857);
	}

	@Test
	@DisplayName("Return sum of numbers that divided by 3 or 5")
	void getSumOfSpecificNumbersTest() {
		assertThat(main.getSumOfSpecificNumbers()).isEqualTo(233168);
	}

	@Test
	@DisplayName("Get value of pair in map values")
	void mapWithPairTest() {
		assertThat(main.workingWithParisAndMaps()).isEqualTo("world");
	}

	@Test
	@DisplayName("Get sum of even fibonacci number that are not bigger than 4mil")
	void methodForFindSumOfFibonacciNumberTest() {
		assertThat(main.getSumForEvenFibonacciNumber(TWO_MILLION * 2)).isEqualTo(4613732);
	}

	@Test
	@DisplayName("Find the least common multiply")
	void lcmTest() {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		System.out.println(main.lcm(numbers));
	}

	@Test
	@DisplayName("Should return value of difference between square of sums and sum of squares on 100 elemtns")
	void differenceInSumOfSquareAndSquareOfSumTest() {
		assertThat(main.differenceBetweenSumOfSqAndSqOfSum()).isEqualTo(25164150);
	}

	@Test
	@DisplayName("Should return prime on 10001 position")
	void getMaxPrimeNumber() {
		assertThat(main.findPrime(10001)).isEqualTo(104743);
	}

	@Test
	@DisplayName("should find special Pythagorean  triplet")
	void findPythagoreanTriplet() {
		assertThat(main.productOfAbc(1000)).isEqualTo(31875000);
	}

	@Test
	@DisplayName("should return sum of primes below 2 million - 142913828922")
	void findSumOfPrimes() {
		BigInteger expectedValue = new BigInteger("142913828922");

		assertThat(main.findPrimeSumBelowTwoMillions(TWO_MILLION)).isEqualTo(expectedValue.longValue());
	}
}
