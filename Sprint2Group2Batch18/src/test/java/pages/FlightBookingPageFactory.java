package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightBookingPageFactory extends BaseClass {
    WebDriver driver;

    public FlightBookingPageFactory(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "fromCity")
    WebElement fromCityInput;

    @FindBy(id = "toCity")
    WebElement toCityInput;

    @FindBy(id = "departureDate")
    WebElement departureDateInput;

    @FindBy(id = "returnDate")
    WebElement returnDateInput;

    @FindBy(id = "passengerCount")
    WebElement passengerCountDropdown;

    @FindBy(id = "oneWayCheckbox")
    WebElement oneWayCheckbox;

    @FindBy(id = "searchFlightsBtn")
    WebElement searchButton;

    @FindBy(id = "errorMessage")
    WebElement errorMessage;

    public void enterFromCity(String fromCity) {
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

    public void enterReturnDate(String date) {
        returnDateInput.clear();
        returnDateInput.sendKeys(date);
    }

    public void selectPassengerCount(String count) {
        passengerCountDropdown.sendKeys(count);
    }

    public void uncheckReturnOption() {
        if (oneWayCheckbox.isSelected()) {
            oneWayCheckbox.click();
        }
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean isFlightListDisplayed() {
        // This method should ideally check for an element that confirms flights are listed
        return true; // placeholder, change according to actual flight list web element
    }
} 