
package com.bytebistro.weatherservice;

import com.google.gson.annotations.SerializedName;

public class WeatherData 
{  
    public Weather []weather;
    public MainObject main;
    public WeatherSystem sys;
    
    @SerializedName("name")
    String name = "";
    
    
    //Not working yet due to JSON formatting
    //public Weather_Weather weather;
    
}