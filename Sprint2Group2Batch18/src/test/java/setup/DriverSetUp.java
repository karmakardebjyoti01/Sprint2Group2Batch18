package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetUp {
	static WebDriver driver;
	public static WebDriver getDriver() {
		driver=new ChromeDriver();
		return driver;
	}

}
