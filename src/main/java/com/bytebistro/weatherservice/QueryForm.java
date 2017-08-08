package com.bytebistro.weatherservice;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class QueryForm {

    @NotNull
    @Size(min = 1)
    private String city;

    public String getCity() {
        return this.city;
    }

    public void setCity(String email) {
        this.city = city;
    }

   
    public String toString() {
        return city;
    }
}
