package modules;
import helpers.Log;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import pageobjects.PackitSearchPage;
import step_definitions.PackitSearchPageSteps;
import pageobjects.LoginPage;
public class SignInAction {
//	public static org.apache.log4j.Logger log;
//	public SignInAction () {
//		log= org.apache.log4j.Logger.getLogger(SignInAction.class.getName());
//		DOMConfigurator.configure("log4j.xml");
//	}
//	
	
	public static void Execute(WebDriver driver,List<HashMap<String,String>> map) throws Exception{
		System.out.println("UName is"+map.get(0).get("username"));
		LoginPage.username.sendKeys(map.get(0).get("username"));
		Log.log.info("user name is entered");
		//Log.info("UserName Is Entered " );
		LoginPage.password.sendKeys(map.get(0).get("password"));
	//	Log.info(" is entered in Password text box" );
		
		LoginPage.signin_button.click();
		//Log.info("Click action is performed on Submit button");
		Thread.sleep(5000);
		System.out.println("Expected is"+map.get(0).get("Expected Result"));
		if(PackitSearchPage.page_heading.getText().contains(map.get(0).get("Expected Result")))
		Reporter.log("SignIn Action is successfully perfomred");
		Assert.assertTrue("SIgn In is succesfull", true);
	}
}
