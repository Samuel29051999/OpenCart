package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public static Properties p;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	//
	public void setUp(String os, String br) throws IOException {

		FileReader file = new FileReader("./src/test/resources/Config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());

		// java -jar selenium-server-4.33.0.jar standalone
		
//		  if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
//		  
//		  DesiredCapabilities capabilities = new DesiredCapabilities();
//		  
//		  //os
//		  
//		  if (os.equalsIgnoreCase("windows")) {
//		  capabilities.setPlatform(Platform.WIN11);
//		  
//		  }else if(os.equalsIgnoreCase("linux")) {
//		  capabilities.setPlatform(Platform.LINUX); }
//		  
//		  
//		  
//		  else if(os.equalsIgnoreCase("mac")) { capabilities.setPlatform(Platform.MAC);
//		  }else {
//		  
//		  System.out.println("No match found for OS "); return; }
//		  
//		  //browser
//		  
//		  switch(br.toLowerCase()) {
//		  
//		  case "chrome" : capabilities.setBrowserName("chrome"); break; case "edge" :
//		  capabilities.setBrowserName("MicrosoftEdge"); break; case "firefox":
//		  capabilities.setBrowserName("firefox"); break; default :
//		  System.out.println("No Matching found "); return;
//		  
//		  }
//		  
//		  driver = new RemoteWebDriver(new
//		  URL("http://localhost:4444/wd/hub"),capabilities);
//		 
//		  
//		  }
//		  
//		  
//		  if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
//		  
//		  switch (br.toLowerCase()) {
//		  
//		  case "chrome": driver = new ChromeDriver(); break; case "edge": driver = new
//		  EdgeDriver(); break; case "firefox": driver = new FirefoxDriver(); break;
//		  default : System.out.println("\"Invalid Browser Name.........\" "); return;
//		  
//		  } }
//		 
		
		   switch (br.toLowerCase()) {
		   
		   case "chrome": driver = new ChromeDriver(); break; 
		   case "edge": driver = new
		   EdgeDriver(); break; case "firefox": driver = new FirefoxDriver(); break;
		   default : System.out.println("\"Invalid Browser Name.........\" "); return;
		  
		  }
		 

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("Url"));
		driver.manage().window().maximize();
	}

//	@AfterClass(groups = { "Sanity", "Regression", "Master" })
//	public void teardown() {
//
//		driver.quit();
//	}

	public String randomString() {

		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String randomAlphanumberic() {
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		String generatedNumber = RandomStringUtils.randomNumeric(4);
		return (generatedString + "$" + generatedNumber);

	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());

		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);

		String tragetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		File targetFile = new File(tragetFilePath);
		sourceFile.renameTo(targetFile);

		return tragetFilePath;
	}

}
