package com.hw.thermostat.controller;

import com.hw.thermostat.entity.Device;
import com.hw.thermostat.model.request.DeviceRequest;
import com.hw.thermostat.model.response.DeviceResponse;
import com.hw.thermostat.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService service;


    @PostMapping("/new")
    @PreAuthorize("hasAuthority('ADMIN')")
    public DeviceResponse addNewDevice(@RequestBody DeviceRequest req) {
        return service.addDevice(req);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public DeviceResponse updateDevice(@PathVariable int id, @RequestBody DeviceRequest req) {
        return service.updateDevice(id, req);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Device> getAllDevices() {
        return service.getAllDevices();
    }

    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteDevice(@PathVariable int id) {
        service.deleteDevice(id);
    }

}