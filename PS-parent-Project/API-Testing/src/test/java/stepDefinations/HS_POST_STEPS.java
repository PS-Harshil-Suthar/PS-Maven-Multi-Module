package stepDefinations;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import Utility.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class HS_POST_STEPS {

	CommonMethods commonMethods;
	Response res;

	@Given("the API is available")
	public void the_api_is_available() {
	}

	@When("I send a POST request to {string} endpoint with the following request body:")
	public Response i_send_a_post_request_to_endpoint_with_the_following_request_body(String endpoint,
			String docString) {
		commonMethods = new CommonMethods();
		res = commonMethods.callAPIWithJson("POST", docString, endpoint);
		return res;
	}

	@Then("the API should return the expected data")
	public void the_api_should_return_the_expected_data() {
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer resCode) {
		commonMethods.verifyResponseCode(resCode, res);
	}

	@Then("the response should match the schema {string}")
	public void the_response_should_match_the_schema(String schemaFile) throws IOException, ParseException, JSONException {
		commonMethods.verifyJsonSchema(res, schemaFile);
	}

	@When("I send a POST request to the endpoint {string} with query parameter {string} set to {string}")
	public void i_send_a_post_request_to_the_endpoint_with_query_parameter_set_to(String endpoint, String key,
			String value) {
		commonMethods = new CommonMethods();
		res = commonMethods.callAPIWithParam("POST", null, endpoint, key, value);
	}

	@Then("the response body should contain a list of substances with updated resource status")
	public void the_response_body_should_contain_a_list_of_substances_with_updated_resource_status() {
	}

	@Then("the API should return an empty response")
	public void the_api_should_return_an_empty_response() {
	}

	
	@When("I send a POST request to {string} endpoint with the following request body in text format {string}")
	public void i_send_a_post_request_to_endpoint_with_the_following_request_body_in_text_format(String endpoint, String reqBody) {
		commonMethods = new CommonMethods();
		res = commonMethods.callAPIWithText("POST", reqBody, endpoint);
	}

	@Then("the API should return an error message indicating error message")
	public void the_api_should_return_an_error_message_indicating_error_message() {
	}

}
