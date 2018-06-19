package modules;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.IFactoryAnnotation;

import helpers.Log;

//import com.steadystate.css.parser.ParseException;

import pageobjects.PackitAdditionalServices;
import pageobjects.PackitDetailsPage;
import pageobjects.PackitPayment;
import step_definitions.PackitSearchPageSteps;

public class PackitPaymentModules {
	 
//	public static org.apache.log4j.Logger log;
//	
//public PackitPaymentSteps() {
//	
//	log= org.apache.log4j.Logger.getLogger(PackitPaymentSteps.class.getName());
//	DOMConfigurator.configure("log4j.xml");
//}
	
	
	public static void isPaymentPageDisplaying(WebDriver driver) 
	{
// driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//		try {
		 CommonMethods.fluentWait(driver, PackitPayment.packitPaymentTitle, 5000, 500);
 
		// System.out.println("Packit payment page header text is: +++++++++++++++++++++++++++" +PackitPayment.packitPaymentTitle);
		 Log.log.info("Packit payment page header text is: +++++++++++++++++++++++++++" +PackitPayment.packitPaymentTitle);
	
		 if(PackitPayment.packitPaymentTitle.getText().contains("Payment")) {
			Assert.assertTrue("Payment page is displayed", true);
			Log.log.info("Payment page is displayed");
			
//			Reporter.log("Payment page is displayed");
		}
		else
		{
			Assert.assertTrue("Payment page is not  displayed", false);
			Log.log.info("Payment page is not displayed");
//			Reporter.log("Payment page is not  displayed");
		}
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
	}
	
	public static void verifyAgentMarkup3AutoUpdatePopup(WebDriver driver) 
	{
		   try {
			
				if(PackitPayment.AgentMarkup3PopupTitle.isDisplayed()) {
//					System.out.println("Am3 popup is available and "+PackitPayment.AgentMarkup3PopupBody.getText());
					Log.log.info("Am3 popup is available and "+PackitPayment.AgentMarkup3PopupBody.getText());
					PackitPayment.AgentMarkup3OKbutton.click();
				}
				}
				catch (Exception e) {
					System.out.println("Agent Markup3 auto update popup is not displayed");
					Log.log.info("Agent Markup3 auto update popup is not displayed");
				}
		
	 }
	
	public static void methodTotal(WebDriver driver) {
		if(PackitPayment.AgentMarkup3PopupTitle.isDisplayed()==true) {
			System.out.println("Am3 popup is available and "+PackitPayment.AgentMarkup3PopupBody.getText());
			Log.log.info("Am3 popup is available and"+PackitPayment.AgentMarkup3PopupBody.getText());
			PackitPayment.AgentMarkup3OKbutton.click();
		}
		else
		{
			System.out.println("Agent Markup3 auto update popup is not displayed");
		}
	}
	public static boolean verifyFootNoteDisplay(WebDriver driver) throws java.text.ParseException 
	{
	  boolean isFootnoteDisplayed=false;
	  try {
		  isFootnoteDisplayed=PackitPayment.footnoteDisagio.isDisplayed();
	  }
	  catch(Exception e) {
		e.printStackTrace();
		//System.out.println("No Footnote will be shown as credit card number is validated");
		Log.log.info("No Footnote will be shown as credit card number is validated");
		//throw e;
		   isFootnoteDisplayed=false;
	  }

	  finally {
//			System.out.println("FootNote check++++++++++++++++++++++++++++++++++++++++++"+isFootnoteDisplayed);
			Log.log.info("FootNote check++++++++++++++++++++++++++++++++++++++++++"+isFootnoteDisplayed);
			//  return isFootnoteDisplayed;
			}
	
	  return isFootnoteDisplayed;
	}
	
	
	
	public static void verifyPriceTableCalculations(WebDriver driver, String formOfPayment, List<WebElement> price_details, List<WebElement> priceTotals) throws java.text.ParseException, InterruptedException {
		//CommonMethods.waitForElementDisappear(driver);
		
		double sumofPaxwiseTotal=CommonMethods.sumOfPaxWiseTotal(driver, price_details);
		double priceTableTotal=CommonMethods.priceTableTotal(driver, priceTotals);
		Log.log.info("sum of paxwise details"+sumofPaxwiseTotal);
		Log.log.info("priceTableTotal"+priceTableTotal);
//		Thread.sleep(2000);
		if(formOfPayment.equals("Credit card") && !verifyFootNoteDisplay(driver)) 
			{
//				System.out.println("sumof paxwise total"+CommonMethods.sumOfPaxWiseTotal(driver, price_details));
//				System.out.println("Final Total is"+CommonMethods.priceTableTotal(driver, price_details));
				
			
							if(PackitPayment.method2RadioButton.isSelected()) 
							{
								//CommonMethods.waitforelement(PackitPayment.Method2_Sum);
								//CommonMethods.fluentWait(driver, PackitPayment.Method2_Sum, 3000, 1000);
								double method2Total=CommonMethods.parse(PackitPayment.Method2_Sum.getText(), Locale.GERMANY);
								
								Log.log.info("Method2Total"+method2Total);
								
										if(sumofPaxwiseTotal==priceTableTotal && method2Total==priceTableTotal) 
										{
											
											
											Log.log.info("Pricetable calculation is verified when cc payment is selected with Method2");
											
											
		//								System.out.println("Pricetable calculation is verified");	
		//								System.out.println("sum of paxwise details"+sumofPaxwiseTotal);
		//								System.out.println("priceTableTotal"+priceTableTotal);
		//								System.out.println("Method2Total"+method2Total);
										Assert.assertTrue("Pricetable calculation is verified", true);
		//								Reporter.log("Pricetable calculation is verified");
										}
										else
										{
											
											Log.log.info("Pricetable calculation verification failed  when cc payment is selected with Method2");
		//									
		//									System.out.println("Pricetable calculation verification is failed");
		//									System.out.println("sum of paxwise details"+CommonMethods.sumOfPaxWiseTotal(driver, price_details));
		//									System.out.println("priceTableTotal"+CommonMethods.priceTableTotal(driver, price_details));
		//									System.out.println("Method2Total"+method2Total);
											Assert.assertTrue("Pricetable calculation verification is failed", false);
		//									Reporter.log("Pricetable calculation verification is failed");
										}
								
							}
						        else
							{
						        //	CommonMethods.waitforelement(PackitPayment.Method1_Sum);
						        	//CommonMethods.fluentWait(driver, PackitPayment.Method1_Sum, 3000, 1000);
						        	double method1Total=CommonMethods.parse(PackitPayment.Method1_Sum.getText(), Locale.GERMANY);
//						        	Log.log.info("sum of paxwise details"+sumofPaxwiseTotal);
//									Log.log.info("priceTableTotal"+priceTableTotal);
									Log.log.info("Method1Total"+method1Total);
//						        	
									if(sumofPaxwiseTotal==priceTableTotal && method1Total==priceTableTotal) 
									{
									
										Log.log.info("Pricetable calculation is verified when cc payment is selected with Method1");
										
//									System.out.println("Pricetable calculation is verified");	
//									System.out.println("sum of paxwise details"+sumofPaxwiseTotal);
//									System.out.println("priceTableTotal"+priceTableTotal);
//									System.out.println("Method1Total"+method1Total);
									Assert.assertTrue("Pricetable calculation is verified", true);
//									Reporter.log("Pricetable calculation is verified");
									}
									else
									{
										Log.log.info("Pricetable calculation verification failed  when cc payment is selected with Method1");
//									System.out.println("Pricetable calculation verification is failed");
//									System.out.println("sum of paxwise details"+CommonMethods.sumOfPaxWiseTotal(driver, price_details));
//									System.out.println("priceTableTotal"+CommonMethods.priceTableTotal(driver, price_details));
//									System.out.println("Method1Total"+method1Total);
									Assert.assertTrue("Pricetable calculation verification is failed", false);
//									Reporter.log("Pricetable calculation verification is failed");
									}
							}
			
			}
			else
			{
//				System.out.println("sum of paxwise total"+CommonMethods.sumOfPaxWiseTotal(driver, price_details));
//				System.out.println("Final Total is"+CommonMethods.priceTableTotal(driver, price_details));
//				
//				Log.log.info("sum of paxwise details"+sumofPaxwiseTotal);
//				Log.log.info("priceTableTotal"+priceTableTotal);
				
				if(sumofPaxwiseTotal==priceTableTotal) 
					{
//					System.out.println("Pricetable calculation is verified");	
					Assert.assertTrue("Pricetable calculation is verified", true);
//					Reporter.log("Pricetable calculation is verified");
//					Log.log.info("sum of paxwise details"+sumofPaxwiseTotal);
//					Log.log.info("priceTableTotal"+priceTableTotal);
					Log.log.info("Pricetable calculation is verified when non cc payment is selected");
					
				    }
				else
					{
//						System.out.println("Pricetable calculation verification is failed");
						Assert.assertTrue("Pricetable calculation verification is failed", false);
//						Reporter.log("Pricetable calculation verification is failed");
						Log.log.info("Pricetable calculation verification is failed when non cc payment is selected ");
					}
		}
	}
	
	/////////////////////////////////////////////////////
	
//	public static boolean isMethod1Enabled(WebDriver driver)
//	{
//		boolean isMethod1enable = false;
//		try {
//		 isMethod1enable=PackitPayment.method1RadioButton.isEnabled();
//		 Log.log.info("Method1 enable check: "+isMethod1enable);
//				return isMethod1enable;
//	}
//	catch(Exception e) {
//		e.printStackTrace();
//		 Log.log.info("Method1 enable check: "+isMethod1enable);
//		return isMethod1enable;
//	}
//		
//	}
	
//	public static boolean isMethod2Enabled(WebDriver driver) {
//		boolean isMethod2enable = false;
//		try {
//		 isMethod2enable=PackitPayment.method1RadioButton.isEnabled();
//		 Log.log.info("Method2 enable check: "+isMethod2enable);
//				return isMethod2enable;
//	}
//	catch(Exception e) {
//		e.printStackTrace();
//		 Log.log.info("Method2 enable check: "+isMethod2enable);
//		return isMethod2enable;
//	}
//		
//		
//	}
//	
//	public static void switchMethod(WebDriver driver) throws java.text.ParseException
//	{
//		//!verifyFootNoteDisplay(driver) && isMethod1Enabled(driver)==true && isMethod2Enabled(driver)==true
//		try {
//		if(isMethod1Enabled(driver)==true && isMethod2Enabled(driver)==true) 
//		{
//				if(PackitPayment.method1RadioButton.isSelected()) 
//				{
//					//CommonMethods.fluentWait(driver, PackitPayment.method2RadioButton,3000, 1000);
//				PackitPayment.method2RadioButton.click();
//				}
//				else
//				{
//					//CommonMethods.fluentWait(driver, PackitPayment.method1RadioButton,3000, 1000);
//				PackitPayment.method1RadioButton.click();
//				}
//	
//		}
//		else
//		{
////			System.out.println("Methods cannot be switched");
//			Log.log.info("Methods cannot be switched");
//			Assert.assertTrue("Methods cannot be switched", false);
////			Reporter.log("Methods cannot be switched");
//			
//		}	
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			
////			Reporter.log("Methods cannot be switched");
//			
//			
//		}
//		finally {
//			// Log.log.info("Method1 enable check: "+isMethod1enable);
//			Log.log.info("finally block: Methods cannot be switched");
//			Assert.assertTrue("Methods cannot be switched", false);
//			
//		}
//	}

	public static boolean isMethod1Enabled(WebDriver driver) {
		
		boolean isMethod1enable=PackitPayment.method1RadioButton.isEnabled();
		Log.log.info("Method1 enabled  :"+isMethod1enable);
				return isMethod1enable;
				
	}
	public static boolean isMethod2Enabled(WebDriver driver) {
		boolean isMethod2enable=PackitPayment.method2RadioButton.isEnabled();
		Log.log.info("Method1 enabled  :"+isMethod2enable);
				return isMethod2enable;
				//PackitAdditionalServicesModules.seatPrice;
	}
	
	public static void switchMethod(WebDriver driver) throws java.text.ParseException
	{
		if(!verifyFootNoteDisplay(driver) && isMethod1Enabled(driver) && isMethod2Enabled(driver)) 
		{
				if(PackitPayment.method1RadioButton.isSelected()) 
				{
					//CommonMethods.fluentWait(driver, PackitPayment.method2RadioButton,3000, 1000);
				PackitPayment.method2RadioButton.click();
				Log.log.info("Method1 is switched to Method2");
				}
				else
				{
					//CommonMethods.fluentWait(driver, PackitPayment.method1RadioButton,3000, 1000);
				PackitPayment.method1RadioButton.click();
				Log.log.info("Method2 is switched to Method1");
				}
	
		}
		else
		{
			System.out.println("Methods cannot be switched");
			Assert.assertTrue("Methods cannot be switched", true);
			//Reporter.log("Methods cannot be switched");
			Log.log.info("Methods cannot be switched");
		}	

	}

	
	public static void isCreditCardFieldDisplaying(WebDriver driver) {
		try {
		driver.switchTo().frame(0);
		//CommonMethods.waitforelement(PackitPayment.creditCardNumberField);
		 boolean isCCfieldDisplayed=PackitPayment.creditCardNumberField.isDisplayed();
		Log.log.info("Credit card field is displaying correctly"+isCCfieldDisplayed);
		driver.switchTo().defaultContent();
	
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.assertTrue("credit card field is displaying", false);
		}
		
	}
	
	public static void enterCreditCardDetails(WebDriver driver,int iframeIndex,WebElement ccField, String input) {
		driver.switchTo().frame(iframeIndex);
		ccField.clear();
		ccField.sendKeys(input);
		driver.switchTo().defaultContent();
	}
	
	public static void getCreditCardDetails(WebDriver driver,int iframeIndex,WebElement ccField) {
		driver.switchTo().frame(iframeIndex);
		ccField.clear();
		System.out.println("Previously entered credit card number is++++"+ccField.getText());
		//driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		if(ccField.getText()!=null) {
			Assert.assertTrue("credit card number is displaying correctly",true);
		}
		else {
			Assert.assertTrue("credit card data is missing",false);
		}
	}
	public static void enterAgentMarkup3(WebDriver driver, WebElement AM3Field, String amount) throws InterruptedException {
		PackitPayment.AgentMarkup3Input.click();
//		CommonMethods.js_Click(PackitPayment.AgentMarkup3Input);
		PackitPayment.AgentMarkup3Input.sendKeys(amount);
//		CommonMethods.js_Click(PackitPayment.formOfPaymentTitle);
		PackitPayment.formOfPaymentTitle.click();
		//Thread.sleep(2000);
	}
	
	public static void failTestOnFootnoteDisplay(WebDriver driver) throws ParseException, InterruptedException {
		//Thread.sleep(5000);
//		CommonMethods.waitForElementDisappear(driver);
		if(verifyFootNoteDisplay(driver)) {
			Assert.assertTrue("Footnote should be hidden when credit card is entered", false);			
		}
		else {
			Assert.assertTrue("Footnote should be hidden when credit card is entered", true);
		}
		
	}
	

}
