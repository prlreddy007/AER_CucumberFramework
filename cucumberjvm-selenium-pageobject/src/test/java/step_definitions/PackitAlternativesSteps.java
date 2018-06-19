package step_definitions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DataHelper;
import modules.CommonMethods;
import modules.PackitAlternativesModules;
import modules.PassengerDetailsDisplay;
import pageobjects.PackitAlternatives;
import pageobjects.PackitDetailsPage;

public class PackitAlternativesSteps {
	public WebDriver driver;
    public List<HashMap<String,String>> datamap;
	
	public PackitAlternativesSteps()
	{
		 driver = Hooks.driver;
	    datamap = DataHelper.data();
	}
	
	@Then("^I verify if the alternatives page is displayed$")
	public void iVerifyIfTheAlternativesPageIsDisplayed() throws Throwable {
		PageFactory.initElements(driver, PackitAlternatives.class);
		PackitAlternativesModules.alternativesDisplay(driver);
	}

	@Then("^I proceed from alternatives page$")
	public void iProceedFromAlternativesPage() throws Throwable {
		PageFactory.initElements(driver, PackitAlternatives.class);
		PackitAlternatives.alternativesProceed.click();
	}

	@Then("^I verify the price table calculations$")
	public void iVerifyThePriceTableCalculations() throws Throwable {
		PageFactory.initElements(driver, PackitAlternatives.class);
		CommonMethods.totalVerify(driver, PackitAlternatives.alternativesPriceDetails, PackitAlternatives.alternativesPriceTotals);
	}

	@And("^I click on Show more in alternatives page$")
	public void iClickOnShowMoreInAlternativesPage() throws Throwable {
		PageFactory.initElements(driver, PackitAlternatives.class);
		CommonMethods.waitforelement(PackitAlternatives.alternativesShowMore);
		PackitAlternatives.alternativesShowMore.click();	
	}




}
