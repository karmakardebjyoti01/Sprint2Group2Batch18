package pages;
 
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class FlightBookingPageFactory extends BaseClass {
//    WebDriver driver;
 
    public FlightBookingPageFactory(WebDriver driver) {
        super(driver);
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
    }
    
    
    @FindBy(xpath = "//input[@id='username']")
	WebElement loginusernameElement;
	@FindBy(xpath = "//input[@id='password']")
	WebElement loginPasswordElement;
	@FindBy(xpath = "(//p[@id='code'])[1]")
	WebElement capcheTextElement;
	@FindBy(xpath = "//input[@id='captcha']")
	WebElement capcheBoxElement;
	@FindBy(xpath = "//button[@id='captchaBtn']")
	WebElement validatElement;
	@FindBy(xpath = "//input[@id='login-submit']")
	WebElement loginButtonElement;
    
    
    
    
 
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
    
    
    
    
    public  void login() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOf(loginusernameElement));
		
		loginusernameElement.sendKeys("flightadmin");
		loginPasswordElement.sendKeys("flightadmin");
		String textString=capcheTextElement.getText();
		System.out.println("Capche"+textString);
		capcheBoxElement.sendKeys(textString);
		validatElement.click();
		driver.switchTo().alert().accept();
		loginButtonElement.click();
		driver.switchTo().alert().accept();
		//change password alert
//		driver.switchTo().alert().accept();
		
	}
}