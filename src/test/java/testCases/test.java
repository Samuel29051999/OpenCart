package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class test {
	

	

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver ();
		driver.get("https://tutorialsninja.com/demo/index.php?route=product/category&path=20_27");
		
		WebElement desk = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a"));
		
		Actions act = new Actions(driver);
		act.moveToElement(desk).perform();
		
	}

}
