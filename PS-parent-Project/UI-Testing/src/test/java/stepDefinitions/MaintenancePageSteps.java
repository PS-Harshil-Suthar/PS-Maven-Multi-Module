package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObjects;
import pageObjects.MaintenancePageObjects;
import utilities.BaseClass;

public class MaintenancePageSteps {
	WebDriver driver;
    Properties prop;
    Logger logger;
    LoginPageObjects obj;
    MaintenancePageObjects pageObjects;
   
   public MaintenancePageSteps() {
       this.driver = BaseClass.getDriver();
       this.prop = BaseClass.getProperties();
       this.logger = BaseClass.getLogger();
       this.obj = new LoginPageObjects(driver);
       this.maintenancePageObjects = new MaintenancePageObjects(driver);
   }
   
   LoginPageObjects loginPageObjects;
   MaintenancePageObjects maintenancePageObjects;

	@Then("User will click to the maitenance button")
	public void user_will_click_to_the_maitenance_button() {
		maintenancePageObjects.maintenanceButton();
	}

	@Then("User is enter the password for Administration Access")
	public void user_is_enter_the_password_for_administration_access() {
		maintenancePageObjects.accessPassword(prop.getProperty("password"));
		maintenancePageObjects.confirmButton();
	}

	@Then("User will be redirected to the Maintenance Page of OrangeHRM")
	public void user_will_be_redirected_to_the_maintenance_page_of_orange_hrm() {
	}

	@Then("user will click on the Purge Record dropdown option")
	public void user_will_click_on_the_purge_record_dropdown_option() throws InterruptedException {
		maintenancePageObjects.purgeRecodes();
	}

	@When("User will select the Candidate Record")
	public void user_will_select_the_candidate_record() {
		maintenancePageObjects.CandidateRecords();
	}

	@Then("User enter the text into the vacancy and select the option")
	public void user_enter_the_text_into_the_vacancy_and_select_the_option() throws InterruptedException {
		maintenancePageObjects.input(prop.getProperty("vacancy"));
		Thread.sleep(2000);
		maintenancePageObjects.selectVacancy();
	}

	@Then("User will initiate search")
	public void user_will_initiate_search() throws InterruptedException {
		maintenancePageObjects.searchButton();
		Thread.sleep(2000);
	}
   
   @Then("user will click the purge button")
   public void user_will_click_the_purge_button() throws InterruptedException {
	   maintenancePageObjects.purgeAll();
		Thread.sleep(2000);
		maintenancePageObjects.confirmPurge();
		Thread.sleep(2000);
   }

	@When("User will select the Employee Record")
	public void user_will_select_the_employee_record() {
		maintenancePageObjects.EmployeeRecords();
	}

	@Then("enter the text into the Past Employee textbox and select the option")
	public void enter_the_text_into_the_past_employee_textbox_and_select_the_option() throws InterruptedException {
		maintenancePageObjects.input(prop.getProperty("candidateName"));
		Thread.sleep(2000);
	}

	@Then("user click on the Yes, Purge button to confirm the purge")
	public void user_click_on_the_yes_purge_button_to_confirm_the_purge() throws InterruptedException {
	}

	@When("User will select the Access Record")
	public void user_will_select_the_access_record() {
		maintenancePageObjects.accessRecodrs();
	}

	@Then("User enters the Name in Employee name texbox")
	public void user_enters_the_name_in_employee_name_texbox() throws InterruptedException {
		maintenancePageObjects.input(prop.getProperty("candidateName"));
		Thread.sleep(2000);
		maintenancePageObjects.search_Text();
		Thread.sleep(2000);
		
	}

	@Then("select the name from the options")
	public void select_the_name_from_the_options()throws InterruptedException {
//		maintenancePageObjects.selectOption();
	}

	@Then("user click the download button")
	public void user_click_the_download_button()throws InterruptedException {
		maintenancePageObjects.downloadButton();
		Thread.sleep(2000);
	}
	
}
