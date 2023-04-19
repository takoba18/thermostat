package com.hw.thermostat.controller;

import com.hw.thermostat.entity.Device;
import com.hw.thermostat.model.request.DeviceRequest;
import com.hw.thermostat.model.response.DeviceResponse;
import com.hw.thermostat.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService service;


    @PostMapping("/new")
    public DeviceResponse addNewDevice(@RequestBody DeviceRequest req) {
        return service.addDevice(req);
    }

    @PutMapping("/update/{id}")
    public DeviceResponse addNewDevice(@PathVariable int id, @RequestBody DeviceRequest req) {
        return service.updateDevice(id, req);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Device> getAllTheDevices() {
        return service.getAllDevices();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<Device> getProductById(@PathVariable int id) {
        return service.getDeviceById(id);
    }


    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteDevice(@PathVariable int id) {
        service.deleteDevice(id);
    }

}