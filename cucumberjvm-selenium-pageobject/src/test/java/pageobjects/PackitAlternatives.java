package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PackitAlternatives extends BaseClass {

	public PackitAlternatives(WebDriver driver)
	{
	super(driver);
	}
	
	
	@FindBy(how=How.XPATH, using="//span[text()='Alternatives']")
	public static WebElement alternativesPageTitle;	
	
	@FindBy(how=How.XPATH, using="(//div[2]/div/div/input[@class='packit-button-type-a'])[1]")
	public static WebElement alternativesProceed;
	
	
	@FindBy(how=How.XPATH, using="//div[2]/div[1]/div/div/div[1]/ul/li[9]/a[1]/span")
	public static WebElement alternativesShowMore;

	//Price table objects
		@FindBy(how=How.XPATH, using="//div[2][@class='packit-price-details-section']/div[1]/div/div/div[2]/ul[1]/li")
		public static List<WebElement> alternativesPriceDetails;
		
		@FindBy(how=How.XPATH, using="//div[2][@class='packit-price-details-section']/div[1]/div/div/div[2]/ul/li[9]")
		public static List<WebElement> alternativesPriceTotals;
		
		
	
}
