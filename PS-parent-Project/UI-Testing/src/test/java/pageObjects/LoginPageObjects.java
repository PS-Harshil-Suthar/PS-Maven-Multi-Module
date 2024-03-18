package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumMethods;

public class LoginPageObjects extends SeleniumMethods {

	public LoginPageObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By username = By.name("username");
	private By password = By.name("password");
	private By loginButton = By.cssSelector("button[type='submit']");
	private By errorMessage = By.xpath("//div[@role='alert']/div/p");

	public void portalLoginPage(String url) {
		navigateURL(url);
		verifyTitle("OrangeHRM");
	}

	public void InputCredentials(String Vusername, String Vpassword) {
		ClearText(username);
		sendKeys(username, Vusername);
		ClearText(password);
		sendKeys(password, Vpassword);

	}

	public void clickButton() {
		clickOn(loginButton);
	}

	public String getErrorMessageText() {
	    return getText(errorMessage);
	}
}
