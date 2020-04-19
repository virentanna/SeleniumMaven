package commUtilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CommonFunctions {
	
	/* You can change the Path of FireFox based on your environment here */
	public static final String CHROME_PATH = "./drivers/chromedriver.exe";
	public static final String FIREFOX_PATH = "./drivers/geckodriver.exe";
	public static final String IE_PATH = "./drivers/IEDriverServer.exe";
    public Logger log;
    
	// Setting Base URL
	public static final String BASE_URL = "http://www.demo.guru99.com/";
    
	// Time to wait when searching for a GUI element 
	public static final int WAIT_TIME = 5; 
											
	// Valid account for login
	public static final String USER_NAME = "mngr252543";
	public static final String PASSWD = "saqysUq";

	// Expected output
	public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
    public static final String EXPECT_ERROR = "User or Password is not valid";

    public static final String PATTERN = ":";
    public static final String FIRST_PATTERN = "mngr";
    public static final String SECOND_PATTERN = "[0-9]+";
    
    public CommonFunctions()
    {
		log = Logger.getLogger("SmokeTest");
		PropertyConfigurator.configure("log4j.properties");
    }
    public static WebDriver openBrowser(WebDriver driver,String browserName)
    {
    	if (browserName.equals("Chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver", CommonFunctions.CHROME_PATH);
            driver = new ChromeDriver();
    	}
    	else if(browserName.equals("Firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", CommonFunctions.FIREFOX_PATH);
            driver = new FirefoxDriver();    		
    	}
    	else if(browserName.equals("IE"))
    	{
    		System.setProperty("webdriver.ie.driver", CommonFunctions.IE_PATH);
            driver = new InternetExplorerDriver();    		
    	}
    	else
    	{
    		System.out.println("Browser not supported !!");
    	}
    		
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(CommonFunctions.WAIT_TIME, TimeUnit.SECONDS);

    	return driver;
    }
    public static void captureScreenshot(WebDriver driver,String screenshotname) throws Exception
    {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrFile, new File("screenshots\\" + screenshotname + ".png"));					

    }
    
}
