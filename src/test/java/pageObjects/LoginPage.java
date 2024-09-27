package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	WebDriver driver;

	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement textemail;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement textpass;
	
	@FindBy(xpath="//input[@value='Login']") 
	WebElement loginbutton;
	
	
	public void set_adrress(String email) {
		
		textemail.sendKeys(email);
	}
	
   public void set_Pass(String pass) {
		
		textpass.sendKeys(pass);
	}
	
   public void Click_OnLogin() {
		
		loginbutton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
