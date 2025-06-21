package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage{

	 WebDriver driver;


	public HeaderPage (WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(xpath="//nav[@id=\"menu\"]/div[2]/ul/li[1]/a")
	public WebElement DesktopMenu;
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")
	WebElement Mac;
	
	
	
	
	public void macClick() {

		Mac.click();
	}
	
	
	
	
	
	
}
