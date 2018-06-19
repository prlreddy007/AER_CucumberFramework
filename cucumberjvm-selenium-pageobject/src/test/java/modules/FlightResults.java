package modules;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.Log;
import pageobjects.BaseClass;
import pageobjects.PackitResultsPage;

public class FlightResults {
	public static void farerulesDisplay(WebDriver driver) throws Exception {
	//	System.out.println("Verifying BookFlight class");	
        //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		//System.out.println("Driver Is"+driver);	
		System.out.println("Farerules element is  identified");
		Log.log.info("Farerules icon is  identified");
		CommonMethods.fluentWait(driver, PackitResultsPage.fareRules_iconFirstFare, 5000,1000);
		PackitResultsPage.fareRules_iconFirstFare.click();
		CommonMethods.waitforelement(PackitResultsPage.fareRulesClose_icon);
		PackitResultsPage.fareRulesClose_icon.click();
	}
	
public static void openFlightRow(WebDriver driver) throws Exception {
		
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		PackitResultsPage.flightRow_expandButton.click();
	}
	
	public static void bookFlight(WebDriver driver) throws Exception {		
		CommonMethods.waitforelement(PackitResultsPage.bookNow_button);
		PackitResultsPage.bookNow_button.click();	
	}
	
public static void FiltersCount(WebDriver driver) throws Exception {
		
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	
		Thread.sleep(10000);
		List<WebElement> filtersCount = PackitResultsPage.FilterTabs;
		System.out.println("Number of filters available are : ++++++"+ filtersCount.size());
		Log.log.info("Number of filters available are : ++++++"+ filtersCount.size());
		
	}

public static void openAndSelectFlightResultsFilter(WebDriver driver, WebElement filterTypeToOpen, WebElement filterOptionToSelect) {
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	
	try {
			boolean isFilterAvailable=filterTypeToOpen.isDisplayed();
			
			if(isFilterAvailable) 
			{
				filterTypeToOpen.click();
				CommonMethods.waitforelement(filterOptionToSelect);
				boolean isFilterOptionAvailable=filterOptionToSelect.isDisplayed();
				if(isFilterOptionAvailable==true) 
				{
					
					filterOptionToSelect.click();
				}
				else
				{
					System.out.println("Requested filter option is not available");
					Log.log.info("Requested filter option is not available");
				}
			}
			else
			{
				System.out.println("Requested filter is not available");
				Log.log.info("Requested filter is not available");
			}

	}catch(Exception e) {
		Log.log.info("Requested filter or filter option is not available");
	}
}
	

public static void verifyFlightResultsSorting(WebDriver driver, List<WebElement> flightOfferPriceList) throws ParseException {
	
ArrayList<Double> parsedOfferPriceList = new ArrayList<>();
ArrayList<Double> sortedParsedOfferPriceList= new ArrayList<>();
	for (WebElement price : flightOfferPriceList)
	{
		parsedOfferPriceList.add(CommonMethods.parse(price.getText(),Locale.GERMANY));
	}
	Log.log.info("offer price details list is :" +parsedOfferPriceList);
	
	sortedParsedOfferPriceList=parsedOfferPriceList;
	Collections.sort(parsedOfferPriceList);
	
if(sortedParsedOfferPriceList.equals(parsedOfferPriceList)) {
	Log.log.info("offer price details list is :" +parsedOfferPriceList);
	Log.log.info("offer price details list is :" +sortedParsedOfferPriceList);
	Log.log.info("Flight results are sorted in price ascending order");
}
else {
	Log.log.info("offer price details list is :" +parsedOfferPriceList);
	Log.log.info("offer price details list is :" +sortedParsedOfferPriceList);
	Log.log.info("Flight results are not sorted in price ascending order");	
}
	
}


}
