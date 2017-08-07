/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytebistro.weatherservice;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author keith
 */
public class Weather {
    @SerializedName("id")
    int id  = 0;
    
    @SerializedName("main")
    String main = "";
    
      @SerializedName("description")
    String description = null;
      
    @SerializedName("icon")
    String icon = "";
   
}
