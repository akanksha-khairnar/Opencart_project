package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	

	@Test(dataProvider="LoginData" ,dataProviderClass=DataProviders.class,groups="DataDriven")//getting dataprovider from different class
	public void varify_LoginDDT(String email,String password,String expt) {
		
		logger.info("*****Starting the TC003_LoginDDT*******");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		lp.set_adrress(email);
		lp.set_Pass(password);
		lp.Click_OnLogin();
		
		//MyAccount page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean target=macc.isMyAccountPageExist();
		
		/*data is valid-login success-test pass-logout
		data is valid=login failed=test fail

		data is invalid -login success-test fail-logout
		data is invalid-login failed-test pass-
		 */
		if(expt.equalsIgnoreCase("valid")) {
			if(target==true) {
				Assert.assertTrue(true);
				macc.clickOnLogOut();
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(expt.equalsIgnoreCase("invalid")) {
			if(target==true) {
				macc.clickOnLogOut();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
				
			}
		}
		}
		catch(Exception e) {
			
			Assert.fail();
			
		}
		logger.info("*****Finished the TC003_LoginDDT*******");
	}
}
