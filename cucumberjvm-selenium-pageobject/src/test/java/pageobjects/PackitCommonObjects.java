package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PackitCommonObjects extends BaseClass {

	public PackitCommonObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how=How.XPATH, using="//span[@class='packit-loading-content-block']/img")
	public static WebElement loaderIcon;
    
	@FindBy(how=How.XPATH, using="//h6/span[text()='Error']")
	public static WebElement errorPopupTitle;
	
	@FindBy(how=How.XPATH, using="//a[text()='OK']")
	public static WebElement popupOKbutton;
	
	
	@FindBy(how=How.XPATH, using="//div/span[@ng-repeat='messages in popupOptions.body.detailMessages']")
	public static WebElement errorPopupDetailedMessage;
}
