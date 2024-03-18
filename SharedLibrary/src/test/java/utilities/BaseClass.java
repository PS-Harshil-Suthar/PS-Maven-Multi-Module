package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private static WebDriver driver;
	private static FileInputStream fis;
	private static Properties prop;
	private static Logger logger;

	public static void startDriver() throws IOException {
		fis = new FileInputStream("Properties/application.properties");
		prop = new Properties();
		prop.load(fis);
		logger = Logger.getLogger("_3E");
		PropertyConfigurator.configure("Properties/log4j.properties");

		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (prop.getProperty("Browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static Properties getProperties() {
		return prop;
	}

	public static void stopDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
