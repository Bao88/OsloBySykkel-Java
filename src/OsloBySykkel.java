import java.net.*;
import java.io.*;
import org.json.*;
import java.util.*;

public class OsloBySykkel {

	private static JSONArray requestData(String resource) throws Exception {
		URL url = new URL(resource);
		URLConnection connect = url.openConnection();;
		connect.setRequestProperty("Client-Identifier", "aa57ec526474715c30fdc77f2a7da0c0");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
		JSONArray json = (new JSONObject(in.readLine())).getJSONArray("stations");
		in.close();
		return json;
	}
	
	public static void main(String[] args) throws Exception {
		//System.out.println("Hello World");
		//URL stationsURL = new URL("https://oslobysykkel.no/api/v1/stations");
		//URL availabilityURL = new URL("https://oslobysykkel.no/api/v1/stations/availability");
		
		JSONArray stations = requestData("https://oslobysykkel.no/api/v1/stations");
		JSONArray availability = requestData("https://oslobysykkel.no/api/v1/stations/availability");
		
		System.out.println(stations.getJSONObject(0));
		System.out.println(availability.getJSONObject(0));
		
	}

}
