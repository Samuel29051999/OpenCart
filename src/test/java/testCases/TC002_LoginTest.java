package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verifyLogin() {
		
		logger.info("******TC002_LoginTest Started******");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Click on MyAccount");
		
		hp.clickLogin();
        logger.info("Click on the Login");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmailID(p.getProperty("email"));
		
		lp.setPassword(p.getProperty("password"));
		
		lp.clickLogin();
		
		MyAccountPage mcc = new MyAccountPage(driver);
		Boolean target = mcc.isMyAccountPageVisible();
		
		Assert.assertEquals(target, true,"Login Fail");
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("******TC002_LoginTest Finished******");

	}
	
}
