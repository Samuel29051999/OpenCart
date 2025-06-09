package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver) {
		
		super(driver);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//ul[@class=\"dropdown-menu dropdown-menu-right\"]//li[1]//a")
	WebElement register;
	
	@FindBy(xpath="//li[normalize-space()='Login']")
	WebElement login;
	
	public void clickMyAccount () {
		
		lnkMyAccount.click();
	}
	
	
	public void clickRegister () {
		
		register.click();
	}
	
	public void clickLogin () {
		login.click();
	}
	
	
}
