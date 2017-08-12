package com.bytebistro.weatherservice.model;

public class Subscription {
    private String name;
    private String email;
    private String location;
    private int heat;
    private int cold;
    private int extreme;

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getLocation() {
        return this.location;
    }

    public int getHeat() {
        return this.heat;
    }

    public int getCold() {
        return this.cold;
    }

    public int getExtreme() {
        return this.extreme;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public void setLocation(String l) {
        this.location = l;
    }

    public void setHeat(int h) {
        this.heat = h;
    }

    public void setCold(int c) {
        this.cold = c;
    }

    public void setExtreme(int e) {
        this.extreme = e;
    }

}
