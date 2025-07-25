package hooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import setup.DriverSetUp;
import setup.PropertiesProvider;

public class Hook {
    WebDriver driver;
    Properties properties;
	
	@Before
	public  void setup() throws Exception{
		driver=DriverSetUp.getDriver();
		driver.get(PropertiesProvider.getKey("appUrl"));
		
	}
	@After
	public void tearDown() {
		driver.close();
	}
	
	
}
