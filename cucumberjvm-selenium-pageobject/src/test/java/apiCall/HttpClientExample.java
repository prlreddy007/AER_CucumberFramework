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
import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.JsonElement;

import gherkin.JSONParser;
import helpers.Log;
import javassist.expr.Instanceof;
import modules.UserEnterFlightDetails;
import pageobjects.PackitSearchPage;

public class HttpClientExample {

	 public static List<String> errorList = new ArrayList<String>();
	   ExecutorService executor;
	  static  String defaultFareChar;
	public static void getAPI(WebDriver driver) throws ClientProtocolException, IOException, JSONException {
				
		//Request URL:https://aerpackitstage.flightconex.de/redbox/api/{sessionId}/customerRegistry

//		String href= PackitResultsPage.detailFareService.getAttribute("ng-click");
//		System.out.println("detail fare service is:+++++++++++++++++"+href);
		String customRegistry ="https://aerpackitstage.flightconex.de/redbox/api/"+UserEnterFlightDetails.getSession(driver)+"/customerRegistry";
        
		System.out.println("CR service is:+++++++++++++++++"+customRegistry);
		//HttpClient client = new DefaultHttpClient();
		HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(customRegistry);

     // add request header
       // request.setHeader("sessionId",UserEnterFlightDetails.getSession(driver));
        HttpResponse response = client.execute(request);

        
        System.out.println("response os+++++++++++"+response);
        System.out.println("Response Code : "
                        + response.getStatusLine().getStatusCode());
        
        //System.out.println(response.get("agencyID"));

        BufferedReader rd = new BufferedReader(
        	new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
        	result.append(line);
        }
        
       // System.out.println(result.get("agencyID"));
        System.out.println("reponse is +++++++++:/n"+result);
        
        System.out.println("reponse is +++++++++:/n"+result.toString());
        
       
       
        JSONObject jsonObj = new JSONObject(result.toString());
        //in Customer registry service response we get an object named customerRegistry
        JSONObject cRegistry=jsonObj.getJSONObject("customerRegistry");
        
//        System.out.println("json object response is :++++++++"+jsonObj);
//        
//        System.out.println("Agent id is:+++++++++++++ "+jsonObj.get("agencyID"));
//        System.out.println("weblogid is:+++++++++++++ "+jsonObj.get("webServiceLogID"));
//        System.out.println("conso id is:+++++++++++++ "+cRegistry.getString("consoID"));
        System.out.println("_______++++++++++++Json Parser verification++++________________");
        System.out.println("email address is by new parser method:+++++++++++++ "+jsonParser(cRegistry.getJSONObject("agencyAddress").getJSONObject("emailAddress"),"/value"));
        System.out.println("Level2 Array parsing:+++++++++++++ "+jsonParser(jsonObj,"/customerRegistry/defaultPassengerTypeCount/1/type"));
        System.out.println("Level3 Array parsing:+++++++++++++ "+jsonParser(cRegistry,"/defaultPassengerTypeCount/2/type"));
        
//        Log.log.info("email address is by new parser method:+++++++++++++ "+PackitFlowAPI.jsonParser(cRegistry.getJSONObject("agencyAddress").getJSONObject("emailAddress"),"/value"));
//        Log.log.info("email address is by new parser method2:+++++++++++++ "+PackitFlowAPI.jsonParser(cRegistry,"/agencyAddress/emailAddress/value"));
        
        try {
        JSONObject airlineblacked=cRegistry.getJSONArray("airlineBlackList").getJSONObject(0);
       // JSONArray data = jsonObj.getJSONArray("airlineBlackList");
        System.out.println("airline code blacked list is:+++++++++++++ "+airlineblacked.getString("code"));
        }
        catch(Exception e) {
        	System.out.println("No airlineBlackList object is found");
        }
        
        try {
        	
        	JSONObject defaultFareCharacteristic=cRegistry.getJSONArray("defaultFareCharacteristics").getJSONObject(0);
        	System.out.println("defaultFareCharacteristics is +++++++++:"+defaultFareCharacteristic);
            defaultFareChar=defaultFareCharacteristic.toString();
        }
        catch(Exception exception) {
        	
        }
       
        
        
//        JSONObject airlineWhite=cRegistry.getJSONArray("airlineWhiteList").getJSONObject(0);
//        System.out.println("Airline code whitelist is:+++++++++++++ "+airlineWhite.getString("name"));
        
        
       // System.out.println("airline code id is:+++++++++++++ "+airlineblacked.getString("code"));
        
        
      //  System.out.println("Agent id is:+++++++++++++ "+data.getString(8)+"   "+data.getString(9));
//        JSONObject myObject = new JSONObject(result);
     // First get the JsonPath object instance from the Response interface
    	//JSONParser jsonPathEvaluator = response.getEntity();
     
    	// Then simply query the JsonPath object to get a String value of the node
    	// specified by JsonPath: City (Note: You should not put $. in the Java code)
    	//String city = jsonPathEvaluator.get("City");
        
        
//        HttpResponse response = null;
//        try {
//            response = client.execute(request);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        int code = response.getStatusLine().getStatusCode();
//
//        if(code!=200)
//            errorList.add(customerRegistry);
//		
	}
	
	 public static String jsonParser(JSONObject jsonObjectToParse, String requiredKeyName)
	    {
	     Object obj=jsonObjectToParse;
	     for(String s: requiredKeyName.split("/"))
	      if(!s.isEmpty())
	       if(!(s.contains("[")) || s.contains("]"))
	    	   if(obj instanceof JSONObject)
                   obj=  ((JSONObject) obj).get(s);
                   else 
                   obj=(Object)((JSONArray) obj).getJSONObject(Integer.parseInt(s));
                   // obj =((JSONArray)((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]","")));
	     System.out.println("print raw object"+obj);
	     return obj.toString();
	  
	    }
	public static void verifyDefaultFareCharacteristics(WebDriver driver) {
		if(defaultFareChar=="WEB") {
		boolean isLowSelected=PackitSearchPage.lowCheckBox.isSelected();
		if(isLowSelected==true)
		{
         Assert.assertTrue("LOW checkbox is selected", true);
         Reporter.log("LOW checkbox is selected");
         }
		else
		{
		Assert.assertTrue("LOW checkbox is not selected", false);
		Reporter.log("LOW checkbox is selected");
		}
		}
		
	}
	
	
}

