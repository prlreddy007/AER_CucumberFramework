package pageobjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PackitPayment extends BaseClass {

	public PackitPayment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Payment buttons-----------------------------------------------------------------------------------
	@FindBy(how=How.XPATH, using="(//input[@type='submit'])[2]")
	public static WebElement payAndOrder;
	
	@FindBy(how=How.XPATH, using="(//input[@type='submit'])[3]")
	public static WebElement reservation;

	
	@FindBy(how=How.XPATH, using="//input[@id='agent']")
	public static WebElement agentField;
	
	@FindBy(how=How.XPATH, using="//input[@id='transaction-number']")
	public static WebElement transactionNumberField;
	
	@FindBy(how=How.XPATH, using="//input[@id='vessel-information']")
	public static WebElement vesselInformationField;
	
	
	//Price table elements-----------------------------------------------------------------------------------
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Payment')]")
	public static WebElement packitPaymentTitle;
	
	@FindBy(how=How.XPATH, using="//div[2]/div[2]/div/div/div/div/div[2]/ul/li[8]")
	public static List<WebElement> priceTotals;
	
	@FindBy(how=How.XPATH, using="//div[@class='packit-show-price-breakdown']/div/div/div[2]/ul[1]/li")
	public static List<WebElement> paxWisePriceTotal;
	
	
	@FindBy(how=How.XPATH, using="//div[@class='packit-show-price-breakdown']/div/div/div[2]/ul/li[contains(text(),',')]")
	public static List<WebElement> allPriceValues;
	
	@FindBy(how=How.XPATH, using="//div[@name='formOfPayments']/div/div/div[1]/span")
	public static WebElement formOfPayment;
	
	@FindBy(how=How.XPATH, using="//div[@name='cardType']/div/div/div[1]/span")
	public static WebElement cardType;
	
	
	@FindBy(how=How.XPATH, using="//span[@class='ui-select-choices-row-inner']/span[2]")
	public static List<WebElement> paymentMethods;
	
	@FindBy(how=How.XPATH, using="//span[@class='ui-select-choices-row-inner']/span[2]")
	public static List<WebElement> cardTypes;
	
	//Agent markup3 popup elements-----------------------------------------------------------------------------------
	@FindBy(how=How.XPATH, using="//h6/span[text()='Markup']")
	public static WebElement AgentMarkup3PopupTitle;
	
	
	@FindBy(how=How.XPATH, using="//div[2]/p[contains(text(),'The markup has been automatically changed')]")
	public static WebElement AgentMarkup3PopupBody;
	
	@FindBy(how=How.XPATH, using="//a[text()='OK']")
	public static WebElement AgentMarkup3OKbutton;
	
	@FindBy(how=How.XPATH, using="//li/div/input[@id=\"agentMarkUp\"]")
	public static WebElement AgentMarkup3Input;
	
	@FindBy(how=How.XPATH, using="(//aer-payment-data/div/div[3]/div[2]/div/div/input[@type='radio'])[1]")
	public static WebElement method1RadioButton;
	
	@FindBy(how=How.XPATH, using="(//aer-payment-data/div/div[3]/div[2]/div/div/input[@type='radio'])[2]")
	public static WebElement method2RadioButton;

	@FindBy(how=How.XPATH, using="//*[@id='collapseFour']/div[2]/div/aer-payment-data/div/div[3]/div[2]/div[1]/div[2]/span[2]")
	public static WebElement Method1_Sum;


	@FindBy(how=How.XPATH, using="//*[@id='collapseFour']/div[2]/div/aer-payment-data/div/div[3]/div[2]/div[2]/div[2]/span[2]")
	public static WebElement Method2_Sum;
	
	@FindBy(how=How.XPATH, using="//ul/li/a[1][@ng-click=\"toggleMarkupContainer()\"]/span[text()='Show more']")
	public static WebElement showMorePaymentPage;
	
	
	@FindBy(how=How.XPATH, using="//aer-payment-data/div/span/span[text()='Form of payment']")
	public static WebElement formOfPaymentTitle;
	
	//Credit card fields-----------------------------------------------------------------------------------
	
	@FindBy(how=How.XPATH, using="//div[@class='fieldCellP']/input")
	public static WebElement creditCardNumberField;
	@FindBy(how=How.XPATH, using="//div[@class='fieldCellM']/input")
	public static WebElement creditCardMonthField;
	
	@FindBy(how=How.XPATH, using="//div[@class='fieldCellY']/input")
	public static WebElement creditCardYearField;
	
	@FindBy(how=How.XPATH, using="//div[@class='fieldCellV']/input")
	public static WebElement creditCardCVVField;
	
	@FindBy(how=How.XPATH, using="//div[@class='fieldCellH']/input")
	public static WebElement creditCardHolderNameField;
	

	@FindBy(how=How.XPATH, using="//p[text()='NO_CREDIT_CARD_DATA_FOUND']")
	public static WebElement noCreditCardDataFoundMessage;
	
	//TSA or APIS confirmation popup-----------------------------------------------------------------------------------
	@FindBy(how=How.XPATH, using="//span[contains(text(),'missing')]")
	public static WebElement tsa_apis_popupTitle;
	
	@FindBy(how=How.XPATH, using="//a[text()='OK']")
	public static WebElement tsa_apis_OKbutton;
	
	@FindBy(how=How.XPATH, using="//a[text()='Reservation only']")
	public static WebElement tsa_apis_ReservationOnlyButton;
	
	
	//Invoice popup-----------------------------------------------------------------------------------
	
	@FindBy(how=How.XPATH, using="//span[text()='Information']")
	public static WebElement invoicePopupTitle;
	
	@FindBy(how=How.XPATH, using="//p[contains(text(),'How do you want to pay')]")
	public static WebElement invoicePopupBody;
	
	@FindBy(how=How.XPATH, using="//a[text()='Invoice']")
	public static WebElement invoice_Button;
	
	@FindBy(how=How.XPATH, using="//a[text()='Same CC']")
	public static WebElement sameCC_Button;
	
	@FindBy(how=How.XPATH, using="//button[text()='×']")
	public static WebElement invoicePopupCloseIcon;
	
	//Insurance popup-----------------------------------------------------------------------------------
	@FindBy(how=How.XPATH, using="//span[text()='Insurance']")
	public static WebElement insurancePopupTitle;
	
	@FindBy(how=How.XPATH, using="//label[@for='noinsurance-0']")
	public static WebElement noInsuranceOption;
	
	@FindBy(how=How.XPATH, using="//label[@for='insurance-0']")
	public static WebElement InsuranceOption1;
	
	@FindBy(how=How.XPATH, using="//a[text()='terms and conditions']")
	public static WebElement InsuranceTermsAndConditionsLink;
	
	@FindBy(how=How.XPATH, using="//label[@for='termsandconditions']/span")
	public static WebElement InsuranceTermsAndConditionsCheckbox;
	
	@FindBy(how=How.XPATH, using="//a/span[contains(text(),'Confirm and proceed with booking')]")
	public static WebElement InsuranceProceedButton;
	
	
	
	//footnote text
	
	@FindBy(how=How.XPATH, using="(//small/span[contains(text(),'by')])[1]")
	public static WebElement footnoteDisagio;
	
	
	
	
	
	
}
