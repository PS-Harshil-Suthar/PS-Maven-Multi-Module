package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class GenericUI {
//	public WebDriver driver;
//	
//	public GenericUI(WebDriver driver) {
//		// TODO Auto-generated constructor stub
//		this.driver = driver;
//	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://generic-ui.com/demo");

		WebElement dropDown = driver.findElement(By.xpath("(//div[@class='gui-select-container'])[1]"));
		dropDown.click();
//		Thread.sleep(2000);
		WebElement selectOPtion = driver.findElement(By.xpath("(//div[@class='gui-option gui-option-selected'])[1]"));
		selectOPtion.click();

		Thread.sleep(5000);
		driver.quit();
	}

}
