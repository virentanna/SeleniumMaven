package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.*;
import commUtilities.CommonFunctions;
import commUtilities.ConfigDataProvider;
import commUtilities.ExcelDataProvider;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class LoginSteps extends CommonFunctions {
	
	WebDriver driver;
	private String actualBoxMsg;
    private static String baseUrl;

	@Given("^User opens the Guru(\\d+)\\.com website$")
	public void user_opens_the_Guru_com_website(int arg1) {
		ConfigDataProvider config = new ConfigDataProvider();
		
        log.info("Browser Launch : Started");
//		driver = CommonFunctions.openBrowser(driver, "Chrome");
        driver = CommonFunctions.openBrowser(driver, config.getConfigData("Browser"));
        log.info("Browser Launch : Completed");
//		baseUrl = CommonFunctions.BASE_URL;
//		driver.get(baseUrl + "/V4/");
        driver.get(config.getConfigData("URL"));
		log.info("Website URL launched : Completed");
	}

	@When("^User enters the username and password$")
	public void user_enters_the_username_and_password() {

		//Enter username
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(CommonFunctions.USER_NAME);		
		//Enter password
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(CommonFunctions.PASSWD);

		System.out.println("Username password entered...");
	}
	
	@When("^User enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_and(String uname, String pwd) throws Throwable {
		//Enter username
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(uname);
		
		//Enter password
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(pwd);

		System.out.println("Parameterized Username&Password Entered...");
	    
	}
	
	@Then("^User is able to view the landing page$")
	public void user_is_able_to_view_the_landing_page() throws Exception {
		
		//Click login button
		driver.findElement(By.name("btnLogin")).click();

		 try{ 
				Alert alt = driver.switchTo().alert();
				actualBoxMsg = alt.getText(); // get content of the Alter Message
				alt.accept();
				 // Compare Error Text with Expected Error Value					
				assertEquals(actualBoxMsg,CommonFunctions.EXPECT_ERROR);
				CommonFunctions.captureScreenshot(driver, "login_error");
			}    
		    catch (NoAlertPresentException Ex){ 
		    			    	
		    	// Get text displays on login page 
				String pageText = driver.findElement(By.tagName("tbody")).getText();

				// Extract the dynamic text mngrXXXX on page		
				String[] parts = pageText.split(CommonFunctions.PATTERN);
				String dynamicText = parts[1];

				// Check that the dynamic text is of pattern mngrXXXX
				// First 4 characters must be "mngr"
				assertTrue(dynamicText.substring(1, 5).equals(CommonFunctions.FIRST_PATTERN));
				// remain stores the "XXXX" in pattern mngrXXXX
				String remain = dynamicText.substring(dynamicText.length() - 4);
				// Check remain string must be numbers;
				assertTrue(remain.matches(CommonFunctions.SECOND_PATTERN));

				CommonFunctions.captureScreenshot(driver, "login");
				System.out.println("User logged in successfully...");
	        } 
	}
	
	@Then("^Application should be closed$")
	public void application_should_be_closed() throws Exception  {
		Thread.sleep(2000);
		driver.close();
		log.info("Browser Closed...");
	}
	
	@When("^User enters the credentials and click on Login button$")
	public void user_enters_the_credentials_and_click_on_Login_button() {
		ExcelDataProvider excel = new ExcelDataProvider();
		LoginPage LoginPage = new LoginPage();
		log.info("User logged in : Started");
//		LoginPage.loginTOGuru99(driver, "mngr252543", "saqysUq");
		LoginPage.loginTOGuru99(driver, excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		log.info("User logged in : Completed");
	}

	@Then("^User is able to view the welcome page$")
	public void user_is_able_to_view_the_welcome_page() {
		log.info("Welcome page verification : Started");
		String pageText = driver.findElement(By.tagName("tbody")).getText();
		assertTrue(pageText.contains(CommonFunctions.USER_NAME));
		log.info("Welcome page verification : Completed");
	}
}
