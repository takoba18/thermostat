package com.hw.thermostat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hw.thermostat.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class ViewController {

    @Autowired
    private RestTemplate restTemplate;
    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ModelAndView showDashboard() throws JsonProcessingException {
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/devices/all", String.class);
        List<Device> devices = mapper.readValue(response.getBody(), new TypeReference<>() {
        });
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("devices", devices);
        return modelAndView;
    }

    @GetMapping("/new")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ModelAndView addDevice() {
        return new ModelAndView("device");
    }

    @GetMapping("/user")
    public ModelAndView addUser() {
        return new ModelAndView("register");
    }


}
