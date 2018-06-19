package pageobjects;
import helpers.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends BaseClass{

	public LoginPage(WebDriver driver){
		super(driver);
	}    

	
	@FindBy(how=How.ID, using="user-name")
	public static WebElement username;

	@FindBy(how=How.ID, using="password")
	public static WebElement password;
	
	@FindBy(how=How.ID, using="login-btn")
	public static WebElement signin_button;

	public static void setUsername(String username) {

		LoginPage.username.sendKeys(username);
	}
	

	public static void setPassword(String username) {

		LoginPage.username.sendKeys(username);
	}
	
		
	}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
