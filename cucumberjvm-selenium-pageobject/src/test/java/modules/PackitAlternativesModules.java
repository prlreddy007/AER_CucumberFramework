package modules;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import helpers.Log;
import pageobjects.PackitAlternatives;
import pageobjects.PackitCommonObjects;
import pageobjects.PackitDetailsPage;

public class PackitAlternativesModules {
	
	public static boolean isAlternativeseDisplayed(WebDriver driver) {
		 boolean isAlternativesPageDisplayed=false;
		try {
		// CommonMethods.fluentWait(driver, PackitAlternatives.alternativesPageTitle, 3000, 1000);
			CommonMethods.waitForElementDisappear(driver,PackitCommonObjects.loaderIcon);
		 isAlternativesPageDisplayed=PackitAlternatives.alternativesPageTitle.getText().contains("Alternatives");   
		
		}
		catch(Exception e){
			e.printStackTrace();
			 isAlternativesPageDisplayed=false;
			Log.log.info("alternatives display exception check"+isAlternativesPageDisplayed);
			   Assert.assertTrue("alternatives page is displayed", false);
		}
		
		return isAlternativesPageDisplayed;
	}

	public static void alternativesDisplay(WebDriver driver)
	{
				   
		   if(isAlternativeseDisplayed(driver)) 
			{
			   // System.out.println("Alternative page header text  is:"+PackitDetailsPage.alternativesPageTitle.getText());
				Log.log.info("Alternative page header text  is:"+PackitAlternatives.alternativesPageTitle.getText());
				Assert.assertTrue("alternatives page is displayed", true);
				//Reporter.log("alternatives page is displayed");
				Log.log.info("alternatives page is displayed");						
		   }
		   else
		   {
			   Log.log.info("Alternatives is not displayed");
			   Assert.assertTrue("alternatives page is displayed", false);
		   }
					  
 }

		
	
	
	
}
