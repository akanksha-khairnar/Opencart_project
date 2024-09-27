package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver){
		super(driver);
	}


	@FindBy(xpath="//input[@id='input-firstname']") 
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") 
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement emailid;
	
	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement confirmpassword;
	
	@FindBy(xpath="//input[@name='agree']") 
	WebElement privpolicy;
	
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement continuebutton;
		
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
		
	}

	public void setLastName(String lname) {
		lastName.sendKeys(lname);
		
	}
	public void setEmail(String email) {
		emailid.sendKeys(email);
		
	}

	public void setTelephone(String telno) {
		telephone.sendKeys(telno);
		
	}

	public void setPassword(String pass) {
		password.sendKeys(pass);
		
	}
	public void setConfirmPass(String conpass) {
		confirmpassword.sendKeys(conpass);
		
	}
	public void privayPolicy() {
		privpolicy.click();
		
	}
	 public void continueButton() {
		 continuebutton.click();
		 
	 }

	 public String  getmsgConfirmation() {
		 
		 return (msgConfirmation.getText());
	 }



}
