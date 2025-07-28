package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import setup.DriverSetUp;
import setup.PropertiesProvider;
import io.cucumber.java.Scenario;

public class Hook {
  public  static WebDriver driver;
    Properties properties;
    
	
	@Before
	public  void setup() throws Exception{
		driver=DriverSetUp.initializeDriver();
		driver.get(PropertiesProvider.getKey("appUrl"));
		
	}
	@AfterStep
	public void snapShot(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "./image/img.png",scenario.getName());
		}
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	
}
