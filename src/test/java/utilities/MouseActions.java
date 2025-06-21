package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MouseActions {

	 WebDriver driver;

	    public MouseActions(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void hoverOverElement(WebElement element) {
	    	  try {
	    	        if (element != null) {
	    	            Actions actions = new Actions(driver);
	    	            actions.moveToElement(element).build().perform();
	    	        } else {
	    	            System.out.println("Element is null. Cannot perform hover.");
	    	        }
	    	    } catch (Exception e) {
	    	        System.out.println("Exception during hover: " + e.getMessage());
	    	    }
	
	
	
	
}
}