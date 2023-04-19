package com.hw.thermostat.service.impl;

import com.hw.thermostat.entity.Device;
import com.hw.thermostat.repository.DeviceRepository;
import com.hw.thermostat.model.request.DeviceRequest;
import com.hw.thermostat.model.response.DeviceResponse;
import com.hw.thermostat.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.hw.thermostat.config.Constant.THRESHOLD;

@Service
public class DeviceServiceImpl implements DeviceService {


    private DeviceRepository deviceRepo;

    @Override
    public List<Device> getAllDevices() {
        return deviceRepo.findAll();
    }

    @Override
    public Optional<Device> getDeviceById(int deviceId) {
        return deviceRepo.findDeviceById(deviceId);
    }

    @Override
    public DeviceResponse addDevice(DeviceRequest req) {

        Device device = new Device();
        String name = req.getName();
        if (deviceRepo.findByName(name) == null) {
            device.setName(name);
            device.setTemperature(req.getTemperature());
            if (req.getTemperature() > THRESHOLD) {
                device.setCritical(true);
            } else device.setCritical(false);
            deviceRepo.save(device);
        }
        return new DeviceResponse(device);

    }

    @Override
    public DeviceResponse updateDevice(int id, DeviceRequest req) {
        Device device = deviceRepo.findById((long) id).orElseThrow(() -> new RuntimeException("There is no device with that id"));
        if (req.getName() != null)
            device.setName(req.getName());
        if (req.getTemperature() != 0)
            device.setTemperature(req.getTemperature());
        return new DeviceResponse(deviceRepo.save(device));


    }

    @Override
    public void deleteDevice(int deviceId) {
        deviceRepo.delete(deviceRepo.findById((long) deviceId).orElseThrow(() -> new RuntimeException("There is no device with that id")));

    }

    @Autowired
    public void setDeviceRepo(DeviceRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }


}
