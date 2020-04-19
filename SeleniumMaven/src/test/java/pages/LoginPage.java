package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public static By userName = By.name("uid");
	public static By passWD = By.name("password");
	public static By btnLogin = By.name("btnLogin");
	
	public void loginTOGuru99(WebDriver driver,String uName,String pwd)throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(userName).sendKeys(uName);
		Thread.sleep(3000);
		driver.findElement(passWD).sendKeys(pwd);
		Thread.sleep(3000);
		driver.findElement(btnLogin).click();
	}
	
}
