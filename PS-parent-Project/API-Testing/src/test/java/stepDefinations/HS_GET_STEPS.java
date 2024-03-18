package stepDefinations;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import Utility.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class HS_GET_STEPS {

	CommonMethods commonMethods;
	Response Reqres;

	@Given("the API endpoint is {string}")
	public void the_api_endpoint_is(String endpoint) {
		commonMethods = new CommonMethods();
		Reqres = commonMethods.callAPI("GET", null, endpoint);
	}

	@When("I send a GET HTTP request with the Accept header")
	public void i_send_a_get_http_request_with_the_accept_header() {
	}

	@Then("the response status code is {int}")
	public void the_response_status_code_is(Integer resCode) {
		commonMethods.verifyResponseCode(resCode, Reqres);
	}

	@Then("the response matches the schema {string}")
	public void the_response_matches_the_schema(String schemaFile) throws IOException, ParseException, JSONException {
		commonMethods.verifyJsonSchema(Reqres, schemaFile);
	}

	@Given("the API endpoint is {string} and the parameter {string} has the value {string}")
	public void the_api_endpoint_is_and_the_parameter_has_the_value(String endpoint, String key, String value) {
		commonMethods = new CommonMethods();
		Reqres = commonMethods.callAPIWithParam("GET", null, endpoint, key, value);
	}

}
