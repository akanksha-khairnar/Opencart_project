package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_Login() {
		logger.info("*****starting the TC002_LoginTest*******");
		
		//Home pge
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		lp.set_adrress(p.getProperty("email"));
		lp.set_Pass(p.getProperty("password"));
		lp.Click_OnLogin();
		
		//MyAccount page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean target=macc.isMyAccountPageExist();
		
		//Assert.assertEquals(target, true);
		Assert.assertTrue(target);
		}
		catch(Exception e){
			Assert.fail();
		}
		logger.info("*****Finished the TC002_LoginTest*******");
	}
	
}
