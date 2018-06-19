package apiCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.eclipse.jetty.websocket.common.io.payload.PayloadProcessor;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import helpers.Log;
import modules.UserEnterFlightDetails;
import pageobjects.PackitSearchPage;
import step_definitions.Hooks;

public class PackitFlowAPI {

	
	 ExecutorService executor;
	   public static WebDriver driver;
	   public PackitFlowAPI() 
	   {
		   driver=Hooks.driver;
	   }
	   static String apiEnvironment = "https://aerpackitstage.flightconex.de/redbox/api/";
	   
	   //Global variables
	   static  String calculationoptionIs;
	   static double flatFee;
	   static String sessionId= UserEnterFlightDetails.getSession(driver);
	   static String faresearchId;
	   static String fareId="";
	   static String shoppingCartId="";
	  //Post request 
	   
	   static String payloadOfAvailableFare="{\"segmentList\":[{\"departureRadius\":{\"value\":0,\"unit\":\"KM\"},\"destinationRadius\":{\"value\":0,\"unit\":\"KM\"},\"departureDate\":\"2018-09-09\",\"departureTime\":null,\"via\":null,\"dayIntervalPlus\":\"0\",\"dayIntervalMinus\":\"0\",\"departure\":{\"code\":\"FRA\"},\"destination\":{\"code\":\"JFK\"}},{\"departureRadius\":{\"value\":0,\"unit\":\"KM\"},\"destinationRadius\":{\"value\":0,\"unit\":\"KM\"},\"departureDate\":\"2018-09-19\",\"departureTime\":null,\"via\":null,\"dayIntervalPlus\":\"0\",\"dayIntervalMinus\":\"0\",\"departure\":{\"code\":\"JFK\"},\"destination\":{\"code\":\"FRA\"}}],\"passengerTypeCountList\":[{\"type\":\"ADT\",\"count\":1}],\"cabinClassListMandatoryAllSegments\":false,\"airlineIncludedList\":[],\"airlineAlliance\":null,\"bookingClassIncludedList\":[],\"fareCharacteristicList\":[\"WEB\"],\"nonStopFlightsOnly\":false,\"railAndFlySearch\":false,\"cabinClassList\":[]}";
       
	  //API URLs 
	   
	   static String customerRegistry = apiEnvironment + sessionId + "/customerRegistry";
	   static String calculation = apiEnvironment + sessionId + "/configuration/calculation";
	   static String availableFare = apiEnvironment + sessionId + "/availableFare";
	   static String availableFare_faresearchId = apiEnvironment + sessionId + "/availableFare"+faresearchId;
	   static String detailFare = apiEnvironment + sessionId + "/availableFare"+ faresearchId +"/detail?fareIds=" + fareId;
	   static String addAndCheckOut = apiEnvironment + sessionId + "/shoppingCart/addAndCheckOut";
	   static String itemsDetail = apiEnvironment + sessionId + "/shoppingCart/"+ shoppingCartId+"/items/detail";
	   
	   
	   public static StringBuffer getAPI(String nameOfTheAPIService) throws Throwable, IOException 
	   {
	           HttpClient client=HttpClientBuilder.create().build();
	           HttpGet request= new HttpGet(nameOfTheAPIService);
	           HttpResponse response=client.execute(request);
	           
	           System.out.println("response os+++++++++++"+response);
	           System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
	           
	           BufferedReader rd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	           StringBuffer result=new StringBuffer();
	           String line="";
	           while ((line = rd.readLine()) != null) 
	           {
	           	result.append(line);
	           }   
	           
	           return result;
		  
	   }
	   
	   
	   public static StringBuffer postAPI(String nameOfTheAPIService, String postRequest) throws ClientProtocolException, IOException, JSONException {

			//String faresearchid = null;		
			
	      URL url = new URL(nameOfTheAPIService);
	      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	      connection.setDoInput(true);
	      connection.setDoOutput(true);
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Accept", "application/json");
	      connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	      OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
	      writer.write(postRequest);
	      writer.close();

	      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	      StringBuffer result = new StringBuffer();
	      String line;
	      while ((line = br.readLine()) != null) {
	    	  result.append(line);
	      }
	      br.close();
	      connection.disconnect();
	      return result;
		}
	   
	   
	   public static void getCalculation(WebDriver driver) throws IOException, Throwable 
	   {
		   
		   StringBuffer result=getAPI(calculation);
		   System.out.println("reponse is +++++++++:/n"+result);    
		      System.out.println("reponse is +++++++++:/n"+result.toString());
		      JSONObject jsonObj = new JSONObject(result.toString());
		      
		      //in Customer registry service response we get an object named customerRegistry
		      JSONObject agentcalculation=jsonObj.getJSONObject("agentCalculation");
		      
		      System.out.println("json object response is :++++++++"+jsonObj);  
		      System.out.println("weblogid is:+++++++++++++ "+jsonObj.get("webServiceLogID"));
		      System.out.println(agentcalculation.getDouble("flatFee"));
		      
		      Log.log.info("json object response of calculation service is :++++++++"+jsonObj);
		      Log.log.info("weblogid if calculation service is:+++++++++++++ "+jsonObj.get("webServiceLogID"));
		      Log.log.info("flat fee is:   "+agentcalculation.getDouble("flatFee"));
		      try {
		    	 
		    	  calculationoptionIs= agentcalculation.getString("calculationOption").toString();
		    	  flatFee=agentcalculation.getDouble("flatFee");
		    	  System.out.println("Calculation option is++++:"+calculationoptionIs+"\n Flat fee is:+++++++++++++ "+flatFee);
		    	  Log.log.info("Calculation option is++++:"+calculationoptionIs+"\n Flat fee is:+++++++++++++ "+flatFee);
		    	  
		      }
		      catch(Exception e) {
		      	System.out.println("No flat fee is available");
		      	Log.log.info("No flat fee is available");
		      }

	   }
	   
	 
	   public static void verifyClaculationInfoPopup() 
	   {
				try
				{
					boolean isCalculationOKButtonDisplayed= PackitSearchPage.calculationInfoPopup_OK_Button.isDisplayed();
					System.out.println("isCalculationOKButtonDisplayed++++++++"+isCalculationOKButtonDisplayed);
					
					 if(isCalculationOKButtonDisplayed==true) 
					 {
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
				}
					catch(NoSuchElementException e)
					{
						System.out.println("calculationInfoPopup_OK_Button is not available");
					}
		}
	   
	   public static void getCustomerRegistry(WebDriver driver) throws IOException, Throwable
	   {
		   StringBuffer result=getAPI(customerRegistry);
           
		   System.out.println("reponse is +++++++++:/n"+result);
           System.out.println("reponse is +++++++++:/n"+result.toString());
           //Need to add json jar file to instantiate JSONobject
           JSONObject  jsonObj = new JSONObject(result.toString());
           JSONObject cRegistry=jsonObj.getJSONObject("customerRegistry");
           JSONObject airlineblacked=cRegistry.getJSONArray("airlineBlackList").getJSONObject(0);
          // JSONArray data = jsonObj.getJSONArray("airlineBlackList");
   
           System.out.println("json object response is :++++++++"+jsonObj);
           
           System.out.println("Agent id is:+++++++++++++ "+jsonObj.get("agencyID"));
           System.out.println("weblogid is:+++++++++++++ "+jsonObj.get("webServiceLogID"));
           System.out.println("conso id is:+++++++++++++ "+cRegistry.getString("consoID"));
           System.out.println("airline code blacked list is:+++++++++++++ "+airlineblacked.getString("code"));
           
           JSONObject airlineWhite=cRegistry.getJSONArray("airlineWhiteList").getJSONObject(0);
           System.out.println("Airline code whitelist is:+++++++++++++ "+airlineWhite.getString("name"));
		   
	   }

	   public static void postAvailableFare(WebDriver driver) throws ClientProtocolException, JSONException, IOException 
	   {
		   StringBuffer result=postAPI(availableFare,payloadOfAvailableFare);
		   
		   System.out.println("reponse is +++++++++:/n"+result);
		      
		      System.out.println("reponse is +++++++++:/n"+result.toString());

		      JSONObject jsonObj = new JSONObject(result.toString());

		      System.out.println("json object response is :++++++++"+jsonObj);
		      
		      System.out.println("fareSearchId is:+++++++++++++ "+jsonObj.get("fareSearchId"));
		      System.out.println("weblogid is:+++++++++++++ "+jsonObj.get("webServiceLogID"));
		     
		      faresearchId = (String) jsonObj.get("fareSearchId");
		      
	   }
	   
	   
}
