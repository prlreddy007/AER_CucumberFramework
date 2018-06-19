package step_definitions;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
    public static WebDriver driver;
    
    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
    	if(driver==null) {
    	System.out.println("Called openBrowser");
//    	System.setProperty("webdriver.gecko.driver","D:\\Eclipse-Oxygen//geckodriver.exe");
    	//webdriver.firefox.marionette
    	System.setProperty("webdriver.chrome.driver", "D:\\Eclipse-Oxygen\\chromedriver.exe");

    	//    	ProfilesIni profile = new ProfilesIni();
    	// this will create an object for the Firefox profile
    

//    	FirefoxProfile myprofile = profile.getProfile("RamPothireddy");
    	// this will Initialize the Firefox driver

//    	driver = new FirefoxDriver(myprofile);
//       	driver = new FirefoxDriver();
    	driver = new ChromeDriver();
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    	}
    }

     
    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
    	System.out.println("Inside screenshot");

        if(scenario.isFailed()) {
        try {
        	System.out.println("Inside screenshot");
        	 scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
        	System.out.println("Inside Catch");
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        
        }
      // driver.quit();
        
    }
    
}