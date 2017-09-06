package java8_tests.iteration;

import java8.venkat.StringsIteration;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class FunctionalTest {

	private final static int intValue = 1;
	private final static String emptyStr = "";
	private final static String str = "w00t";

	StringsIteration stringsIteration = new StringsIteration();

	@Test
	public void returnEmptyCollectionTest() {
		assertThat(stringsIteration.splitStringIntoChars(emptyStr)).isEmpty();
		assertThat(stringsIteration.collectOnlyDigits(emptyStr)).isEmpty();
	}

	@Test
	public void verifyCollectionIsNotEmpty() {
		assertThat(stringsIteration.splitStringIntoChars(str)).isNotEmpty();
		assertThat(stringsIteration.collectOnlyDigits(str)).isNotEmpty();
	}

	@Test
	public void verifyCollectionHasExpectedSizeTest() {
		assertThat(stringsIteration.collectOnlyDigits(str)).hasSize(2);
		assertThat(stringsIteration.splitStringIntoChars(str)).hasSize(4);

	}

	@Test
	public void verifyCollectionElementsTest() {
		assertThat(stringsIteration.collectOnlyDigits(str)).containsExactly('0', '0');
		assertThat(stringsIteration.splitStringIntoChars(str)).containsExactly('w', '0', '0', 't');
	}

}
