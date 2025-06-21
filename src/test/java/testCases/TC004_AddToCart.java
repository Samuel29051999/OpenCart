package testCases;

import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HeaderPage;
import pageObjects.MacPage;
import testBase.BaseClass;
import utilities.MouseActions;

public class TC004_AddToCart extends BaseClass{


	
@Test
    	public void AddToCart () {
	        
	        HeaderPage hd = new HeaderPage(driver);

	        MouseActions mouse = new MouseActions(driver);
    		
    		mouse.hoverOverElement(hd.DesktopMenu);
    		
    		hd.macClick();
    		
    		MacPage mac = new MacPage(driver);
    		mac.clickOnMacImage();
            mac.clickOnShoppingCart();
            
            CartPage cart = new CartPage (driver);
    		cart.clickCoupon();
    		cart.enterCouponCode();
    		cart.clickApplyCoupon();
    		
    		cart.clickEstimateAccordion();
    		cart.selectCountryDropDown("India");
    		cart.selectZoneDropDown("Maharashtra");
    		cart.enterPostCode("400059");
    		cart.clickOnGetQuotes();
    		
    		cart.clickRadio();
    		cart.clickOnApplyShipping();
    		
    		cart.clickOnUseGiftAccordion();
    		cart.enterGiftvocher("VBNTY678");
    		cart.clickonApplyGift();
    		
    	}
	
	
	
	
	
}
