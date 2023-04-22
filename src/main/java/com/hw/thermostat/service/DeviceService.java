package com.hw.thermostat.service;

import com.hw.thermostat.entity.Device;
import com.hw.thermostat.model.request.DeviceRequest;
import com.hw.thermostat.model.response.DeviceResponse;

import java.util.List;

public interface DeviceService {
    List<Device> getAllDevices();


    DeviceResponse addDevice(DeviceRequest req);

    DeviceResponse updateDevice(int id, DeviceRequest req);

    void deleteDevice(int deviceId);

}
