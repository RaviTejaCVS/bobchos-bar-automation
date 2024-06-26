package bobchos.bar.api.stepdefinition;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.PlaceOrder;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class stepdefinition extends Utils {

	RequestSpecification res;

	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String name;
	JsonPath js;

	@Given("I have an order with the following details:")
	public void i_have_an_order_with_the_following_details(DataTable orderDetails) throws IOException {
		// Convert the DataTable to a Map
		Map<String, String> detailsMap = orderDetails.asMap(String.class, String.class);

		// Retrieve each value from the map
		String isAdult = detailsMap.get("IsAdult");
		String id = detailsMap.get("Id");
		String typeId = detailsMap.get("TypeId");
		String quantity = detailsMap.get("Quantity");
		String name = detailsMap.get("Name");
		String email = detailsMap.get("Email");
		String price = detailsMap.get("Price");
		String date = detailsMap.get("Date");

		resspec = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		res = given().spec(requestSpecification())
				.body(data.placeOrderPayload(isAdult, id, typeId, quantity, name, email, price, date));
	}

	@Given("Place Order Payload")
	public void place_order_payload(String isadult, String id, String typeid, String quantity, String name,
			String email, String price, String DateTime) throws IOException {

		resspec = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		res = given().spec(requestSpecification())
				.body(data.placeOrderPayload(isadult, id, typeid, quantity, name, email, price, DateTime));

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resource, String method) {

		APIResources resourceAPI = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		if (method.equalsIgnoreCase("POST")) {
			response = res.when().post(resourceAPI.getResource()).then().spec(resspec).extract().response();
		} else if (method.equalsIgnoreCase("GET")) {
			response = res.when().get(resourceAPI.getResource());
			System.out.println(response);
		} else if (method.equalsIgnoreCase("PUT")) {
			response = res.when().put(resourceAPI.getResource());
		} else if (method.equalsIgnoreCase("DELETE")) {
			response = res.when().delete(resourceAPI.getResource());
		} else {

		}
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(int expectedStatusCode) {
		assertEquals(response.getStatusCode(), expectedStatusCode);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
		
		assertEquals(getJsonPath(response,keyValue),Expectedvalue);

	}

	@Then("verify order id created maps to {string} using {string}")
	public void verify_order_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		String orderid=getJsonPath(response, "Id");
		res = given().spec(requestSpecification()).pathParam("Order", orderid);
		user_calls_with_post_http_request(resource,"GET");
		String actualName=getJsonPath(response, "Name");
		assertEquals(actualName, expectedName);
		
	}
	

@Given("verify order id {string} created matches {string} using {string}")
public void verify_order_id_created_matches_using(String orderId, String expectedName, String resource) throws IOException {
    // Write code here that turns the phrase above into concrete actions
	String orderid=orderId;
	res = given().spec(requestSpecification()).pathParam("Order", orderid);
	user_calls_with_post_http_request(resource,"GET");
	String actualName=getJsonPath(response, "Name");
	assertEquals(actualName, expectedName);
}
	
	

@Then("verify order details are deleted for the orderid equals to {string} using {string}")
public void verify_order_details_are_deleted_for_the_orderid_equals_to_using(String orderId, String resource)  throws IOException {
		String orderid=orderId;
		res = given().spec(requestSpecification()).pathParam("Order", orderid);
		user_calls_with_post_http_request(resource,"DELETE");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
	}
@Given("verify the name in the order details is updated to {string} for the orderid equals to {string}  using {string}")
public void verify_the_name_in_the_order_details_is_updated_to_for_the_orderid_equals_to_using(String newName, String orderId, String resource) throws IOException {
	res =given().spec(requestSpecification()).pathParam("Order", orderId).body(data.updateNamePayload(newName));
}



}
