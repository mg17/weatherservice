package com.bytebistro.weatherservice;

// Classes for reading web service.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

// Classes for JSON conversion to java objects using Google's gson.
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Scanner;


public class WeatherServiceManager
{ 
    private WeatherData weatherData = null;
    private String m_sWeatherJson;
    
    /**
     * Gets the overall weather JSON string from the 3rd party wev service.
     * @param sCity 
     */
    public void callWeatherWebService(String sCity){

    	String sServiceReturnJson = "";

    	try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" +
                    sCity + "&appid=1868f2463a960613c0a78b66a99b5e5f&units=imperial");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                    sServiceReturnJson += strTemp;
            }
            


        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("An error occurred in callWeatherWebService() "
                    + "in WeatherServiceManager: " + ex.toString());
        }

        m_sWeatherJson = sServiceReturnJson;

        // Turn raw json into java object heirarchy using Google's gson.
        convertJsonToJavaObject();
    }

	// Uses Google's gson library to convert json into filled java objects
	// using the java object heirarchy that you already created.
    private void convertJsonToJavaObject(){

        Gson gson = new GsonBuilder().create();
        
        weatherData = gson.fromJson(m_sWeatherJson, WeatherData.class);
        

    }
    
    public String getGsonOutput() {
        
        return weatherData.toString();
    }
    
    public String getJsonOutput() {
        
        return m_sWeatherJson;
    }
    
    // This uses Google's gson library for parsing json.
    public float getCurrentTemp(){

        return weatherData.main.temp;
    }
    
    // getCityName Method
    public String getCityName() {
        
       return weatherData.name; 
    }
    
    
    // getHighTemp method
    public float getHighTemp() {
        
        return weatherData.main.temp_max;
    }
    
    // getLowTemp method
    public float getLowTemp() {
        
        return weatherData.main.temp_min;
    }
    
    public long getSunriseTime() {
        
        return weatherData.sys.sunrise;
    }
    
    public long getSunsetTime() {
        
        return weatherData.sys.sunset;
    }
    
     public String getDescription() {
        
        return weatherData.weather[0].description;
    }
    
    /*
    // This does not work yet due to JSON formatting [{ instead of the expected {
    public String getWeatherDesc() {
        
        return weatherData.weather;
    }*/
    
    public String getCountry() {
        
        return weatherData.sys.country;
    }

 


	// -------------------------------------------------------------------

    // ***********************************
	// Only included here just as an example of how the raw json
	// could be parsed directly w/o using 3rd party library like gson.
	public float getTempManualParse(){

		String sTemp = "";
		float fTemp;

		// Parse "temp" out of JSON reply.
		int iTempIndex = m_sWeatherJson.indexOf("\"temp\":") + 7;
		sTemp = m_sWeatherJson.substring(iTempIndex);
		sTemp = sTemp.substring(0, sTemp.indexOf(","));
		fTemp = Float.parseFloat(sTemp);

		return fTemp;
	}
    

}
