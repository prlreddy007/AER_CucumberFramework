package modules;
import helpers.Log;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Reporter;

import apiCall.HttpClientExample;
import cucumber.deps.difflib.StringUtills;

import pageobjects.PackitSearchPage;
import step_definitions.PackitSearchPageSteps;
import pageobjects.LoginPage;

public class UserEnterFlightDetails {
	
//	public static org.apache.log4j.Logger log;
//	public UserEnterFlightDetails () {
//		log= org.apache.log4j.Logger.getLogger(PackitSearchPageSteps.class.getName());
//		DOMConfigurator.configure("log4j.xml");
//	}
	
	public static String getSession(WebDriver driver) {
		SessionId session = ((ChromeDriver)driver).getSessionId();
//		SessionId session = ((FirefoxDriver)driver).getSessionId();
		System.out.println("Session id:+++++++++++++++++++++++++++++++++++ " + session.toString());
		String packitSessionId=driver.manage().getCookieNamed("aer-session-id").toString();
		System.out.println("packit Session id:+++++++++++++++++++++++++++++++++++ "+packitSessionId);		
		String requiredString = StringUtils.substringBetween(packitSessionId,"%22","%22");
		System.out.println("Session id final is:++++++++++++++++++++++"+requiredString);
		Log.log.info("session id is"+requiredString);
		return requiredString;
		
		
	}
	public static void Execute(WebDriver driver,List<HashMap<String,String>> map) throws Exception{
		
		CommonMethods.waitforelement(PackitSearchPage.from_origin);
		PackitSearchPage.from_origin.clear();
		CommonMethods.waitforelement(PackitSearchPage.from_origin);
		PackitSearchPage.from_origin.sendKeys(map.get(0).get("Origin"));
		PackitSearchPage.to_destination.sendKeys(map.get(0).get("Destination"));
		PackitSearchPage.date_of_travel.sendKeys(map.get(0).get("Departure date"));
		
		PackitSearchPage.return_date_of_travel.sendKeys(map.get(0).get("Arrival date"));
		Thread.sleep(3000);
		PackitSearchPage.flights_search_button.click();
	}
	
	public static void changeLanguage(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
	
		String script="jQuery('#accordion-menu').trigger('setLanguage','en')";
		js.executeScript(script);
		Log.log.info("Changed the language to English");
	}
	
}
