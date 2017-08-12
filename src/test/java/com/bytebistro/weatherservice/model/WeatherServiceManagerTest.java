/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytebistro.weatherservice.model;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author keith
 */
public class WeatherServiceManagerTest {
    String mocJSON = "{\"coord\":{\"lon\":139.01,\"lat\":35.02},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":285.514,\"pressure\":1013.75,\"humidity\":100,\"temp_min\":285.514,\"temp_max\":285.514,\"sea_level\":1023.22,\"grnd_level\":1013.75},\"wind\":{\"speed\":5.52,\"deg\":311},\"clouds\":{\"all\":0},\"dt\":1485792967,\"sys\":{\"message\":0.0025,\"country\":\"JP\",\"sunrise\":1485726240,\"sunset\":1485763863},\"id\":1907296,\"name\":\"Tawarano\",\"cod\":200}";
  
    @Test
    public void testTimeToString(){
        WeatherServiceManager weatherServ = new WeatherServiceManager();
        String result = weatherServ.timeToString(1485792967);
        assertEquals("8:16 AM", result);
    }
    
    @Test
    public void testConvertJsonToJavaObject(){
        WeatherServiceManager weatherServ = new WeatherServiceManager();
        weatherServ.convertJsonToJavaObject(mocJSON);
        assertEquals(weatherServ.getDescription(), "clear sky");
                }
}
