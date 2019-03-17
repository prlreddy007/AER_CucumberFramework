package modules;
import helpers.Log;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import pageobjects.BaseClass;
import pageobjects.PackitSearchPage;
import pageobjects.LoginPage;
import pageobjects.PackitResultsPage;
public class FlightResultsDisplay {
	public static void Execute(WebDriver driver,List<HashMap<String,String>> map) throws Exception{
		if(PackitSearchPage.modal_dialog.isDisplayed()) {
			
			Assert.assertTrue("Modal dialog is displayed", true);
//			Reporter.log("Modal dialog is opened");
			Log.log.info("TV banner window is opened");

		}else{
			Assert.assertTrue("Modal dialog is not  displayed", false);

//			Reporter.log("Modal dialog is not  opened");
			Log.log.info("TV banner window is not opened");
		}
		
		CommonMethods.waitforelement(PackitSearchPage.flights_display_message);
//		
//		CommonMethods.fluentWait(driver, PackitSearchPage.flights_display_message, 120000,2000);
//		CommonMethods.waitForElementDisappear(driver, PackitSearchPage.modal_dialog);
		
		System.out.println("Results page title is +++++++++++++: "+PackitSearchPage.flights_display_message.getText());
		
		if(PackitSearchPage.flights_display_message.getText().contains("Airlines")) {
			Assert.assertTrue("Results page is displayed", true);
			Log.log.info("Flight Results are displayed");

//			Reporter.log("Flight Results are displayed");

		}else {
			Assert.assertTrue("Results page is not  displayed", false);
			Log.log.info("Flight Results page is not displayed");
//			Reporter.log("Flight Results are not  displayed");

		}
				
	}
}
