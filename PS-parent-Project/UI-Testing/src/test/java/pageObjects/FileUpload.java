package pageObjects;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

public class FileUpload {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new EdgeDriver();
		d.manage().window().maximize(); // always write wait code after this
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // for page load
		d.get("https://www.csm-testcenter.org/test?do=show&subdo=common&test=file_upload"); // Testing webpage

//		   Scrolling Through Javascript 		   
//		   JavascriptExecutor j = (JavascriptExecutor)d;
//		   j.executeScript("window.scrollBy(0,380)");
//		   Thread.sleep(2000);

		File uploadFile = new File("C:\\Users\\harshil.suthar\\Downloads\\image.jpg");
		WebElement file = d.findElement(By.xpath("(//input[@type=\"file\"])[2]"));
		file.sendKeys(uploadFile.getAbsolutePath());
		System.out.println("Image uploaded successfully");

		WebElement upload = d.findElement(By.xpath("(//input[@id=\"button\"])[2]"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(upload.getText(), "image.jpg", "File name does not match");
		upload.click();

		WebElement successText = d.findElement(By.xpath("//td[normalize-space()=\"File successfully uploaded\"]"));
		System.out.println(successText.getText());

//		   List<WebElement> sucessText = d.findElements(By.xpath("//td[normalize-space()=\"File successfully uploaded\"]"));
//		   List<String> text = sucessText.stream().filter(element -> element.getText().equals("File successfully uploaded")).map(ele -> ele.getText()).collect(Collectors.toList());
//		   System.out.println(sucessText.size());
//		   text.forEach(ele -> System.out.println(ele));

		Thread.sleep(2000);
		d.quit();
	}

}
