package modules;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import helpers.Log;
import pageobjects.PackitCommonObjects;
import pageobjects.PackitDetailsPage;

public class PassengerDetailsDisplay 
{
	public static void detailsDisplay(WebDriver driver)
	{
		
	   try {
		   CommonMethods.waitForElementDisappear(driver,PackitCommonObjects.loaderIcon);
		   if(PackitDetailsPage.detailsPageTitle.getText().contains("Details")) 
			{
				Assert.assertTrue("Deatils page is displayed", true);
				Log.log.info("Details page is displayed");
				Reporter.log("Details page is displayed");
			}		
			   
	       } catch(Exception e) 
	         {
				   e.printStackTrace();	 
					Assert.assertTrue("Deatils page is displayed", false);
	          } 
	}

}
