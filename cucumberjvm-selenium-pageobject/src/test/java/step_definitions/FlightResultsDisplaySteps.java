package step_definitions;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DataHelper;
import helpers.Log;
import modules.CommonMethods;
import modules.EnterPaxDetails;
import modules.FlightResults;
import modules.FlightResultsDisplay;
import apiCall.GETapi;
import apiCall.HttpClientExample;
import apiCall.HttpPostExample;
import apiCall.PackitFlowAPI;
import modules.PackitAdditionalServicesModules;
import modules.PassengerDetailsDisplay;
import modules.SignInAction;
import modules.UserEnterFlightDetails;
import pageobjects.LoginPage;
import pageobjects.PackitAdditionalServices;
import pageobjects.PackitDetailsPage;
import pageobjects.PackitResultsPage;
import pageobjects.PackitSearchPage;


public class FlightResultsDisplaySteps {

	public WebDriver driver;
    public List<HashMap<String,String>> datamap;


    public FlightResultsDisplaySteps()
    {
        driver = Hooks.driver;
        datamap = DataHelper.data();
    }

	@And("^I provide origin,destination and return of travel and submit$")
	public void iProvideOriginDestinationAndReturnOfTravelAndSubmit() throws Throwable {
		PageFactory.initElements(driver, PackitSearchPage.class);
//		GETapi.getService(driver);
		UserEnterFlightDetails.Execute(driver, datamap);
		System.out.println("_______________Verify the packitflow API response____________");
		PackitFlowAPI.getSession(driver);
	
		PackitFlowAPI.getCustomerRegistry(driver);
	}

	@Then("^I verify results page$")
	public void iVerifyResultsPage() throws Throwable {
		FlightResultsDisplay.Execute(driver, datamap);
	}
	
	@Then("^I verify fare rules display$")
	public void iVerifyFareRulesDisplay() throws Throwable {
		PageFactory.initElements(driver, PackitResultsPage.class);
		FlightResults.farerulesDisplay(driver);
	}

	@Given("^I book a flight$")
	public void iBookAFlight() throws Throwable {
		PageFactory.initElements(driver, PackitResultsPage.class);
		FlightResults.openFlightRow(driver);
		FlightResults.bookFlight(driver);
	}

	@And("^I verify filters count$")
	public void iVerifyFiltersCount() throws Throwable {
		PageFactory.initElements(driver, PackitResultsPage.class);
		FlightResults.FiltersCount(driver);
	}


	@And("^I open Tkt filter and select green TKT$")
	public void iOpenTktFilterAndSelectGreenTKT() throws Throwable {
		PageFactory.initElements(driver, PackitResultsPage.class);
		FlightResults.openAndSelectFlightResultsFilter(driver, PackitResultsPage.tktFilter, PackitResultsPage.greenTkt);
	}

	@Given("^I click on flight row expand button$")
	public void iClickOnFlightRowExpandButton() throws Throwable {
		PageFactory.initElements(driver, PackitDetailsPage.class);
		FlightResults.openFlightRow(driver);
	}
	
	@And("^I click on Show price break down$")
	public void iClickOnShowPriceBreakDown() throws Throwable {
		PageFactory.initElements(driver, PackitResultsPage.class);
		CommonMethods.waitforelement(PackitResultsPage.showPriceBreakDown);
		PackitResultsPage.showPriceBreakDown.click();
	}

	@And("^I click on Show more$")
	public void iClickOnShowMore() throws Throwable {
		PageFactory.initElements(driver, PackitResultsPage.class);
		CommonMethods.waitforelement(PackitResultsPage.showMore);
		PackitResultsPage.showMore.click();
	}

	@Then("^I verify the price details$")
	public void iVerifyThePriceDetails() throws Throwable {
		PageFactory.initElements(driver, PackitResultsPage.class);
		CommonMethods.totalVerify(driver, PackitResultsPage.priceDetails,PackitResultsPage.resultsPriceTotals);
		
	}

	@Given("^I click on best results dropdown$")
	public void iClickOnBestResultsDropdown() throws Throwable {
		PageFactory.initElements(driver, PackitResultsPage.class);
		CommonMethods.fluentWait(driver, PackitResultsPage.bestResultsDropdown, 2000, 1000);
		//PackitResultsPage.bestResultsDropdown.click();
		CommonMethods.js_Click(PackitResultsPage.bestResultsDropdown);
	}

	@And("^I click on Price ascending order$")
	public void iClickOnPriceAscendingOrder() throws Throwable {
		PageFactory.initElements(driver, PackitResultsPage.class);
//		PackitResultsPage.priceAscendingOption.click();
		CommonMethods.js_Click(PackitResultsPage.priceAscendingOption);
	}

	@Then("^I verify if the results are in price ascending order$")
	public void iVerifyIfTheResultsAreInPriceAscendingOrder() throws Throwable {
		PageFactory.initElements(driver, PackitResultsPage.class);
		FlightResults.verifyFlightResultsSorting(driver, PackitResultsPage.listOfPriceOnEachFare);
	}

    
}
