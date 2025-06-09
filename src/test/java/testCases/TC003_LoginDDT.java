package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	
	@Test(dataProvider= "LoginData", dataProviderClass = DataProviders.class )
	
	public void verifyLogin (String ema, String pwd, String exp) {
		
		logger.info("*********TC003_LoginDDT Started**********");
	
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Click on MyAccount");
		
		hp.clickLogin();
        logger.info("Click on the Login");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmailID(ema);
		
		System.out.println(ema);
		
		lp.setPassword(pwd);
		System.out.println(pwd);

		
		lp.clickLogin();
		

		MyAccountPage mcc = new MyAccountPage(driver);
		Boolean target = mcc.isMyAccountPageVisible();

		/* Data is valid   - login success - test pass   - logout
           login failed  - test fail

           Data is invalid - login success - test fail   - logout
           login failed  - test pass
        */
		
		
		if(exp.equals("Valid"))
		{
			if(target==true)
			{
				mcc.click_logOut();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid"))
		{
			if(target==true)
			{
				mcc.click_logOut();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finishing TC_003_DataDrivenTest.......");
		
	}
	
}
		
//		if(exp.equalsIgnoreCase("Valid")) {
		/*	
			if(target==true) {
				mcc.click_logOut();
				Assert.assertTrue(true);;
			}
			
			else {
				Assert.assertTrue(false);
			}
			
		if(exp.equalsIgnoreCase("Invalid")) {
			
			if(target==true) {
				mcc.click_logOut();
				Assert.assertTrue(true);;
			}
			else {
				Assert.assertTrue(true);
			}
		}	
			
			
		}
		}catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("*********TC003_LoginDDT Finished**********");

		
		
	}			
	
	
	
}
*/