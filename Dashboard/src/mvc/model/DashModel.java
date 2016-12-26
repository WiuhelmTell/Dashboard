package mvc.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class DashModel {
	
	Sensor aussen = new Sensor("5d0e7880-88af-11e6-aac3-63d396f572c9");
	Sensor wohnzimmer = new Sensor("cabffab0-88a4-11e6-ac58-ebf10a5a3cb2");

	
	public DashModel(){
		
		
		
	}


	/**
	 * Gets the temperature from VZ.
	 *
	 * @return the temperature from VZ
	 * @throws MalformedURLException the malformed URL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException the JSON exception
	 */
	public void getActualTemperatureFromVZ() {

		
		makeString(aussen);
		connecttoVZ(aussen);
		

			// Verbindung aufbauen und Werte als JSON auslesen


			String Response;
			try (Scanner scanner = new Scanner(response)) {
				String responseBody = scanner.useDelimiter("\\A").next();
				Response = responseBody;
			}

			JSONObject json = new JSONObject(Response);
			/*
			for (int t = 0; t < jsonarray.length(); t++) {
			    JSONObject jsonobject = jsonarray.getJSONObject(t);
			    Double name = jsonobject.getDouble("tuples");
			}
			*/
			JSONArray jsonarray = json.getJSONObject("data").getJSONArray("tuples");
			System.out.println(jsonarray);
			Double[] Temps = new Double[jsonarray.length()];
			
			Temps[1] = 12.0;
			System.out.println(Temps);
			
			//System.out.println(jsonarray.length());
			for (int i1 = 0; i1 <= jsonarray.length(); i1++) {
				//Temps[i1] = jsonarray.get(i1)[2];
			 System.out.println(jsonarray.get(i1));
			
		
			
			
			
			
			/*
			for (int k = 0; k < tuples; k++) {
				temperatures[i][k] = json.getJSONObject("data").getJSONArray("tuple");
			}
			
*/

			
			
			
			
		}

		
		}
	
	private void makeString(Sensor sensor){
		String charset = java.nio.charset.StandardCharsets.UTF_8.name();
		;
		try {
			query = String.format("from=%s&tuples=%s", URLEncoder.encode(sensor.from, charset),
					URLEncoder.encode(Integer.toString(sensor.tuples), charset));
		} catch (UnsupportedEncodingException e2) {
			query = "";
			e2.printStackTrace();
		}

	}
	
	private void connecttoVZ(Sensor sensor){
		
		URLConnection connection = new URL(sensor.url + "?" + String query).openConnection();
		connection.setRequestProperty("Accept-Charset", charset);
		InputStream response = connection.getInputStream();
	}




}

class Sensor {
	
	String uuid;
	Double actualTemperature; 
	String from = "last day";
	Integer tuples = 48;
	String url = "http://vz.wiuhelmtell.ch/middleware.php/data/"+uuid+".json";


	
	public Sensor(String uuid){
		this.uuid = uuid;
		
	}


}
