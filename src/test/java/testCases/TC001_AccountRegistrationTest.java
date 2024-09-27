package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
//logging=record all the events in the form of text.
//log levels=All<Trace <Debug<Info<Warm<Error<Fatal<Off
public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"regression","Master"})
	public void verify_Account_Registration() {
		//logger.info("**** starting TC001_AccountRegistrationTest  ***** ");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		//logger.info("Cliked on myAccount");
		hp.clickRegister();
		
		//logger.info("Clicked on clickRegister"); 
		AccountRegistrationPage ar=new AccountRegistrationPage(driver);
		
		//logger.info("Providing customers details...");
		ar.setFirstName( randomString().toUpperCase());
		ar.setLastName( randomString().toUpperCase());
		ar.setEmail(randomString()+"@gmail.com");//randomly generated email id
		
		ar.setTelephone(randomNumber());
		
		String pssword=randomAlphaNumeric();
		ar.setPassword(pssword);
		ar.setConfirmPass(pssword);
		ar.privayPolicy();
		ar.continueButton();
		
		logger.info("Validating expected message....");
		String msg=ar.getmsgConfirmation();
		//Assert.assertEquals(msg, "Your Account Has Been Created!");
		if(msg.equals("Your Account Has Been Created!")) {
			
			Assert.assertTrue(true);
		}
		else {
			//logger.error("Test failed...");
			//logger.debug("Debug logs...");
			Assert.assertTrue(false);
			
		}
		}
		catch(Exception e) {
			
			
			Assert.fail();
		}
		//logger.info("**** Finished TC001_AccountRegistrationTest  ***** ");

	}
	
  







}
