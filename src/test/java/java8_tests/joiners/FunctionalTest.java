package java8_tests.joiners;

import java8.venkat.StringJoiners;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static java.util.Arrays.asList;

public class FunctionalTest {
	private static final List<String> friends = new ArrayList<>(asList("Dmytro", "Mikhail", "Rostislav", "Kyrilo", "Bonia"));
	private static final List<String> emptyList = new ArrayList<>();

	StringJoiners stringJoiners = new StringJoiners();

	@Test
	public void verifyReturnValueIsEmpty() {
		assertThat(stringJoiners.returnElementsInUpperCase(emptyList)).isEmpty();
	}

	@Test
	public void returnValueIsNotEmpty() {
		assertThat(stringJoiners.returnElementsInUpperCase(friends)).isNotEmpty();
	}

	@Test
	public void verifyValuesInUpperCase() {
		assertThat(stringJoiners.returnElementsInUpperCase(friends)).contains("DMYTRO, MIKHAIL, ROSTISLAV, KYRILO, BONIA");
	}
}
