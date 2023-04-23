package com.hw.thermostat.controller;

import com.hw.thermostat.entity.User;
import com.hw.thermostat.model.request.UserRequest;
import com.hw.thermostat.model.response.UserResponse;
import com.hw.thermostat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public UserResponse register(@RequestBody UserRequest req) {
        return userService.addUser(req);
    }

    @GetMapping("/users")
    public List<User> loadUsers() {
        return userService.getAllUsers();
    }

}
