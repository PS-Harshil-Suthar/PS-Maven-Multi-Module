package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObjects;
import utilities.BaseClass;

public class LoginPageSteps {

	WebDriver driver;
	Properties prop;
	Logger logger;
	LoginPageObjects obj;

	public LoginPageSteps() {
		this.driver = BaseClass.getDriver();
		this.prop = BaseClass.getProperties();
		this.logger = BaseClass.getLogger();
		this.obj = new LoginPageObjects(driver);

	}

	LoginPageObjects loginPageObjects;

	@Given("User is on the Login Page")
	public void user_is_on_the_login_page() {
		loginPageObjects = new LoginPageObjects(driver);
		loginPageObjects.navigateURL(prop.getProperty("url"));
	}


//    	loginPageObjects.InputCredentials(prop.getProperty("fakeUsername"), prop.getProperty("fakePassword"));
//    	loginPageObjects.clickButton();


	@When("User enters the invalid username and password")
	public void user_enters_the_invalid_username_and_password(DataTable loginDetailsTable) {
		List<Map<String, String>> loginDeatils = loginDetailsTable.asMaps(String.class, String.class);
		for (Map<String, String> details : loginDeatils) {
			loginPageObjects.InputCredentials(details.get("username"), details.get("password"));
		}
		loginPageObjects.clickButton();
	}
	
	@Then("User will get the error message error message")
	public void user_will_get_the_error_message_error_message() {
		SoftAssert softAssert = new SoftAssert();
		String errorMessage = loginPageObjects.getErrorMessageText();
		softAssert.assertEquals("Invalid credentials", errorMessage);
	}

	@When("user enters the valid username and password")
	public void user_enters_the_valid_username_and_password(DataTable loginDetailsTable) {
		List<Map<String, String>> loginDeatils = loginDetailsTable.asMaps(String.class, String.class);
		for (Map<String, String> details : loginDeatils) {
			loginPageObjects.InputCredentials(details.get("username"), details.get("password"));
		}
		loginPageObjects.clickButton();
//		loginPageObjects.InputCredentials(prop.getProperty("username"), prop.getProperty("password"));
//		loginPageObjects.clickButton();

	}

	@Then("User will be redirected to the Home Page of OrangeHRM")
	public void user_will_be_redirected_to_the_home_page_of_orange_hrm() {
//    	loginPageObjects.portalLoginPage("OrangeHRM");
	}

}
