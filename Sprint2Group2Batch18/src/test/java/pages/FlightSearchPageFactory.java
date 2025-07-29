package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSearchPageFactory extends BaseClass {

    public FlightSearchPageFactory(WebDriver driver) {
        super(driver);
    }

    // -------------------- Login Elements -------------------- //

    @FindBy(xpath = "//input[@id='username']")
    WebElement loginusernameElement;

    @FindBy(xpath = "//input[@id='password']")
    WebElement loginPasswordElement;

    @FindBy(xpath = "(//p[@id='code'])[1]")
    WebElement captchaTextElement;

    @FindBy(xpath = "//input[@id='captcha']")
    WebElement captchaBoxElement;

    @FindBy(xpath = "//button[@id='captchaBtn']")
    WebElement validateCaptchaElement;

    @FindBy(xpath = "//input[@id='login-submit']")
    WebElement loginButtonElement;

    // -------------------- Navigation -------------------- //
    @FindBy(xpath = "//a[@id='flightSearchLink']")
    WebElement flightSearchLink;

    // -------------------- Search Input Fields -------------------- //
    @FindBy(id = "myInputnumber")
    WebElement flightNumberInput;

    @FindBy(id = "myInputname")
    WebElement flightNameInput;

    @FindBy(id = "myInputtype")
    WebElement flightTypeInput;

    // -------------------- Search Buttons -------------------- //
    @FindBy(id = "mySearchnumber")
    WebElement searchByFlightNumberBtn;

    @FindBy(id = "mySearchname")
    WebElement searchByFlightNameBtn;

    @FindBy(id = "mySearchtype")
    WebElement searchByFlightTypeBtn;

    @FindBy(id = "noResultsMessage")
    WebElement noResultsMessage; 
    
    // -------------------- Table Data -------------------- //
    @FindBy(xpath = "//table[@id='myTable']//tbody/tr")
    List<WebElement> flightRows;

    // -------------------- Methods -------------------- //

    public void login() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginusernameElement));

        loginusernameElement.sendKeys("flightadmin");
        loginPasswordElement.sendKeys("flightadmin");

        String captcha = captchaTextElement.getText();
        captchaBoxElement.sendKeys(captcha);

        validateCaptchaElement.click();
        driver.switchTo().alert().accept();
        loginButtonElement.click();
        driver.switchTo().alert().accept();
    }

    public void navigateToFlightSearch() {
        flightSearchLink.click();
    }

    public void searchByFlightNumber(String number) {
        flightNumberInput.clear();
        flightNumberInput.sendKeys(number);
        searchByFlightNumberBtn.click();
    }

    public void searchByFlightName(String name) {
        flightNameInput.clear();
        flightNameInput.sendKeys(name);
        searchByFlightNameBtn.click();
    }

    public void searchByFlightType(String type) {
        flightTypeInput.clear();
        flightTypeInput.sendKeys(type);
        searchByFlightTypeBtn.click();
    }

    public boolean isFlightNumberPresent(String number) {
        return flightRows.stream().anyMatch(row -> row.getText().contains(number));
    }

    public boolean isFlightNamePresent(String name) {
        return flightRows.stream().anyMatch(row -> row.getText().toLowerCase().contains(name.toLowerCase()));
    }

    public boolean isFlightTypePresent(String type) {
        return flightRows.stream().anyMatch(row -> row.getText().toLowerCase().contains(type.toLowerCase()));
    }

    public boolean areNoResultsDisplayed() {
       return flightRows.size() == 0 || flightRows.stream().allMatch(row -> row.getText().trim().isEmpty());
    }
    public boolean isNoResultsMessageDisplayed() {
        try {
            return noResultsMessage.isDisplayed() && noResultsMessage.getText().trim().length() > 0;
        } catch (Exception e) {
            return false;
        }
    }

	
}
