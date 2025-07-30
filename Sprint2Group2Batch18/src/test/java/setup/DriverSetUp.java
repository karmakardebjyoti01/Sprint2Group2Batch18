package setup;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverSetUp {
	static WebDriver driver;
	static Properties p;
	public static WebDriver initializeDriver() throws Exception {
		
		String browser=PropertiesProvider.getKey("browser");
		System.out.println("Browser"+ browser);
		if(browser!=null) {
			switch (browser) {
			case "Chrome":
				ChromeOptions chromeOptions=new ChromeOptions();
				chromeOptions.addArguments("--headless");
				driver=new ChromeDriver(chromeOptions);
				break;
			case "FireFox":
				FirefoxOptions firefoxOptions=new FirefoxOptions();
//				firefoxOptions.setHeadless(true);
				firefoxOptions.addArguments("--headless");
				driver=new FirefoxDriver(firefoxOptions);
//				driver=new FirefoxDriver();
				break;
			case "Edge":
				EdgeOptions edgeOptions=new EdgeOptions();
				edgeOptions.addArguments("--headless");
				driver=new EdgeDriver(edgeOptions);
				break;
			case "Safari":
//				SafariOptions safariOptions=new SafariOptions();
//				safariOptions.
				driver=new SafariDriver();
			default:
				ChromeOptions defaultChromeOptions=new ChromeOptions();
				defaultChromeOptions.addArguments("--headless");
				driver=new ChromeDriver(defaultChromeOptions);
				
				break;
			}
		}else {
			assertTrue(false,"Browser is not selected");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
//		return driver;
		return driver;
		
	}
	public static WebDriver getDriver() {
		return driver;
	}
	

}
