package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightEnquiryPageFactory extends BaseClass {
	WebDriver driver;
	
	public FlightEnquiryPageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	@FindBy(xpath = "//")
	WebElement element;
	
	

}
