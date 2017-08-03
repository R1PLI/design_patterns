package java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CollectionHelper {
	public static <K> Map convertListToMap(List<K> list) {
		return list.stream()
			.collect(Collectors.toMap(
				key -> NumericHelper.getRandomUUID(),
				value -> value)
			);
	}
}
