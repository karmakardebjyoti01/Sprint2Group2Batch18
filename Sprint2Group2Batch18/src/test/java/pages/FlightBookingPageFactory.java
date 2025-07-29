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
    
    
    
    
 
    @FindBy(id = "travelFrom")
    WebElement fromCityInput;
 
    @FindBy(id = "travelTo")
    WebElement toCityInput;
 
    @FindBy(id = "departure")
    WebElement departureDateInput;
 
    @FindBy(id = "selectClassLabel")
    WebElement selectClassLabel;
    
    @FindBy(id = "name")
    WebElement name;
 
    @FindBy(id = "email")
    WebElement email;
    
    @FindBy(id = "phone")
    WebElement phone;
 
    @FindBy(id = "ticket-class-count")
    WebElement ticketClassCount;
    
    @FindBy(id = "book-now")
    WebElement searchButton;
    
    @FindBy(id = "bookingconfirm")
    WebElement confirmMessage;
 
    @FindBy(id = "errfn")
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
    
    public void selectTravelClass(String className) {
		Select selectClassLabel = new Select(selectClassLabel);
		selectClassLabel.selectByVisibleText(className);
	}
    
    public void enterName(String passengerName) {
        name.clear();
        name.sendKeys(passengerName);
    }
    
    public void enterEmail(String passengerEmail) {
        email.clear();
        email.sendKeys(passengerEmail);
    }
    
    public void enterPhone(String passengerPhone) {
        phone.clear();
        phone.sendKeys(passengerPhone);
    }
 
    public void selectPassengerCount(String count) {
//        passengerCountDropdown.sendKeys(count);
    	ticketClassCount.clear();
    	ticketClassCount.sendKeys(count);
    }
 
    public void clickSearchButton() {
        searchButton.click();
    }
 
    public String getBookingConfirmationMessage() {
        return confirmMessage.getText().trim();
    }

    public String getNameErrorMessage() {
        return errorMessage.getText().trim();
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