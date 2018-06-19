package modules;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import helpers.Log;
import pageobjects.PackitAdditionalServices;
import pageobjects.PackitDetailsPage;

public class PackitAdditionalServicesModules {

	static String seatPrice;
	// boolean isSeatAvailableToSelect;
	public static void additionalservicesVerify(WebDriver driver) 
	{
 //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		CommonMethods.fluentWait(driver, PackitAdditionalServices.additionalservicesTitle, 6000,2000); 
		 System.out.println("Additional services page header text is: +++++++++++++++++++++++++++" +PackitAdditionalServices.additionalservicesTitle.getText());
		 Log.log.info("Additional services page header text is: +++++++++++++++++++++++++++" +PackitAdditionalServices.additionalservicesTitle.getText());
		 
		if(PackitAdditionalServices.additionalservicesTitle.getText().contains("Additional services")) {
			Assert.assertTrue("Additional services page is displayed", true);
			Reporter.log("Additional services page is displayed");
			Log.log.info("Additional services page is displayed");
		}
		else
		{
			Assert.assertTrue("Additional services page is not  displayed", false);

			Reporter.log("Additional services page is not  displayed");
			Log.log.info("Additional services page is not displayed");
		}
	
	}
	
	public static boolean verifyAdditionalServiceAvailability(WebDriver driver, WebElement elementOfAdditionalservicesTile) 
	{
		boolean isAdditionalServiceavailable = false;
		
		try {
			CommonMethods.fluentWait(driver, elementOfAdditionalservicesTile,3000,1000); 
		isAdditionalServiceavailable = elementOfAdditionalservicesTile.isEnabled();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Additional service is not available");
			Log.log.info("Additional service is not available");
			Assert.assertTrue("Additional service is available", false);
			throw e;
		}
		
		finally {
		System.out.println("Additional service tile check++++++++++++++++++++++++++++++++++++++++++"+isAdditionalServiceavailable);
		Log.log.info("Additional service tile check++++++++++++++++++++++++++++++++++++++++++"+isAdditionalServiceavailable);
		return isAdditionalServiceavailable;	
		}
	}
	
    public static void selectZZF(WebDriver driver) 
    {
	try { 
		
			if(verifyAdditionalServiceAvailability(driver, PackitAdditionalServices.zzfOpenButton)) 
			{   
				
				PackitAdditionalServices.zzfOpenButton.click();
				PackitAdditionalServices.zzfOption1.click();
				PackitAdditionalServices.zzfSubmitButton.click();
			}
			else {
				System.out.println("ZZF is not possible");
				Log.log.info("ZZF is not possible");
				Assert.assertTrue("Zzf is not possible", false);
			}
		
	}catch(Exception e)
		{
			System.out.println("No ZZF is possible");
			Log.log.info("ZZF is not available");
		}
	}
    
    public static void verifyGreenCheck(WebDriver driver,WebElement greencheck) {
    	
    	boolean isGreenCheckAvailable=false;
    	try 
    	{
    	isGreenCheckAvailable=greencheck.isDisplayed();
    	Log.log.info("Green check is displayed ::"+isGreenCheckAvailable);
    	}
    	catch(Exception e) 
    	{
    		isGreenCheckAvailable=false;
    		Log.log.info("Green check is displayed ::"+isGreenCheckAvailable);
    		e.printStackTrace();
    	}
    	
    	if(isGreenCheckAvailable) 
    	{
    		System.out.println("Green check is displayed on additional service box");
    		Log.log.info("Green check is displayed on additional service box"+isGreenCheckAvailable);
    	}
    	else
    	{
    		System.out.println("No green check displayed on additional service box");
    		Log.log.info("No green check displayed on additional service box"+isGreenCheckAvailable);
    	}
    }
	
    public static void proceedToPayment(WebDriver driver) {
    //	CommonMethods.waitforelement(PackitAdditionalServices.ProceedToPaymentButton);
    	CommonMethods.fluentWait(driver, PackitAdditionalServices.ProceedToPaymentButton, 3000, 1000);
    	PackitAdditionalServices.ProceedToPaymentButton.click();
    }
	
    public static boolean verifyAndSelectSeat(WebDriver driver, List<WebElement> seats) 
    {
     boolean isSeatAvailableToSelect = false;
		
		 List<WebElement> seatNums=seats;
		 
		try {  
			  CommonMethods.waitForElementDisappear(driver, PackitAdditionalServices.seatsLoadingImage);
			  Thread.sleep(2000);

				  if(PackitAdditionalServices.noSeatsMessage.isDisplayed()) 
				  {
					 isSeatAvailableToSelect=false;	 
					 Log.log.info("Seats selection is possible"+isSeatAvailableToSelect);
					 Log.log.info("Seatmap not available, request seat at check-in.");
				  }			
			 
		   }catch(Exception e){
									 try {
											 int count=0;
											  for (WebElement seat : seatNums) 
											  {
													try {  
															if(seat.getAttribute("class").contains("packit-free-seat") || seat.getAttribute("class").contains("packit-chargable")) {
																 isSeatAvailableToSelect=true;	
																 Log.log.info("Seats selection is possible"+isSeatAvailableToSelect);
																 Log.log.info(seat.getAttribute("class")+"in foreach loop::"+count);
																	Log.log.info(seat+"+++++++"+ count);
																	Log.log.info(seat.getText()+"in foreach loop::"+count);
																	Log.log.info(seat.getAttribute("seat-id")+"in foreach loop::"+count);
															 seatPrice=seat.getAttribute("data-tipso");
																	seat.click();
																	Thread.sleep(2000);
																	count++;
																	break;
															}							
													}catch (Exception a)
													{
													    e.printStackTrace();	
													    isSeatAvailableToSelect=false;	
													    Log.log.info("Seats selection is possible"+isSeatAvailableToSelect);
														count++;
												     }
												
											 }		  
								       }
											 catch(Exception ee)
											{
												 isSeatAvailableToSelect=false;	
												 Log.log.info("Seats selection is possible"+isSeatAvailableToSelect);
												
											}
							}
		return isSeatAvailableToSelect;
	 }
	
 
    
    
//    public static void selectSeats(WebDriver driver, List<WebElement> seats) 
//    {
//    	System.out.println("Seats before try");
//		Log.log.info("Seats before try");
//		
//		 List<WebElement> seatNums=seats;
//		 
//		try {  
//			System.out.println("Seats in try");
//			Log.log.info("Seats in try");
//			
//			  CommonMethods.waitForElementDisappear(driver, PackitAdditionalServices.seatsLoadingImage);
//			  Thread.sleep(2000);
//			  System.out.println("Seats Size------>"+seats.size());
//			
//				  if(PackitAdditionalServices.noSeatsMessage.isDisplayed()) 
//				  {
//					 Log.log.info("Seatmap not available, request seat at check-in.");
//				  }			
//			 
//		   }catch(Exception e) 
//							{
//									 try {
//											 int count=0;
//											  for (WebElement seat : seatNums) 
//											  {
//													try {  
//															if(seat.getAttribute("class").contains("packit-free-seat") || seat.getAttribute("class").contains("packit-chargable")) {
//																Log.log.info(seat.getAttribute("class")+"in foreach loop::"+count);
//																Log.log.info(seat+"+++++++"+ count);
//																Log.log.info(seat.getText()+"in foreach loop::"+count);
//																Log.log.info(seat.getAttribute("seat-id")+"in foreach loop::"+count);
//														 seatPrice=seat.getAttribute("data-tipso");
//																seat.click();
//																Thread.sleep(2000);
//																count++;
//																break;
//															}							
//													}catch (Exception a)
//													{
//													    e.printStackTrace();	
//													    Log.log.info("Seat is not available at position :" +count);													 
//													    System.out.println("Seats in exception1");
//														Log.log.info("Seats in exception1");
//														count++;
//												     }
//												
//											 }		  
//								       }
//											 catch(Exception ee)
//											{
//												System.out.println("Seats selection is not possible");
//												Log.log.info("Seats selection is not possible");
//												
//												System.out.println("Seats in exception2");
//												Log.log.info("Seats in exception2");
//											}
//							}
//	 }
	
}
