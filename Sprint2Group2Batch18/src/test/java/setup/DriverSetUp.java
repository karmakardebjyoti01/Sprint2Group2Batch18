package setup;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverSetUp {
	static WebDriver driver;
	static Properties p;
	public static WebDriver getDriver() throws Exception {
		
		String browser=PropertiesProvider.getKey("browser");
		System.out.println("Browser"+ browser);
		if(browser!=null) {
			switch (browser) {
			case "Chrome":
				driver=new ChromeDriver();
				break;
			case "FireFox":
				driver=new FirefoxDriver();
				break;
			case "Edge":
				driver=new EdgeDriver();
				break;
			case "Safari":
				driver=new SafariDriver();
			default:
				driver=new ChromeDriver();
				break;
			}
		}else {
			assertTrue(false,"Browser is not selected");
		}
		driver.manage().window().maximize();
//		return driver;
		return driver;
		
	}
	

}
