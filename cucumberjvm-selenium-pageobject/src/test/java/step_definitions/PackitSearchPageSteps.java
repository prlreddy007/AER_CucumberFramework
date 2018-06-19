package step_definitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import apiCall.GetCalculation;
import apiCall.HttpClientExample;
import apiCall.HttpPostExample;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DataHelper;
import helpers.Log;
import modules.SignInAction;
import modules.UserEnterFlightDetails;
import pageobjects.LoginPage;
import pageobjects.PackitSearchPage;

public class PackitSearchPageSteps {

	public WebDriver driver;
    public List<HashMap<String,String>> datamap;
    public org.apache.log4j.Logger log;
//    private static Logger Log;
    

 
	
    public PackitSearchPageSteps() {
    	log= org.apache.log4j.Logger.getLogger(PackitSearchPageSteps.class.getName());
//    	DOMConfigurator.configure("log4j.xml");
    	PropertyConfigurator.configure("Log4j.properties");
    	driver = Hooks.driver;
        datamap = DataHelper.data();
      
    }
    
    @When("^I open packit website$")
    public void i_open_packit_website() throws Throwable {
    	//System.out.println("driver is "+ driver);
   // 	log=org.apache.log4j.Logger.getLogger("devpinoyLogger");
    	driver.get("https://packit-qa.aerticket-it.de/");
    	Log.log.info("Site Is Opened");
    }
    
    @Then("^I verify signin$")
	public void iVerifySignin() throws Throwable {
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, PackitSearchPage.class);
		SignInAction.Execute(driver, datamap);
//    	log.info("SignIn verified");

	}

    
    
	@Given("^I verify the customer registry service response$")
	public void iVerifyTheCustomerRegistryServiceResponse() throws Throwable {
		PageFactory.initElements(driver, PackitSearchPage.class);
    	UserEnterFlightDetails.getSession(driver);
		try {
			HttpClientExample.getAPI(driver);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			HttpPostExample.postAPI(driver);
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Then("^I verify if the LOW checkbox is selected$")
	public void iVerifyIfTheLOWCheckboxIsSelected() throws Throwable {
		PageFactory.initElements(driver, PackitSearchPage.class);
		HttpClientExample.verifyDefaultFareCharacteristics(driver);
	}

	@Given("^I verify calculation get response$")
	public void iVerifyCalculationGetResponse() throws Throwable {
		PageFactory.initElements(driver, PackitSearchPage.class);
		GetCalculation.getCalculationAPI(driver);
		
	}

	@And("^I verify if calculation info popup is displaying$")
	public void iVerifyIfCalculationInfoPopupIsDisplaying() throws Throwable {
		PageFactory.initElements(driver, PackitSearchPage.class);
		GetCalculation.verifyClaculationInfoPopup();	
	}

	@Then("^I change the language to engish$")
	public void iChangeTheLanguageToEngish() throws Throwable {
		UserEnterFlightDetails.changeLanguage(driver);
	}

	
	
}
