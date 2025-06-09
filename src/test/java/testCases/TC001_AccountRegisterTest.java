package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegisterTest extends BaseClass {

	
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration() {
		
		logger.info("********Starting TC001_AccountRegisterTest*********");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Click on my Account");
		
		hp.clickRegister();
		logger.info("Click on my Register");

		
		AccountRegisterPage regpage = new AccountRegisterPage (driver);
		logger.info("Providing customer details");
		
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password = randomAlphanumberic();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPolicy();
		regpage.setContinue();
		
		logger.info("Validation the final Message");
		String confMsg = regpage.setMsgConfirmation();
		
		if (confMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed...");
			logger.debug("Debugs log...");
            Assert.assertTrue(false);
		}

		
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("********Finished TC001_AccountRegisterTest**********");
	}

}
