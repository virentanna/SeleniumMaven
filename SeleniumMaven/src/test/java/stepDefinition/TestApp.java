package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import commUtilities.CommonFunctions;

public class TestApp {

	static WebDriver driver;  
    private static String baseUrl;  
    

    public static void setUp() throws Exception {
    	
		System.setProperty("webdriver.chrome.driver", CommonFunctions.CHROME_PATH);
        driver = new ChromeDriver();

		baseUrl = CommonFunctions.BASE_URL;
		driver.manage().timeouts()
			.implicitlyWait(CommonFunctions.WAIT_TIME, TimeUnit.SECONDS);
		// Go to http://www.demo.guru99.com/V4/
		driver.get(baseUrl + "/V4/");
	
    }

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		setUp();
		
	}

}
