package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][13]")
	WebElement btn_LogOut;
	
	public boolean isMyAccountPageVisible() {
		try {
		return msgHeading.isDisplayed();
		}
		catch(Exception e) {
		   return false;
		}
	}
	
	public void click_logOut () {
		btn_LogOut.click();
	}
	
	
}
