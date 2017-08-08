/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytebistro.weatherservice.model;

import com.google.gson.annotations.SerializedName;

public class WeatherSystem
{  

    @SerializedName("type")
    int type = 0;
    
    @SerializedName("id")
    int id = 0;
    
    @SerializedName("message")
    float message = 0;
    
    @SerializedName("country")
    String country = "";
    
    @SerializedName("sunrise")
    long sunrise = 0L;  
    
    @SerializedName("sunset")
    long sunset = 0L;  
      
}
