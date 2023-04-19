package com.hw.thermostat.model.request;

public class DeviceRequest {

    private String name;
    private double temperature;

    private boolean isCritical;

    public DeviceRequest(String name, double temperature, boolean isCritical) {
        this.name = name;
        this.temperature = temperature;
        this.isCritical = isCritical;
    }

    public DeviceRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean isCritical() {
        return isCritical;
    }

    public void setCritical(boolean critical) {
        isCritical = critical;
    }


}
