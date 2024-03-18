package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumMethods;

public class DirectoryPageObjects extends SeleniumMethods {

	public DirectoryPageObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private By directory_Button = By.xpath("//a/span[normalize-space()='Directory']");
	private By inputName = By.xpath("//input[@placeholder='Type for hints...']");
	private By jobSelect = By.xpath("(//div[@class=\"oxd-select-text-input\"])[1]");
	private By selectName = By.xpath("//div[normalize-space()=\"Chief Technical Officer\"]");
	private By locationSelect = By.xpath("(//div[@class=\"oxd-select-text-input\"])[2]");
	private By locationName = By.xpath("(//div[@role=\"option\"])[2]/span");
	private By search_Button = By.xpath("//button[normalize-space()=\"Search\"]");
	private By reset_Button = By.xpath("//button[normalize-space()=\"Reset\"]");
	private By search_Text = By.xpath("(//div[@role=\"listbox\"]/div[@role=\"option\"]/span)[1]");

	
	
	public void directoryButton() {
		clickOn(directory_Button);
	}
	
	public void inputName(String iname) throws InterruptedException {
		sendKeys(inputName, iname);
		Thread.sleep(2000);
		
	}
	
	public void clickOnName() throws InterruptedException {
        clickOn(search_Text);
        Thread.sleep(2000);
}

public void clickOnSelect() throws InterruptedException {
	clickOn(jobSelect);
	Thread.sleep(2000);
}

public void clickOnSelectName() throws InterruptedException {
	clickOn(selectName);
	Thread.sleep(2000);
}

public void locationButton() throws InterruptedException {
	clickOn(locationSelect);
	Thread.sleep(2000);
}

public void locationName() throws InterruptedException {
	clickOn(locationName);
	Thread.sleep(2000);
}


public void searchButton() throws InterruptedException {
	clickOn(search_Button);
	Thread.sleep(2000);
}
public void resetButton() throws  InterruptedException {
        clickOn(reset_Button);
        Thread.sleep(2000);
    }
	
}
