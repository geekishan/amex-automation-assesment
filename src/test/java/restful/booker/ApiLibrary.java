package restful.booker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class ApiLibrary {

	private RequestSpecification getRequestSpecification() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		return RestAssured.given();
	}

	public Response makeAGetCall(final String endPoint) {
		RequestSpecification request = getRequestSpecification();
		return request.when().get(endPoint);
	}

	public Response makeAPostCall(final String endPoint, final Object body) {
		RequestSpecification request = getRequestSpecification();
		return request.when().contentType(ContentType.JSON).body(body).post(endPoint);
	}

}
