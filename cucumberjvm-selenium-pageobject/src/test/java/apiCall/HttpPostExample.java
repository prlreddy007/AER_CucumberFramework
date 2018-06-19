package apiCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import modules.UserEnterFlightDetails;

public class HttpPostExample {

	 public static List<String> errorList = new ArrayList<String>();
	   ExecutorService executor;
	public static String postAPI(WebDriver driver) throws ClientProtocolException, IOException, JSONException {
		//Reference: https://stackoverflow.com/questions/15570656/how-to-send-request-payload-to-rest-api-in-java
		//Reference: 
		String faresearchid = null;		
		String availablefare ="https://aerpackitstage.flightconex.de/redbox/api/"+UserEnterFlightDetails.getSession(driver)+"/availableFare";
		String payload="{\"segmentList\":[{\"departureRadius\":{\"value\":0,\"unit\":\"KM\"},\"destinationRadius\":{\"value\":0,\"unit\":\"KM\"},\"departureDate\":\"2018-09-09\",\"departureTime\":null,\"via\":null,\"dayIntervalPlus\":\"0\",\"dayIntervalMinus\":\"0\",\"departure\":{\"code\":\"FRA\"},\"destination\":{\"code\":\"JFK\"}},{\"departureRadius\":{\"value\":0,\"unit\":\"KM\"},\"destinationRadius\":{\"value\":0,\"unit\":\"KM\"},\"departureDate\":\"2018-09-19\",\"departureTime\":null,\"via\":null,\"dayIntervalPlus\":\"0\",\"dayIntervalMinus\":\"0\",\"departure\":{\"code\":\"JFK\"},\"destination\":{\"code\":\"FRA\"}}],\"passengerTypeCountList\":[{\"type\":\"ADT\",\"count\":1}],\"cabinClassListMandatoryAllSegments\":false,\"airlineIncludedList\":[],\"airlineAlliance\":null,\"bookingClassIncludedList\":[],\"fareCharacteristicList\":[\"WEB\"],\"nonStopFlightsOnly\":false,\"railAndFlySearch\":false,\"cabinClassList\":[]}";
       
    		  URL url = new URL(availablefare);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      connection.setDoInput(true);
      connection.setDoOutput(true);
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Accept", "application/json");
      connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
      writer.write(payload);
      writer.close();
      
//      System.out.println("response os+++++++++++"+response);
//      System.out.println("Response Code : "
//                      + response.getStatusLine().getStatusCode());
      
      //System.out.println(response.get("agencyID"));

      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuffer result = new StringBuffer();
      String line;
      while ((line = br.readLine()) != null) {
    	  result.append(line);
      }
      br.close();
      connection.disconnect();
      
     // System.out.println(result.get("agencyID"));
      System.out.println("reponse is +++++++++:/n"+result);
      
      System.out.println("reponse is +++++++++:/n"+result.toString());

      JSONObject jsonObj = new JSONObject(result.toString());

      
      System.out.println("json object response is :++++++++"+jsonObj);
      
      System.out.println("fareSearchId is:+++++++++++++ "+jsonObj.get("fareSearchId"));
      System.out.println("weblogid is:+++++++++++++ "+jsonObj.get("webServiceLogID"));
     
      faresearchid = (String) jsonObj.get("fareSearchId");
      return faresearchid;
      
	}
	
	
	
	
	
}

