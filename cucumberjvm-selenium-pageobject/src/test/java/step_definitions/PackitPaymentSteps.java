package step_definitions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DataHelper;
import helpers.Log;
import modules.CommonMethods;
import modules.PackitAdditionalServicesModules;
import modules.PackitPaymentModules;
import pageobjects.PackitAdditionalServices;
import pageobjects.PackitCommonObjects;
import pageobjects.PackitPayment;
import pageobjects.PackitResultsPage;

public class PackitPaymentSteps {
	public WebDriver driver;
    public List<HashMap<String,String>> datamap;
	
    public PackitPaymentSteps() {
    	 driver = Hooks.driver;
 	    datamap = DataHelper.data();
    }
	
    @When("^I proceed from additional services$")
	public void iProceedFromAdditionalServices() throws Throwable {
		PageFactory.initElements(driver, PackitAdditionalServices.class);
		PackitAdditionalServicesModules.proceedToPayment(driver);
	}

	@And("^I verify if loader is displaying$")
	public void iVerifyIfLoaderIsDisplaying() throws Throwable {
		PageFactory.initElements(driver, PackitCommonObjects.class);
	//	CommonMethods.verifyLoaderDisplay(driver);
		CommonMethods.waitForElementDisappear(driver,PackitCommonObjects.loaderIcon);
	}

	@Then("^I verify if payment page accordion is displaying$")
	public void iVerifyIfPaymentPageAccordionIsDisplaying() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		PackitPaymentModules.isPaymentPageDisplaying(driver);
	}

	@Given("^I verify if the form of payment dropdown is available$")
	public void iVerifyIfTheFormOfPaymentDropdownIsAvailable() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
	    CommonMethods.verify_isDisplayed(driver,PackitPayment.formOfPayment);
	}

	@And("^I select the credit card payment from form of payment dropdown$")
	public void iSelectTheCreditCardPaymentFromFormOfPaymentDropdown() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		CommonMethods.dropdownSelect(driver, PackitPayment.formOfPayment, PackitPayment.paymentMethods,"Credit card");
	}

	@Then("^I verify and close if AM(\\d+) auto adjustment popup is displayed$")
	public void iVerifyAndCloseIfAMAutoAdjustmentPopupIsDisplayed(int arg1) throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		PackitPaymentModules.verifyAgentMarkup3AutoUpdatePopup(driver);
		//Thread.sleep(3000);
	}

	@And("^I select the credit card type$")
	public void iSelectTheCreditCardType() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		CommonMethods.dropdownSelect(driver, PackitPayment.cardType, PackitPayment.cardTypes,"VISA");
	}

	@Then("^I verify price table calculations$")
	public void iVerifyPriceTableCalculations() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
//		Thread.sleep(1000);
		PackitPaymentModules.verifyPriceTableCalculations(driver, "Credit card", PackitPayment.allPriceValues, PackitPayment.allPriceValues);
//		Thread.sleep(1000);
	}

	@Given("^I click on Show more in Payment page$")
	public void iClickOnShowMoreInPaymentPage() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
	//CommonMethods.fluentWait(driver, PackitPayment.showMorePaymentPage, 3000, 1000);
		PackitPayment.showMorePaymentPage.click();
	}

	@Given("^I verify by adding the AM(\\d+) within the threshold limits$")
	public void iVerifyByAddingTheAMWithinTheThresholdLimits(int arg1) throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		Log.log.info("Entered AM3=60");
		PackitPaymentModules.enterAgentMarkup3(driver, PackitPayment.AgentMarkup3Input, "60");
	}

	@Given("^I verify if Method(\\d+) and Method(\\d+) are available$")
	public void iVerifyIfMethodAndMethodAreAvailable(int arg1, int arg2) throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		PackitPaymentModules.isMethod1Enabled(driver);
	    PackitPaymentModules.isMethod2Enabled(driver);
		
	}

	@And("^I switch the method$")
	public void iSwitchTheMethod() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		PackitPaymentModules.switchMethod(driver);
//		Thread.sleep(2000);
	}

	@Given("^I verify if credit card field is displayed$")
	public void iVerifyIfCreditCardFieldIsDisplayed() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		PackitPaymentModules.isCreditCardFieldDisplaying(driver);
	}

	@And("^I enter the consumer type credit card number$")
	public void iEnterTheConsumerTpeCreditCardNumber() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		PackitPaymentModules.enterCreditCardDetails(driver, 0, PackitPayment.creditCardNumberField,"4242424242424242");
		try {
			PackitPayment.formOfPaymentTitle.click();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
//		Thread.sleep(2000);
	}

	@And("^I enter the corporate type credit card number$")
	public void iEnterTheCorporateTypeCreditCardNumber() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		PackitPaymentModules.enterCreditCardDetails(driver, 0, PackitPayment.creditCardNumberField,"4000051222222221");
		try {
			PackitPayment.formOfPaymentTitle.click();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
//		Thread.sleep(2000);
	}

	
	
	@Given("^I verify by adding the AM(\\d+) more than upper threshold limit$")
	public void iVerifyByAddingTheAMMoreThanUpperThresholdLimit(int arg1) throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
//		PageFactory.initElements(driver, PackitCommonObjects.class);
//		CommonMethods.waitForElementDisappear(driver);
//		Thread.sleep(4000);
		Log.log.info("Entered AM3=6000");
		modules.PackitPaymentModules.enterAgentMarkup3(driver, PackitPayment.AgentMarkup3Input, "6000");
	}

	@And("^I verify if credit card number is displaying$")
	public void iVerifyIfCreditCardNumberIsDisplaying() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		PackitPaymentModules.getCreditCardDetails(driver, 0, PackitPayment.creditCardNumberField);
		
	}

	@Given("^I change the card type to AMERICAN EXPRESS$")
	public void iChangeTheCardTypeToAMERICANEXPRESS() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		CommonMethods.dropdownSelect(driver, PackitPayment.cardType, PackitPayment.cardTypes,"AMERICAN EXPRESS");
//		Thread.sleep(2000);
	}

	@And("^I enter the AMERICAN EXPRESS card number$")
	public void iEnterTheAMERICANEXPRESSCardNumber() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		PackitPaymentModules.enterCreditCardDetails(driver, 0, PackitPayment.creditCardNumberField,"378734493671000");
		try {
		PackitPayment.formOfPaymentTitle.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		Thread.sleep(2000);
	}

	@Given("^I verify by adding the AM(\\d+) less than lower threshold limit$")
	public void iVerifyByAddingTheAMLessThanLowerThresholdLimit(int arg1) throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		Log.log.info("Entered AM3= -20");
		PackitPaymentModules.enterAgentMarkup3(driver, PackitPayment.AgentMarkup3Input, "-20");
	}

	@And("^I fail the test if footnote is displayed after entering card number$")
	public void iFailTheTestIfFootnoteIsDisplayedAfterEnteringCardNumber() throws Throwable {
		PageFactory.initElements(driver, PackitPayment.class);
		PackitPaymentModules.failTestOnFootnoteDisplay(driver);
	}


	
	
    

}

