package modules;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.functors.NotNullPredicate;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
//import com.steadystate.css.parser.ParseException;

import helpers.Log;
import pageobjects.BaseClass;
import pageobjects.PackitAdditionalServices;
import pageobjects.PackitCommonObjects;
import pageobjects.PackitPayment;

public class CommonMethods {

	public static boolean verify_enable(WebElement element) {

		boolean verify = element.isEnabled();
		if (verify == true) {
			System.out.println(element + " is enabled");
		} else {
			System.out.println(element + " is not enabled");
		}
		return verify;
	}

	public static boolean verify_isDisplayed(WebDriver driver,WebElement element) {
//		CommonMethods.waitforelement(element);
		CommonMethods.fluentWait(driver, element, 3000, 500);
		boolean verify = element.isDisplayed();
		if (verify) 
		{
			System.out.println(element + " is available");
			Log.log.info(element + " is available");
		} else {
			System.out.println(element + " is not displaying");
			Log.log.info(element + "is not displaying");
		}
		return verify;
	}

	public static void waitforelement(WebElement element) {
		long start = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		//System.out.println("Total Time for loading element- "+element+" is "+totalTime);
		Log.log.info("Total Time for loading element- "+element+" is "+totalTime);
	}

	public static void fluentWait(WebDriver driver, WebElement element, int secondsToWait, int pollingTimeInSeconds) {
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(secondsToWait, TimeUnit.MILLISECONDS)
				.pollingEvery(pollingTimeInSeconds, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		// new WebDriverWait(driver,
		// 10).until(ExpectedConditions.presenceOfElementLocated(locator));

		WebElement verify = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (element.isDisplayed() == true) {
					return element;
				} else {
					return null;
				}

			}

		});
	}

	public static void js_Click(WebElement element) {
		JavascriptExecutor ex = (JavascriptExecutor) BaseClass.driver;
		ex.executeScript("arguments[0].click();", element);
	}

	public static void verifyLoaderDisplay(WebDriver driver) {
		try {
			boolean loaderVerify = PackitCommonObjects.loaderIcon.isDisplayed();
			if (loaderVerify == true) {
				System.out.println("Page loader is displaying");
			}
		} catch (Exception e) {
			System.out.println("Page loader is not displaying");
			e.printStackTrace();
		}
	}

	public static void waitForElementDisappear(WebDriver driver, WebElement loader) throws InterruptedException {
		// WebDriverWait wait = new WebDriverWait(driver, 8);

		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='packit-loading-content-block']/img")));
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Thread.sleep(2000);
		int count = 0;
		try {
			boolean loaderVerify = loader.isDisplayed();

			while (loaderVerify == true) {
				Thread.sleep(1000);
				count++;
				System.out.println("Number of itirations++++++++++++++++++++++/n" + count);
				loaderVerify = PackitCommonObjects.loaderIcon.isDisplayed();

				if (loaderVerify == false) {
					break;
				}
				// else
				// {
				// return;
				// }
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loader is closed after " + (count+2) + "Seconds");
			Log.log.info("loader is closed after " + (count + 2) + "Seconds");
		}

		// Thread.sleep(2000);
		// try {
		// WebElement element=PackitCommonObjects.loaderIcon;
		// Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		// .withTimeout(10000, TimeUnit.MILLISECONDS)
		// .pollingEvery(1000, TimeUnit.MILLISECONDS);
		// // .ignoring(NoSuchElementException.class);
		// // new WebDriverWait(driver,
		// 10).until(ExpectedConditions.presenceOfElementLocated(locator));
		//
		// WebElement verify = wait.until(new Function<WebDriver, WebElement>()
		// {
		// public WebElement apply(WebDriver driver)
		// {
		// if(element.isDisplayed()==true)
		// {
		// return null;
		// }
		// return null;
		// }
		//
		// });
		// }
		// catch(Exception e) {
		// e.printStackTrace();
		// System.out.println("loader is closed");
		// }
	}

	public static void dropdownSelect(WebDriver driver, WebElement selectdropdown, List<WebElement> listOfOptions,String optionToSelect) {
//		CommonMethods.waitforelement(selectdropdown);
		 CommonMethods.fluentWait(driver, selectdropdown, 5000,1000);
		CommonMethods.js_Click(selectdropdown);
		List<WebElement> dropdownList = listOfOptions;
		for (int i = 1; i < dropdownList.size(); i++) {
			if (dropdownList.get(i).getText().contains(optionToSelect)) {
				dropdownList.get(i).click();
				break;
			}
		}
	}

	public static void totalVerify(WebDriver driver, List<WebElement> price_details, List<WebElement> priceTotals) throws java.text.ParseException {
		List<WebElement> pricecolumns = price_details;
		int i;
		double columnWiseTotal = 0.0;
		double paxWiseTotal = 0.0;
		for (i = 2; i < price_details.size(); i++) 
		{
			// System.out.println(pricecolumns.get(i).getText());
			int count = 0;
			double d=0.0;
			// System.out.println(pricecolumns.get(i).getText());
				while (count < 3) 
				{
	
					try {
					    d = parse(pricecolumns.get(i).getText(), Locale.GERMANY);
						break;
					} catch (StaleElementReferenceException e) 
					{
						
					}
					count++;
			
			// System.out.println("required decimal format
			// is:"+parse(pricecolumns.get(i).getText(), Locale.GERMANY));				
			   }	
			
				if (i < (price_details.size() - 2)) 
				{
					columnWiseTotal = columnWiseTotal + d;
					
				}	
				
				if (i == (price_details.size() - 2)) 
				{
					paxWiseTotal = Math.round(d * 100.0) / 100.0;		
					
				}	
				
		}
		double roundOffTotal = Math.round(columnWiseTotal * 100.0) / 100.0;	
		
		double priceTotal=CommonMethods.priceTableTotal(driver, priceTotals);
		
		if (roundOffTotal == paxWiseTotal && roundOffTotal==priceTotal) 
		{
			//System.out.println("column wise sum is matching with the paxwise total and paxwise total is: " + roundOffTotal);
			
			Log.log.info("column wise sum is matching with the paxwise total and paxwise total is: " + roundOffTotal);
			Log.log.info("paxwise total is: " + paxWiseTotal);
			Log.log.info("price table total is: " + priceTotal);
			Assert.assertTrue("Price table is verified", true);
			//return roundOffTotal;
		} 
		else 
		{

		//	System.out.println("column wise sum is not matching with the paxwise total" + roundOffTotal);
			Log.log.info("column wise sum is not matching with the paxwise total and paxwise total is: " + roundOffTotal);
			Log.log.info("column wise sum is matching with the paxwise total and paxwise total is: " + roundOffTotal);
			Log.log.info("paxwise total is: " + paxWiseTotal);
			Log.log.info("price table total is: " + priceTotal);
			Assert.assertTrue("Price table verification is failed", false);
		}
Log.log.info("Paxwise total verification in Results page+++++++++++" + paxWiseTotal);
	
//System.out.println("Paxwise total verification in Results page+++++++++++" + paxWiseTotal);
	}

	public static double sumOfPaxWiseTotal(WebDriver driver, List<WebElement> price_details)
			throws java.text.ParseException {

		// CommonMethods.waitforelement(price_details.get(price_details.size()));
		PageFactory.initElements(driver, PackitPayment.class);
		List<WebElement> pricecolumns = price_details;
		double total = 0.0;
		double paxwiseTotal = 0;
		for (int i = 0; i < price_details.size(); i++) 
		{
				double d = 0.0;
				//boolean staleElement = false;
				int count = 0;
				// System.out.println(pricecolumns.get(i).getText());
				while (count < 3) 
					{
		
						try {
							d = parse(pricecolumns.get(i).getText(), Locale.GERMANY);
							//staleElement = true;
							break;
						} catch (StaleElementReferenceException e) {
							
						}
						count++;
					}
				// System.out.println("required decimal format
				// is:"+parse(pricecolumns.get(i).getText(), Locale.GERMANY));
				if (i < (price_details.size() - 2)) {
					total = total + d;
				}
	
				
				if (i == (price_details.size() - 2)) {
					paxwiseTotal = Math.round(d * 100.0) / 100.0;
					// System.out.println("Paxwise total is+++++++++++"+paxwiseTotal);
				}
		}
		// System.out.println("calculated total is++++"+total);
		double roundOffTotal = Math.round(total * 100.0) / 100.0;

		if (roundOffTotal == paxwiseTotal) {
			System.out.println("column wise sum is matching with the paxwise total and paxwise total is: " + roundOffTotal);
			return roundOffTotal;
		} else {

			System.out.println("column wise sum is not matching with the paxwise total" + roundOffTotal);
			return roundOffTotal;

		}

	}

	public static double priceTableTotal(WebDriver driver, List<WebElement> priceTotals)
			throws java.text.ParseException {

		//Note: As of now placed the webelement hardcoded, Will enhance the method when automating the application for multiple paxes
		
		// CommonMethods.waitforelement(price_details.get(price_details.size()));
		//List<WebElement> pricecolumns = priceTotals;
		// System.out.println("list size is"+price_details.size());
		// System.out.println(pricecolumns.get(price_details.size()-1).getText());
		double priceTableTotal = Math.round(parse(priceTotals.get(priceTotals.size() - 1).getText(), Locale.GERMANY)* 100.0)/100.0;
		// System.out.println("Paxwise total is+++++++++++"+priceTableTotal);
		return priceTableTotal;

	}
	public static double parse(final String amount, final Locale locale) throws java.text.ParseException {
		// reference:
		// https://stackoverflow.com/questions/23990805/converting-different-countrys-currency-to-double-using-java
		final NumberFormat format = NumberFormat.getNumberInstance(locale);
		if (format instanceof DecimalFormat) {
			((DecimalFormat) format).setParseBigDecimal(true);
		}

		BigDecimal newformat = (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]", ""));
		double requiredValue = Double.parseDouble(newformat.toString());
		return requiredValue;
	}

	public static BigDecimal parseCurrency(String value) throws java.text.ParseException {
		// https://codereview.stackexchange.com/questions/38317/optimize-parsing-of-number-for-currency-conversion
		// Pick a suitable locale. GERMANY, for example, uses the 1.234,56 format.
		// You could call .getCurrencyInstance() instead, but then it will
		// require the value to contain the correct currency symbol at a
		// specific position.
		NumberFormat fmt = NumberFormat.getNumberInstance(Locale.GERMANY);

		// By default, fmt.parse() returns a Number that is a Double.
		// However, some decimals, such as 0.10, cannot be represented
		// exactly in floating point, so it is considered best practice to
		// use BigDecimal for storing monetary values.
		((DecimalFormat) fmt).setParseBigDecimal(true);

		return (BigDecimal) fmt.parse(value);

	}

}
