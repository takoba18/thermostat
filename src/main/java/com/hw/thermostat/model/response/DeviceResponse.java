package com.hw.thermostat.model.response;

import com.hw.thermostat.entity.Device;
import com.hw.thermostat.model.request.DeviceRequest;

public class DeviceResponse extends DeviceRequest {
    private int id;


    public DeviceResponse(Device device) {
        super(device.getName(), device.getTemperature(), device.isCritical());
        id = device.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
