package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightBookingPageFactory extends BaseClass {
	WebDriver driver;
	
	public FlightBookingPageFactory(WebDriver driver){
		super(driver);
	}
	
	@FindBy(id="fromCity")
	WebElement fromCityInput;
	
	@FindBy(id="toCity")
	WebElement toCityInput;
	
	@FindBy(id="departureDate")
	WebElement departureDateInput;
	
	@FindBy(id="searchFlightsBtn")
	WebElement searchButton;
	
	public void enterFromCity(String fromCity){
		fromCityInput.clear();
		fromCityInput.sendKeys(fromCity);
	}
	
	public void enterToCity(String toCity) {
		toCityInput.clear();
		toCityInput.sendKeys(toCity);
	}
	
	public void enterDepartureDate(String date) {
		departureDateInput.clear();
		departureDateInput.sendKeys(date);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
}
