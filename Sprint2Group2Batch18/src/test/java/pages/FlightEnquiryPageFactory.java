package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightEnquiryPageFactory extends BaseClass{
//	WebDriver driver;
	
	public FlightEnquiryPageFactory(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated constructor stub
		super(driver);
//		Thread.sleep(1000);
//		this.driver=Hook.;
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
		
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
	
	
	
	@FindBy(xpath = "//a[@id='enquiryLink']")
	WebElement equiryLinkElement;
	@FindBy(xpath = "//input[@id='name']")
	WebElement enquiryNameElement;
	@FindBy(xpath ="//input[@id='email']")
	WebElement enquiryEmailElement;
	@FindBy(xpath ="//input[@id='phone']")
	WebElement enquiryphoneElement;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement enquirySubjectElement;
	@FindBy(xpath ="//textarea[@id='message']")
	WebElement enquiryMessageElement;
	@FindBy(xpath ="//button[@id='submit']")
	WebElement enquirySendElement;
	
	
	
	@FindBy(xpath = "//div[@id='nameError']")
	WebElement nameErrorTextElement;
	@FindBy(xpath = "//div[@id='emailError']")
	WebElement emailErrorElement;
	@FindBy(xpath="//div[@id='messageError']")
	WebElement messageErrorElement;
	
	
	@FindBy(xpath ="//div[@id='success-msg']")
	WebElement successMessageElement;
	
	
	

	
	
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
	public  void navigateToEnquiryLink() {
		equiryLinkElement.click();
	}
	public void setName(String name) {
		enquiryNameElement.sendKeys(name);
	}
	public void setEmail(String email) {
		enquiryEmailElement.sendKeys(email);
	}
	public void setPhone(String phone) {
		enquiryphoneElement.sendKeys(phone);
	}
	public void setSubject(String subject) {
		enquirySubjectElement.sendKeys(subject);
	}
	public void setMessage(String message) {
		enquiryMessageElement.sendKeys(message);
	}
	public void sendButton() {
		
		enquirySendElement.click();
	}
	public List<String> checkError(){
		List<String>list=new ArrayList<>();
		String nameErrorString=nameErrorTextElement.getText();
		list.add(nameErrorString);
		String emailErrorString=emailErrorElement.getText();
		list.add(emailErrorString);
		String messageErrorString=messageErrorElement.getText();
		list.add(messageErrorString);
		return list;
	}
	public String  successMsg() {
		String msgString=successMessageElement.getText();
		return msgString;
		
	}
}