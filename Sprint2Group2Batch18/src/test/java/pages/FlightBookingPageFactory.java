package pages;
 
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class FlightBookingPageFactory extends BaseClass {
//    WebDriver driver;
 
    public FlightBookingPageFactory(WebDriver driver) {
        super(driver);
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
 
    @FindBy(id = "selectclass")
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
		Select selectClassLabelElement = new Select(selectClassLabel);
		selectClassLabelElement.selectByVisibleText(className);
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
//    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", phone);
////    	phoneInput.clear();
//    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    	    wait.until(ExpectedConditions.visibilityOf(phone));
//        phone.clear();
//        phone.sendKeys(passengerPhone);
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll so the phone field touches the bottom edge of the viewport
        js.executeScript(
            "var elem = arguments[0];" +
            "var rect = elem.getBoundingClientRect();" +
            "var offset = window.innerHeight - rect.bottom;" +
            "window.scrollBy(0, offset);",
            phone);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(phone));

        js.executeScript("arguments[0].value = '';", phone);
        phone.sendKeys(passengerPhone);
    }
 
    public void selectPassengerCount(String count) {
//        passengerCountDropdown.sendKeys(count);
//    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ticketClassCount);
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    wait.until(ExpectedConditions.visibilityOf(ticketClassCount));
    	ticketClassCount.clear();
    	ticketClassCount.sendKeys(count);
    }
 
    public void clickSearchButton() {
//    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", searchButton);
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    wait.until(ExpectedConditions.visibilityOf(searchButton));
    	    System.out.println("Enter the submit button");
        searchButton.click();
    }
 
    public String getBookingConfirmationMessage() {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript(
    	        "var elem = arguments[0];" +
    	        "var rect = elem.getBoundingClientRect();" +
    	        "window.scrollBy(0, rect.top);",   // or simply: elem.scrollIntoView(true)
    	        phone);

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    wait.until(ExpectedConditions.visibilityOf(confirmMessage));
    	    System.out.println("Confirm Message: "+confirmMessage.getText().trim());
        return confirmMessage.getText().trim();
    }

    public String getNameErrorMessage() {
    	System.out.println("Error Message: "+errorMessage.getText().trim());
        return errorMessage.getText().trim();
    }
    
    
    
    
    public  void login() {
    	System.out.print("Entering the login func");
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