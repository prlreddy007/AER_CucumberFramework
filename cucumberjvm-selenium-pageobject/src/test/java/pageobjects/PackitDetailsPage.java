package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PackitDetailsPage extends BaseClass {

	public PackitDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(how=How.XPATH, using="//h1[@id='ui-id-11']/span/span[contains(text(),'Passenger')]")
	public static WebElement detailsPageTitle;
	
	@FindBy(how=How.XPATH, using="(//div[@class='btn-group bootstrap-select']/button)[1]")
	public static WebElement salutationDropdown;
	
	@FindBy(how=How.XPATH, using="//div[@class='btn-group bootstrap-select open']/div/ul/li[2]/a")
	public static WebElement salutationMRs;
	
	
	@FindBy(how=How.XPATH, using="(//div[@class='btn-group bootstrap-select']/button)[2]")
	public static WebElement titleDropdown;
	
	@FindBy(how=How.XPATH, using="//*[@id='lastname']")
	public static WebElement lastName;
	
	@FindBy(how=How.XPATH, using="//*[@id='givenname']")
	public static WebElement firstName;
	
	@FindBy(how=How.XPATH, using="(//div/input[@name='date'])[1]")
	public static WebElement dobPicker;
	
	@FindBy(how=How.XPATH, using="//div[3]/div[1]/div/div/div[1]/ul/li[9]/a[1]/span")
	public static WebElement detailsShowMore;
//			@FindBy(how=How.XPATH, using="//*[@id='ui-id-11\']/span/span")
//			public static WebElement lastName;
//
//			@FindBy(how=How.XPATH, using="//*[@id='ui-id-11\']/span/span")
//			public static WebElement firstName;
//
//			@FindBy(how=How.XPATH, using="//*[@id='ui-id-11\']/span/span")
//			public static WebElement dobPicker;

	@FindBy(how=How.XPATH, using="//form[@name='passengerDataFormMain']/div[2]/div/div/input")
	public static WebElement detailsProceed; 

	@FindBy(how=How.XPATH, using="//div[@class='packit-passenger-field-row']/ul/li[6]/ul/li/a")
	public static WebElement detailsFFN;
			
			
	@FindBy(how=How.XPATH, using="//input[@ng-click='confirmTSA()']")
	public static WebElement confirmTSA;



//Price table objects
	@FindBy(how=How.XPATH, using="//div[3][@class='packit-price-details-section']/div[1]/div/div/div[2]/ul[1]/li")
	public static List<WebElement> detailsPriceDetails;
	
	@FindBy(how=How.XPATH, using="//div[3][@class='packit-price-details-section']/div[1]/div/div/div[2]/ul/li[9]")
	public static List<WebElement> detailsPriceTotals;






}
