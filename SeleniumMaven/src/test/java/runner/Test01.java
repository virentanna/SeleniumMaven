package runner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import commUtilities.CommonFunctions;

public class Test01 {

	public static void main(String[] args) {

//		Create WebDriver object
		WebDriver driver;

		Logger log = Logger.getLogger("Test01");
		PropertyConfigurator.configure("log4j.properties");
		
		System.setProperty("webdriver.chrome.driver", CommonFunctions.CHROME_PATH);
        driver = new ChromeDriver();
		
        log.info("Browser Launched...");
        
		driver.get(CommonFunctions.BASE_URL + "/V4/");
		
		log.info("Application opened...");
		
		driver.close();
		log.info("Browser closed...");
		
	}

}
