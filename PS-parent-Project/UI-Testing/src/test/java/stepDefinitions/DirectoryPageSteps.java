package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DirectoryPageObjects;
import pageObjects.LoginPageObjects;
import utilities.BaseClass;

public class DirectoryPageSteps {

	WebDriver driver;
	Properties prop;
	Logger logger;
	LoginPageObjects obj;
	DirectoryPageObjects pageObjects;

	public DirectoryPageSteps() {
		this.driver = BaseClass.getDriver();
		this.prop = BaseClass.getProperties();
		this.logger = BaseClass.getLogger();
		this.obj = new LoginPageObjects(driver);
		this.directoryPageObjects = new DirectoryPageObjects(driver);

	}

	LoginPageObjects loginPageObjects;
	DirectoryPageObjects directoryPageObjects;

	@When("User enters the valid username and password")
	public void user_enters_the_valid_username_and_password() {
		loginPageObjects = new LoginPageObjects(driver);
		loginPageObjects.InputCredentials(prop.getProperty("username"), prop.getProperty("password"));
		loginPageObjects.clickButton();
	}

	@Then("User will be able to login and see the Homepage")
	public void user_will_be_able_to_login_and_see_the_homepage() throws InterruptedException {
		
	}

	@Then("User will click to the directory button")
	public void user_will_click_to_the_directory_button() {
		directoryPageObjects.directoryButton();
	}

	@When("User enters {string} in the search bar")
	public void user_enters_in_the_search_bar(String Ename) throws InterruptedException {
		directoryPageObjects.inputName(prop.getProperty("name", Ename));
		directoryPageObjects.clickOnName();
		Thread.sleep(2000);
	}
	
	@When("User selects a Job Title from the dropdown list")
	public void user_selects_a_job_title_from_the_dropdown_list() throws InterruptedException {
		directoryPageObjects.clickOnSelect();
		directoryPageObjects.clickOnSelectName();
	}

	@When("User selects a Location from the dropdown options")
	public void user_selects_a_location_from_the_dropdown_options() throws InterruptedException {
		directoryPageObjects.locationButton();
		directoryPageObjects.locationName();
	}

	@Then("User initiates the search")
	public void user_initiates_the_search() throws InterruptedException {
		directoryPageObjects.searchButton();
	}

	@Then("User selects a record")
	public void user_selects_a_record() {
		
	}

	@Then("User resets the search")
	public void user_resets_the_search() throws InterruptedException {
		directoryPageObjects.resetButton();
	}

}
