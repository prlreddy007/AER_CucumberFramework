package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SwitchTo extends BaseClass {

public SwitchTo(WebDriver driver) {
super(driver);
// TODO Auto-generated constructor stub
}

@FindBy(how=How.XPATH, using="//*[@id='headingOne']/h1/span/span")
public static WebElement resultsAccordion;

@FindBy(how=How.XPATH, using="//li/a[@ng-click='gotoPassengerData()']")
public static WebElement detailsAccordion;

@FindBy(how=How.XPATH, using="//a[@ng-click='gotoAdditionalServices()']/span")
public static WebElement additionalServicesAccordion;

@FindBy(how=How.XPATH, using="//a[@id='editBtnSearchForm']/span")
public static WebElement packitChangeButton;

@FindBy(how=How.XPATH, using="//a[@ng-click='gotoPaymentDetails()']")
public static WebElement paymentAccordion;


}
