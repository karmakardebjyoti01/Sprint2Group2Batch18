package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginModulePageFactory extends BaseClass{
 List<String>list;
	public LoginModulePageFactory(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
	
	@FindBy(xpath = "//div[@id='usernameErr']")
	WebElement usernameErrorElement;
	@FindBy(xpath = "//div[@id='passwordErr']")
	WebElement passwordErrorElement;
	@FindBy(xpath = "//div[@id='captchaErr']")
	WebElement capcheErrorElement;
	@FindBy(xpath = "//input[@id='remember_me']")
	WebElement rememElement;
	@FindBy(xpath = "//a[@id='reset-password-link']")
	WebElement resetPasswordElement;
	
	
	
	public void setUsername(String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginusernameElement));
		loginusernameElement.sendKeys(username);
	}
	public void setPassword(String password) {
		
		loginPasswordElement.sendKeys(password);
	}
	public void setCaptcha(String capche) {
		if(capche.equalsIgnoreCase("Valid")) {
			String textString=capcheTextElement.getText();
			System.out.println("Capche"+textString);
			capcheBoxElement.sendKeys(textString);
		}
		
		
		
	}
	public String clickValidate() {
		try {
		validatElement.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

		Alert alert=   driver.switchTo().alert();
		String validateString=alert.getText();
		System.out.println(validateString);
		alert.accept();
		return validateString;
		}catch (Exception e) {
			// TODO: handle exception
			return "";
		}
		
	}
	public List<String> getErrorMessage() {
	
		
		return list;
	}
	public String clickLogin() {
		loginButtonElement.click();
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=   driver.switchTo().alert();
		String validateString=alert.getText();
		System.out.println("login suceess:"+validateString);
		alert.accept();
		return validateString;
		}catch (Exception e) {
			// TODO: handle exception
//			List<String> list=new ArrayList<String>();
			if(usernameErrorElement.isDisplayed()) {
				String s1=usernameErrorElement.getText();
				list.add(s1);
				System.out.println("usernameError"+s1);
			}
			if(passwordErrorElement.isDisplayed()) {
				String s2=passwordErrorElement.getText();
				list.add(s2);
				System.out.println("passwordEeoe:"+s2);
			}
			if(capcheErrorElement.isDisplayed()) {
				String s3=capcheErrorElement.getText();
				list.add(s3);
				System.err.println("capcheError"+s3);
			}
			return null;
		}
	}
	
	public String clickForgetPassword() {
	resetPasswordElement.click();
	String titleString=driver.getTitle();
	return titleString;
		
	}
	public String rememeberMeClick() {
		rememElement.click();
		driver.switchTo().alert().accept();
		Alert alert=driver.switchTo().alert();
		String alertMessageString=alert.getText();
		alert.accept();
		return alertMessageString;
	}
	
	public  void login() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

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
		
		
	}
	
	
	
	
	
}