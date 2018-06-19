package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PackitSearchPage extends BaseClass{
	
	public PackitSearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"headingOne\"]/h1/span/span")
	public static WebElement page_heading;
	
	@FindBy(how=How.XPATH, using="//a[@ng-click='closePopup()']/span")
	public static WebElement calculationInfoPopup_OK_Button;
	
	
	
	@FindBy(how=How.XPATH, using="(//input[@name='airport'])[1]")
	public static WebElement from_origin;
	
	
	@FindBy(how=How.XPATH, using="(//input[@name='airport'])[2]")
	public static WebElement to_destination;
	
	@FindBy(how=How.XPATH, using="(//input[@name='txtDatePicker'])[1]")
	public static WebElement date_of_travel;
	
	
	@FindBy(how=How.XPATH, using="(//input[@name='txtDatePicker'])[2]")
	public static WebElement return_date_of_travel;
	
	@FindBy(how=How.XPATH, using="//div[@class='modal-body']")
	public static WebElement modal_dialog;
	
	@FindBy(how=How.XPATH, using="//div[@id='packit-header-details1']")
	public static WebElement flights_display_message;
	
	@FindBy(how=How.XPATH, using="//input[@id='btnSearchForm']")
	public static WebElement flights_search_button;
	
	
	@FindBy(how=How.XPATH, using="//label[@for='WEB']/span[1]")
	public static WebElement lowCheckBox;
}
