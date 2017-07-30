
package com.bytebistro.weatherservice;

import com.google.gson.annotations.SerializedName;

public class WeatherObject
{  

    @SerializedName("temp")
    float temp = 0;
    
    @SerializedName("pressure")
    float pressure = 0;
    
    @SerializedName("humidity")
    float humidity = 0;
    
    @SerializedName("temp_min")
    float temp_min = 0;
    
    @SerializedName("temp_max")
    float temp_max = 0;  
      
}
