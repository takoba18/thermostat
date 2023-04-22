package com.hw.thermostat.controller;

import com.hw.thermostat.entity.User;
import com.hw.thermostat.model.request.UserRequest;
import com.hw.thermostat.model.response.UserResponse;
import com.hw.thermostat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserResponse register(@RequestBody UserRequest req) {
        return userService.addUser(req);
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<User> loadUsers() {
        return userService.getAllUsers();
    }

}
