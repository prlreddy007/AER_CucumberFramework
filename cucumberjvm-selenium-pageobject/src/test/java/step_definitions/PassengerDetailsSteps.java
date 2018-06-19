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
import modules.CommonMethods;
import modules.EnterPaxDetails;
import modules.PassengerDetailsDisplay;
import pageobjects.PackitDetailsPage;
import pageobjects.PackitResultsPage;


public class PassengerDetailsSteps {
	
	public WebDriver driver;
    public List<HashMap<String,String>> datamap;
	
	public PassengerDetailsSteps()
	{
		 driver = Hooks.driver;
	    datamap = DataHelper.data();
	}
	
	@Then("^I verify if the passenger details page is displayed$")
	public void iVerifyIfThePassengerDetailsPageIsDisplayed() throws Throwable {
		PageFactory.initElements(driver, PackitDetailsPage.class);
		PassengerDetailsDisplay.detailsDisplay(driver);
	}

	@Given("^I enter passenger details$")
	public void iEnterPassengerDetails() throws Throwable {
		PageFactory.initElements(driver, PackitDetailsPage.class);
		EnterPaxDetails.paxDetailsEntry(driver, datamap);	
	}
	
	@When("^I proceed from details page$")
	public void iProceedFromDetailsPage() throws Throwable {
		PageFactory.initElements(driver, PackitDetailsPage.class);
        EnterPaxDetails.packitDetailsProceed(driver);
	}

	@Then("^I verify the price table in details page$")
	public void iVerifyThePriceTableInDetailsPage() throws Throwable {
		PageFactory.initElements(driver, PackitDetailsPage.class);
		CommonMethods.totalVerify(driver, PackitDetailsPage.detailsPriceDetails, PackitDetailsPage.detailsPriceTotals);
	}

	@Given("^I click on Show more in details page$")
	public void iClickOnShowMoreInDetailsPage() throws Throwable {
		PageFactory.initElements(driver, PackitDetailsPage.class);
		CommonMethods.waitforelement(PackitDetailsPage.detailsShowMore);
		PackitDetailsPage.detailsShowMore.click();
		
	}
}

