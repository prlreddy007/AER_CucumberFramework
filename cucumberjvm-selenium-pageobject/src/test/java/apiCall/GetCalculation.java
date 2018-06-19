package apiCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import modules.CommonMethods;
import modules.UserEnterFlightDetails;
import pageobjects.PackitSearchPage;

public class GetCalculation {

	 public static List<String> errorList = new ArrayList<String>();
	   ExecutorService executor;
	  static  String calculationoptionIs;
	  static double flatFee;
	 
	 
	public static void getCalculationAPI(WebDriver driver) throws ClientProtocolException, IOException, JSONException {
				
		//Request URL:https://aerpackitstage.flightconex.de/redbox/api/{sessionId}/customerRegistry

//		String href= PackitResultsPage.detailFareService.getAttribute("ng-click");
//		System.out.println("detail fare service is:+++++++++++++++++"+href);
		String calculationAPI_GET ="https://aerpackitstage.flightconex.de/redbox/api/"+UserEnterFlightDetails.getSession(driver)+"/configuration/calculation";
      
		System.out.println("CR service is:+++++++++++++++++"+calculationAPI_GET);
		HttpClient client = HttpClientBuilder.create().build();
      HttpGet request = new HttpGet(calculationAPI_GET);

   // add request header
     // request.setHeader("sessionId",UserEnterFlightDetails.getSession(driver));
      HttpResponse response = client.execute(request);

      
      System.out.println("response os+++++++++++"+response);
      System.out.println("Response Code : "+ response.getStatusLine().getStatusCode());
      
      BufferedReader rd = new BufferedReader(
      	new InputStreamReader(response.getEntity().getContent()));

      StringBuffer result = new StringBuffer();
      String line = "";
      while ((line = rd.readLine()) != null) {
      	result.append(line);
      }
      
     
      System.out.println("reponse is +++++++++:/n"+result);    
      System.out.println("reponse is +++++++++:/n"+result.toString());
      JSONObject jsonObj = new JSONObject(result.toString());
      
      //in Customer registry service response we get an object named customerRegistry
      JSONObject agentcalculation=jsonObj.getJSONObject("agentCalculation");
      
      System.out.println("json object response is :++++++++"+jsonObj);  
      System.out.println("weblogid is:+++++++++++++ "+jsonObj.get("webServiceLogID"));
    
      System.out.println(agentcalculation.getDouble("flatFee"));
     
      
      
      try {
    	 
    	  calculationoptionIs= agentcalculation.getString("calculationOption").toString();
    	  flatFee=agentcalculation.getDouble("flatFee");
    	  System.out.println("Calculation option is++++:"+calculationoptionIs+"\n Flat fee is:+++++++++++++ "+flatFee);
      }
      catch(Exception e) {
      	System.out.println("No flat fee is available");
      }
	}
	
	public static void verifyClaculationInfoPopup() {
		try
		{
		boolean isCalculationOKButtonDisplayed= PackitSearchPage.calculationInfoPopup_OK_Button.isDisplayed();
		System.out.println("isCalculationOKButtonDisplayed++++++++"+isCalculationOKButtonDisplayed);
		
		 if(isCalculationOKButtonDisplayed==true) {
			 PackitSearchPage.calculationInfoPopup_OK_Button.click();
				 if(flatFee == 30.0){
					 if(calculationoptionIs == "FLAT") {
					System.out.println("Calculation info popup is displaying");
					 Assert.assertTrue("Calculation info popup is displaying", true);
			         Reporter.log("Calculation info popup is displaying");
					 }
					 else 
					 {
					  System.out.println("Calculation info popup is displaying though claculation option is: "+calculationoptionIs);
					 }
				 }
				 else
				 {
					 Assert.assertTrue("Calculation info popup is displaying though claculation option is: "+calculationoptionIs, false);
			         Reporter.log("Calculation info popup is displaying  though claculation option is: "+calculationoptionIs);
					}
			 }
		}catch(NoSuchElementException e) {
			System.out.println("calculationInfoPopup_OK_Button is not available");
		}
			 
//		if(calculationoptionIs=="FLAT" && flatFee==30.0) 
//		{
//			CommonMethods.waitforelement( PackitSearchPage.calculationInfoPopup_OK_Button);
//	           if(isCalculationOKButtonDisplayed==true) 
//				{    
//	        	     PackitSearchPage.calculationInfoPopup_OK_Button.click();
//					 Assert.assertTrue("Calculation info popup is displaying", true);
//			         Reporter.log("Calculation info popup is displaying");
//			        
//		        }
//			     else
//				{
//					Assert.assertTrue("Calculation info popup is missing though claculation option is: "+calculationoptionIs+"and the flat fee is:"+flatFee, false);
//					Reporter.log("Calculation info popup is missing though claculation option is: "+calculationoptionIs+"and the flat fee is:"+flatFee);
//				}
//		}
//		else
//		{
//			 if(isCalculationOKButtonDisplayed==true) 
//			 {   
//				 PackitSearchPage.calculationInfoPopup_OK_Button.click();
//				 Assert.assertTrue("Calculation info popup is displaying though claculation option is: "+calculationoptionIs, false);
//		         Reporter.log("Calculation info popup is displaying  though claculation option is: "+calculationoptionIs);
//		        
//		        }
//			     else
//				{
//				Assert.assertTrue("Calculation won't be displayed if the claculation option is: "+calculationoptionIs, true);
//				Reporter.log("Calculation won't be displayed if the claculation option is: "+calculationoptionIs);
//				}
//			
//		     }
	}
	
	
}
