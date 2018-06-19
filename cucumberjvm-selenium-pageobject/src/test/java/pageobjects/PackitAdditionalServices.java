package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PackitAdditionalServices extends BaseClass {

	public PackitAdditionalServices(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Additional services')]")
	public static WebElement additionalservicesTitle;

	@FindBy(how=How.XPATH, using="//a[@ng-click='gotoPayment()']")
	public static WebElement ProceedToPaymentButton;
	
	
	@FindBy(how=How.XPATH, using="(//div[@class='packit-service-option-details clearfix'])[3]")
	public static WebElement zzfOpenButton;
	
	@FindBy(how=How.XPATH, using="(//div[@class='packit-service-option-details clearfix'])[2]")
	public static WebElement extras_SSR_OSI_OpenButton;
	
	
	
	
	@FindBy(how=How.XPATH, using="//div[@class='packit-additional-zzf']/div[4]/div/div/a")
	public static WebElement zzfSubmitButton;
		
	@FindBy(how=How.XPATH, using="(//div[@class='packit-additional-zzf']/div[3]/div/div/input)[1]")
	public static WebElement zzfOption1;
	
	@FindBy(how=How.XPATH, using="(//div[@class='packit-service-option-details clearfix'])[3]/div/div[2]/img[@alt='Checkmark']")
	public static WebElement zzfGreenCheck;
	
	
//###########################Seats objects///////////////////////////////////////////////////////
/////div[@class='packit-select-seats']/div[2]/ul/li/a
	@FindBy(how=How.XPATH, using="//li/a[contains(@class,'packit-seatmap-cell tipso_style')]") 
	public static List<WebElement> seatsList;
	
	@FindBy(how=How.XPATH, using="(//div[@class='packit-service-option-details clearfix'])[1]")
	public static WebElement SeatsOpenButton;
	
	@FindBy(how=How.XPATH, using="(//a[@ng-click='saveChanges()'])[1]")
	public static WebElement seatsSubmitButton;

	@FindBy(how=How.XPATH, using="//*[@id='collapseTwo']/div/div[1]/div[1]/div/div/div[1]/div/div/div[2]/img[1][@alt='Checkmark']")
	public static WebElement seatsGreenCheck;	
	
	@FindBy(how=How.XPATH, using="//*[@id='collapseTwo']/div/div[2]/div/div/div[3]/div[1]/div/div[2]/div[2]/div/div/img")
	public static WebElement seatsLoadingImage;	
	
	
	@FindBy(how=How.XPATH, using="//div[@class='packit-no-seatmap']/p/span")
	public static WebElement noSeatsMessage;	
	
	@FindBy(xpath="(//div[1][@class='packit-passenger-seats']/div/div/span)[3]")
	public static WebElement seatId;
	
	@FindBy(xpath="(//div[1][@class='packit-passenger-seats']/div/div/span)[4]")
	public static WebElement seatPriceOverAccordion;
	
//	@FindBy(xpath="(//div[1][@class='packit-passenger-seats']/div/div/span)[4]")
//	public static WebElement seatPriceOverAccordion;
	
//#######################Extras & SSR/OSI objects////////////////////////////////////////////////
	
	
	
}
