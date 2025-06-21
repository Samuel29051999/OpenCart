package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MacPage extends BasePage {

	public MacPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(xpath="//span[text()=\"Add to Cart\"]")
	WebElement addToCart;
	
	@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]")
	WebElement SucessMassage;
	
	@FindBy(xpath="//a[text()=\"shopping cart\"]")
	WebElement ShoppingCart;
	
	
	
	
	public void clickOnMacImage () {
		
		addToCart.click();
	}
	
	public String addToCartValidation() {
		
		return SucessMassage.getText();
	}
	
	public void clickOnShoppingCart () {
		
		ShoppingCart.click();
	}
	
	
	
}
