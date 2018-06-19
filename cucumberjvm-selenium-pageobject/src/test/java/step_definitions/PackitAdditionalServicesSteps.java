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
import pageobjects.PackitAdditionalServices;

public class PackitAdditionalServicesSteps {
	public WebDriver driver;
    public List<HashMap<String,String>> datamap;

     public PackitAdditionalServicesSteps() {
		// TODO Auto-generated constructor stub
    	driver = Hooks.driver;
        datamap = DataHelper.data();
	}
	
     @Then("^I should get the additional services page$")
 	public void iShouldGetTheAdditionalServicesPage() throws Throwable {
 		PageFactory.initElements(driver, PackitAdditionalServices.class);
 		PackitAdditionalServicesModules.additionalservicesVerify(driver);	
 	}
     
     
	@Given("^I verify if ZZF is available$")
	public void iVerifyIfZZFIsAvailable() throws Throwable {
		PageFactory.initElements(driver, PackitAdditionalServices.class);
		Log.log.info("ZZf additional service verification");
		PackitAdditionalServicesModules.verifyAdditionalServiceAvailability(driver,PackitAdditionalServices.zzfOpenButton);
	}

	@When("^I select ZZF$")
	public void iSelectZZF() throws Throwable {
		PageFactory.initElements(driver, PackitAdditionalServices.class);
		PackitAdditionalServicesModules.selectZZF(driver);
	
	}

	@Then("^I verify greencheck$")
	public void iVerifyGreencheck() throws Throwable {
		PageFactory.initElements(driver, PackitAdditionalServices.class);
		PackitAdditionalServicesModules.verifyGreenCheck(driver, PackitAdditionalServices.zzfGreenCheck);
	}

	
	@And("^I verify if the seats box is enabled$")
	public void iVerifyIfTheSeatsBoxIsEnabled() throws Throwable {
		PageFactory.initElements(driver, PackitAdditionalServices.class);
		Log.log.info("Seats additional service verification");
		PackitAdditionalServicesModules.verifyAdditionalServiceAvailability(driver,PackitAdditionalServices.SeatsOpenButton);
	}

	@And("^I open the seats box$")
	public void iOpenTheSeatsBox() throws Throwable {
		PageFactory.initElements(driver, PackitAdditionalServices.class);
		PackitAdditionalServices.SeatsOpenButton.click();
	}

//	@And("^I select if any seats available$")
//	public void iSelectIfAnySeatsAvailable() throws Throwable {
//		PageFactory.initElements(driver, PackitAdditionalServices.class);
//		PackitAdditionalServicesModules.selectSeats(driver, PackitAdditionalServices.seatsList);
//	}

	@And("^I click on Proceed$")
	public void iClickOnProceed() throws Throwable {
		PageFactory.initElements(driver, PackitAdditionalServices.class);
		CommonMethods.fluentWait(driver, PackitAdditionalServices.seatsSubmitButton, 3000, 1000);
		PackitAdditionalServices.seatsSubmitButton.click();
//		CommonMethods.js_Click(PackitAdditionalServices.seatsSubmitButton);
	}

	@Then("^I verify if green check is displayed in seats tile$")
	public void iVerifyIfGreenCheckIsDisplayedInSeatsTile() throws Throwable {
		PageFactory.initElements(driver, PackitAdditionalServices.class);
		PackitAdditionalServicesModules.verifyGreenCheck(driver, PackitAdditionalServices.seatsGreenCheck);
	}

	@Given("^I verify if additional services page is displayed$")
	public void iVerifyIfAdditionalServicesPageIsDisplayed() throws Throwable {
		PageFactory.initElements(driver, PackitAdditionalServices.class);
 		PackitAdditionalServicesModules.additionalservicesVerify(driver);
	}

//	@And("^I verify if seats addition is possible$")
//	public void iVerifyIfSeatsAdditionIsPossible() throws Throwable {
//		PageFactory.initElements(driver, PackitAdditionalServices.class);
// 		PackitAdditionalServicesModules.isSeatSelectionPossible(driver, PackitAdditionalServices.seatsList);
//	}

	@And("^I verify and add seats if possible$")
	public void iVerifyAndAddSeatsIfPossible() throws Throwable {
		PageFactory.initElements(driver, PackitAdditionalServices.class);
 		PackitAdditionalServicesModules.verifyAndSelectSeat(driver, PackitAdditionalServices.seatsList);
	}



	
}
