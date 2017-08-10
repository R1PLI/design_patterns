package restassuredtest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static bean.ErrorAssert.assertThat;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static response.json.JsonResponse.responseQuery;

public class BaseTests {

	private static RequestSpecification spec;

	@BeforeClass
	public static void initSpec() {
		spec = new RequestSpecBuilder()
			.setContentType(ContentType.JSON)
			.setBaseUri("https://syst2.project4.com/api/rest/v1/catalog")
			.build();
	}

	@Test
	public void baseGetTest() {
		get("https://syst2.project4.com/api/rest/v1/catalog/products/115010)")
			.then()
			.body("response[0].status", equalTo("40490006"));
	}

	@Test
	public void baseGetWithGivenTest() {
		given().spec(spec)
			.when()
			.get("products/{id}", 450207)
			.then()
			.statusCode(200)
			.body("skus[0].availability.stockLevel", equalTo(1384));
	}

	@Test
	public void fluentGetWithAssertjTest() {
		assertThat(
			responseQuery(115010)
				.getResponse()
				.get(0)
		).hasStatus("40490006");
	}
}
