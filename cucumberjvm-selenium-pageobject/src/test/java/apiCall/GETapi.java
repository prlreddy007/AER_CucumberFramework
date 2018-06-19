package apiCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.ClosedByInterruptException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import modules.UserEnterFlightDetails;
import step_definitions.Hooks;

public class GETapi {
	 public static List<String> errorList = new ArrayList<String>();
	   ExecutorService executor;
	   public static WebDriver driver;
	   public GETapi() {
		   driver = Hooks.driver;
	   }
	   static String apiEnvironment = "https://aerpackitstage.flightconex.de/redbox/api/";
	   static String sessionId= UserEnterFlightDetails.getSession(driver);
	   static String faresearchId="";
	   static String fareId="";
	   static String shoppingCartId="";
	   static String customRegistry = apiEnvironment + sessionId + "/customerRegistry";
	   static String calculation = apiEnvironment + sessionId + "/configuration/calculation";
	   static String availableFare = apiEnvironment + sessionId + "/availableFare";
	   static String availableFare_faresearchId = apiEnvironment + sessionId + "/availableFare"+faresearchId;
	   static String detailFare = apiEnvironment + sessionId + "/availableFare"+ faresearchId +"/detail?fareIds=" + fareId;
	   static String addAndCheckOut = apiEnvironment + sessionId + "/shoppingCart/addAndCheckOut";
	   static String itemsDetail = apiEnvironment + sessionId + "/shoppingCart/"+ shoppingCartId+"/items/detail";
	   
	   // https://aerpackitstage.flightconex.de/redbox/api/8592ev0r951hj7mj1n2p36ungv/availableFare/398/detail?fareIds=J253460496p_ROUNDTRIP_0
	   
	   
	   public static void getService(WebDriver driver) throws Throwable, IOException {
		   String customRegistry ="https://aerpackitstage.flightconex.de/redbox/api/"+UserEnterFlightDetails.getSession(driver)+"/availableFare";
           HttpClient client=HttpClientBuilder.create().build();
           HttpGet request= new HttpGet(customRegistry);
           HttpResponse response=client.execute(request);
           
           System.out.println("response os+++++++++++"+response);
           System.out.println("Response Code : "
                           + response.getStatusLine().getStatusCode());
           
           BufferedReader rd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
           StringBuffer result=new StringBuffer();
           String line="";
           while ((line = rd.readLine()) != null) {
           	result.append(line);
           }
           
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

	   
	   
}
