package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class FlightBookingPageFactory {
	Webdriver driver;
	
	public FlightBookingPageFactory{
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
