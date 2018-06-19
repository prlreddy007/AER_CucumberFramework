package modules;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xsd2inst.SampleXmlUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.Select;

import pageobjects.PackitDetailsPage;

public class EnterPaxDetails {
	public static void paxDetailsEntry(WebDriver driver,List<HashMap<String,String>> map) throws Exception {
		//		Select salutation= new Select(PackitDetailsPage.salutationDropdown);
		//		salutation.selectByValue(value);


//		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
//		Thread.sleep(3000);
		//		JavascriptExecutor js = (JavascriptExecutor) driver;  
		//		js.executeScript("window.scrollBy(0,600)");
		
		//CommonMethods.waitforelement(PackitDetailsPage.salutationDropdown);
		CommonMethods.fluentWait(driver, PackitDetailsPage.salutationDropdown, 10000,2000);
		PackitDetailsPage.salutationDropdown.click();
		
		PackitDetailsPage.salutationMRs.click();
		//js.executeScript("arguments[0].click();",PackitDetailsPage.firstName);
		//PackitDetailsPage.firstName.click();
		PackitDetailsPage.firstName.sendKeys(map.get(0).get("Pax FirstName"));
		//js.executeScript("arguments[0].click();",PackitDetailsPage.lastName);
		//PackitDetailsPage.lastName.click();
		PackitDetailsPage.lastName.sendKeys(map.get(0).get("Pax LastName"));
		
	    //PackitDetailsPage.salutationDropdown.click();
		//PackitDetailsPage.salutationMRs.click();
		
		PackitDetailsPage.dobPicker.sendKeys("03061993");
		
	}
	
	public static void packitDetailsProceed(WebDriver driver) throws Exception{
		CommonMethods.waitforelement(PackitDetailsPage.detailsProceed);
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].scrollIntoView(true);",PackitDetailsPage.detailsProceed);
		PackitDetailsPage.detailsProceed.click();
		

//https://www.swtestacademy.com/verify-url-responses-selenium/
//http://www.seleniumeasy.com/selenium-tutorials/how-to-verify-tooltip-text-with-selenium-webdriver-using-java
	}
	

}
