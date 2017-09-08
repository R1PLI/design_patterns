package pract;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.*;

public class Main {
	public static void main(String[] args) {
		fahrenToCels(212);
		System.out.println("--------");
		inchToMeter(1000);
		System.out.println("--------");
		sumOfDigits(565);
		System.out.println("--------");
		yearsInMinutes(3456789);
		System.out.println("--------");
		calculateBodyMassIndex(452, 72);
		System.out.println("--------");
		twoIntsStatistic(25, 5);
		System.out.println("--------");
		intIntoSeq(123456);

	}

	public static void fahrenToCels(double farenheit) {
		System.out.printf("%.2f degree Fahrenheit is equal to %.2f in Celsius", farenheit, farenheit / 2.12);
	}

	public static void inchToMeter(double inchValue) {
		double inchToMeterRatio = 0.0254;
		System.out.printf("%.1f inch is %.1f meters", inchValue, inchValue * inchToMeterRatio);
	}

	public static void sumOfDigits(final int value) {
		int val = value;
		List<Integer> ints = new ArrayList<>();

		while (val > 0) {
			ints.add(val % 10);
			val /= 10;
		}

		int result = ints.stream()
			.filter(Objects::nonNull)
			.reduce(Integer::sum)
			.orElse(0);

		System.out.printf("The sum of all digits in %d is %d", value, result);
	}

	public static void yearsInMinutes(double minutes) {
		double minutesInDay = 60 * 24;
		double minutesInYear = 60 * 24 * 365;

		System.out.printf("%.0f minutes is approximately %.0f years and %.0f days", minutes, minutes / minutesInYear, minutes / minutesInDay % 365);
	}

	public static void calculateBodyMassIndex(int poundsValue, int heightValue) {
		double poundsToKilogramRatio = 0.45359237;
		double inchesToMeterRatio = 0.0254;
		System.out.printf("Body mass index is %f", poundsValue * poundsToKilogramRatio / Math.pow(heightValue * inchesToMeterRatio, 2));
	}

	public static void twoIntsStatistic(int firstValue, int secondValue) {

		IntSummaryStatistics sumStat = Stream.of(firstValue, secondValue)
			.collect(IntSummaryStatistics::new, IntSummaryStatistics::accept, IntSummaryStatistics::combine);

		System.out.println("Sum of two numbers is " + (firstValue + secondValue));
		System.out.println("Diff of two numbers is " + (firstValue - secondValue));
		System.out.println("Prod of two numbers is " + firstValue * secondValue);
		System.out.println("Average of two numbers is " + sumStat.getAverage());
		System.out.println("Diff of two numbers is " + (firstValue - secondValue));
		System.out.println("Max of two numbers is " + sumStat.getMax());
		System.out.println("Min of two numbers is " + sumStat.getMin());
	}

	public static void intIntoSeq(int value) {
		int val = value;
		List<Integer> ints = new ArrayList<>();

		while (val > 0) {
			ints.add(val % 10);
			val /= 10;
		}

		System.out.println("Was:\n" + value);
		ints.sort(naturalOrder());
		System.out.println("Becomes:");
		ints.forEach(item -> System.out.print(item + " "));
	}
}
