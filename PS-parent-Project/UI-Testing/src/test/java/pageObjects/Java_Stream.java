package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Java_Stream {
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		System.out.println(linkList);
		
		List<String> Elements = linkList.stream()
		.filter(ele -> !ele.getText().equals(""))
		.map(ele -> ele.getText()).collect(Collectors.toList());
		
		Elements.forEach(ele -> System.out.println("Elements: " + ele));

		Thread.sleep(2000);
		driver.quit();
	}
	
}
