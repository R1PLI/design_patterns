package response.json;

import bean.ResponseDto;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static config.specification.Specification.getSpec;

public class JsonResponse {

	private static final RequestSpecification req = getSpec();

	public static <T> T responseQuery(int productId, Class<T> tClass) {
		return
			given()
				.spec(req)
				.when()
				.get("products/{id}", productId)
				.then()
				.extract()
				.response().as(tClass);
	}

	public static ResponseDto responseQuery(int productId) {
		return responseQuery(productId, ResponseDto.class);
	}
}
