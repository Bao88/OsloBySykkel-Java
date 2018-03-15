import java.net.*;
import java.awt.Dimension;
import java.io.*;
import org.json.*;
import java.util.*;
import javax.swing.*;   

public class OsloBySykkel {

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Oslo Bysykkel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setPreferredSize(new Dimension(400, 300));
		
		
		JLabel label = new JLabel("Hello World");
		frame.getContentPane().add(label);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
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
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

}
