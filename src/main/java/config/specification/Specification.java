package config.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {
	public static RequestSpecification getSpec() {
		return new RequestSpecBuilder()
			.setContentType(ContentType.JSON)
			.setBaseUri("https://syst2.project4.com/api/rest/v1/catalog")
			.build();
	}
}
