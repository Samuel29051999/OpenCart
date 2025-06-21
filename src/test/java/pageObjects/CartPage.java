package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"accordion\"]/div[1]/div[1]/h4/a")
	WebElement Coupon;
	
	@FindBy(css="[id=\"input-coupon\"]")
	WebElement placeholderCoupon;
	
	@FindBy(css="[id=\"button-coupon\"]")
	WebElement ApplyCoupon;
	
	@FindBy(xpath="//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")
	WebElement Estimate;
	
	@FindBy(css="[id=\"input-country\"]")
	WebElement CountryDropDown;
	
	@FindBy(css="[id=\"input-zone\"]")
	WebElement ZoneDropDown;
	
	@FindBy(css="[id=\"input-postcode\"]")
	WebElement postcode;
	
	@FindBy(xpath="//*[@id=\"button-quote\"]")
	WebElement GetQuotes;
	
	@FindBy(xpath="//*[@id=\"modal-shipping\"]/div/div/div[2]/div/label/input")
	WebElement radio;
	
	@FindBy(xpath="//input[@id=\"button-shipping\"]")
	WebElement applyShipping;
	
	@FindBy(xpath="//*[@id=\"accordion\"]/div[3]/div[1]/h4/a")
	WebElement UseGift;
	
	@FindBy(css="[id=\"input-voucher\"]")
	WebElement GiftPlaceholder;
	
	@FindBy(xpath="//input[@id=\"button-voucher\"]")
	WebElement ApplyGift;
	
	
	
	
	
	public void clickCoupon() {
		
		Coupon.click();
	}
	
	public void enterCouponCode () {
		
		placeholderCoupon.sendKeys("RTYFGH567");
	}
	
	public void clickApplyCoupon() {
		
		ApplyCoupon.click();
	}
	
	public void clickEstimateAccordion() {
		WebDriverWait wait = new WebDriverWait ( driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(Estimate));
		
		Estimate.click();
	}
	
	public void selectCountryDropDown (String coutryName) {
		
		Select DropDown = new Select (CountryDropDown);
		DropDown.selectByVisibleText(coutryName);
	
	}
	
	public void selectZoneDropDown(String zoneName) {
		
		Select zone = new Select (ZoneDropDown);
        zone.selectByVisibleText(zoneName);
		
		
	}
	
	public void enterPostCode(String postcodeNo) {
		
		postcode.sendKeys(postcodeNo);		
	}
	
	public void clickOnGetQuotes () {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(GetQuotes));
		
		GetQuotes.click();
	}
	
	public void clickRadio() {

		radio.click();
	}
	
	public void clickOnApplyShipping () {
		
		applyShipping.click();
	}
	
	public void clickOnUseGiftAccordion () {
		
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(UseGift));
		
		UseGift.click();
		
	}
	
	public void enterGiftvocher(String vocher){
		
		GiftPlaceholder.sendKeys(vocher);
	}
	
	public void clickonApplyGift () {
		ApplyGift.click();
	}
	
}
