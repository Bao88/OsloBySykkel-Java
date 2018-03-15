import java.net.*;
import java.io.*;

public class OsloBySykkel {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Hello World");
		URL stations = new URL("https://oslobysykkel.no/api/v1/stations");
		URL availabity = new URL("https://oslobysykkel.no/api/v1/stations/availability");
		
		URLConnection cStations = stations.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(cStations.getInputStream()));
		String inputLine;
		while((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		in.close();
		
	}

}
