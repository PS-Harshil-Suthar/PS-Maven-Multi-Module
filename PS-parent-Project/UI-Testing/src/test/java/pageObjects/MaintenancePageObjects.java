package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumMethods;

public class MaintenancePageObjects extends SeleniumMethods {

	public MaintenancePageObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By maintenanceButton = By.xpath("//a/span[normalize-space()=\"Maintenance\"]");
	private By accessPassword = By.xpath("//input[@name=\"password\"]");
	private By confirmButton = By.xpath("//button[normalize-space()=\"Confirm\"]");
	private By purgeRecodes = By.xpath("//li/span[normalize-space()=\"Purge Records\"]");
	private By purgeAll = By.xpath("//button[@type=\"button\" and normalize-space()=\"Purge All\"]");
	private By confirmPurge = By.xpath("//button[normalize-space()='Yes, Purge']");
	private By EmployeeRecords = By.xpath("//ul[@class=\"oxd-dropdown-menu\"]/li[normalize-space()=\"Employee Records\"]");
	private By CandidateRecords = By.xpath("//ul[@class=\"oxd-dropdown-menu\"]/li[normalize-space()=\"Candidate Records\"]");
	private By accessRecodrs = By.xpath("//li/a[normalize-space()=\"Access Records\"]");
	private By input = By.xpath("//input[@placeholder='Type for hints...']");
	private By selectVacancy = By.xpath("(//div[@role=\"listbox\"]/div[@role=\"option\"])[5]");
	private By search_Text = By.xpath("(//div[@role=\"listbox\"]/div[@role=\"option\"]/span)[1]");
	private By searchButton = By.xpath("//button[@type=\"submit\" and normalize-space()=\"Search\"]");
	private By downloadButton = By.xpath("//button[@type=\"submit\" and normalize-space()=\"Download\"]");
	
	
	public void maintenanceButton() {
		clickOn(maintenanceButton);
	}
	
	public void accessPassword(String password) {
        sendKeys(accessPassword, password);
    }
	
    public void confirmButton() {
        clickOn(confirmButton);
    }

    public void purgeRecodes() throws InterruptedException {
        clickOn(purgeRecodes);
        Thread.sleep(2000);
    }
    
    public void purgeAll() {
    	clickOn(purgeAll);
    }
    
    public void confirmPurge() {
        clickOn(confirmPurge);
    }
    
    public void EmployeeRecords() {
        clickOn(EmployeeRecords);
    }
    
    public void CandidateRecords() {
        clickOn(CandidateRecords);
    }
    
    public void accessRecodrs() {
        clickOn(accessRecodrs);
    }	
    
    public void input(String text) throws InterruptedException {
        sendKeys(input, text);
     
    }
    
    public void selectVacancy() throws InterruptedException {
        clickOn(selectVacancy);
    }

    
    public void searchButton()  throws InterruptedException{
        clickOn(searchButton);
    }
    
    public void search_Text()  throws InterruptedException{
        clickOn(search_Text);
    }
    
    public void downloadButton() throws InterruptedException {
        clickOn(downloadButton);
    }
	
}
