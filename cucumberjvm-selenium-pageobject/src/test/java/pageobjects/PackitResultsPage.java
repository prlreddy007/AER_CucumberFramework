package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PackitResultsPage extends BaseClass{

	public PackitResultsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="(//div[@class='packit-result-item-fare-type']/a/span[1]/img)[1]")
	public static WebElement fareRules_iconFirstFare;
	
	@FindBy(how=How.XPATH, using="//div[@class='packit-close-block']/button")
	public static WebElement fareRulesClose_icon;
	
	@FindBy(how=How.XPATH, using="(//div[@class='packit-flight-row-expanded-view-button']/a/span)[1]")
	public static WebElement flightRow_expandButton;
	
	@FindBy(how=How.XPATH, using="(//div[@class='packit-filter-item-buttons']/div/div[1]/a/span)[1]")
	public static WebElement bookNow_button;
	
	@FindBy(how=How.XPATH, using="//*[@id='aer-flight-results-block']/div/div[1]/div/div[1]/div[2]/div[1]/a")
	public static WebElement detailFareService;
	
	
	@FindBy(how=How.XPATH, using="(//a/span[text()='Show price breakdown'])[1]")
	public static WebElement showPriceBreakDown;
	
	@FindBy(how=How.XPATH, using="(//span[text()='Show more'])[1]")
	public static WebElement showMore;
	
	@FindBy(how=How.XPATH, using="//*[@id='aer-flight-results-block']/div/div[1]/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/ul[1]/li")
	public static List<WebElement> priceDetails;
	
	@FindBy(how=How.XPATH, using="//*[@id='aer-flight-results-block']/div/div[1]/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[9]")
	public static List<WebElement> resultsPriceTotals;
	
	//Filters related objects////////////////////////////////////////////
	@FindBy(how=How.XPATH, using="//div[@id='headingAirlineAlliance']")
	public static List<WebElement> FilterTabs;
	
	@FindBy(how=How.XPATH, using="//div[@id='headingAirlineAlliance']/span/span[contains(text(),'Ticket time limit')]")
	public static WebElement tktFilter;
	
	@FindBy(xpath="//div[@id='headingAirlineAlliance']/span/span[contains(text(),'Baggage')]]")
	public static WebElement baggageFilter;
	
	@FindBy(xpath="//div[@id='headingAirlineAlliance']/span/span[contains(text(),'Fare type')]")
	public static WebElement fareTypeFilter;
	
	@FindBy(xpath="//div[@id='headingAirlineAlliance']/span/span[contains(text(),'Number of stops')]")
	public static WebElement noOfStopsFilter;
	
	@FindBy(xpath="//div[@id='headingAirlineAlliance']/span/span[contains(text(),'Maximum travel time')]")
	public static WebElement maxTravelTimeFilter;
	
	
	@FindBy(xpath="//div[@id='headingAirlineAlliance']/span/span[contains(text(),'Airlines / Alliances')]")
	public static WebElement airlinesFilter;
	
	@FindBy(xpath="//div[@id='headingAirlineAlliance']/span/span[contains(text(),'Via')]")
	public static WebElement viaFilter;
	
	//////////////////Filter options//////////////////////
	@FindBy(how=How.XPATH, using="//img[@title='Later']")
	public static WebElement greenTkt;
	
	@FindBy(how=How.XPATH, using="//img[@title='Published fare']")
	public static WebElement pubType;
	
	@FindBy(how=How.XPATH, using="//span[2][contains(@title,'Lufthansa')]")
	public static WebElement airlineFilterOption;
	
	@FindBy(how=How.XPATH, using="//span[2][contains(@title,'Dublin')]")
	public static WebElement viaFilterOption;
	
	
	//flight results//

	@FindBy(xpath="//div[@class='packit-price']/span")
	public static List<WebElement> listOfPriceOnEachFare;
	
	@FindBy(xpath="//div[@class='packit-form-field-holder packit-sort-by']/div/div/div/div/span/i[@class='caret pull-right'] ")
	public static WebElement bestResultsDropdown;
	
	@FindBy(xpath="//span[contains(text(),'Price ascending')]")
	public static WebElement priceAscendingOption;
	
}
