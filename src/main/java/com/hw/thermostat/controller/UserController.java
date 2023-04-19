package com.hw.thermostat.controller;

import com.hw.thermostat.entity.User;
import com.hw.thermostat.model.request.UserRequest;
import com.hw.thermostat.model.response.UserResponse;
import com.hw.thermostat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest req) {
        return ResponseEntity.ok(userService.addUser(req));
    }

    @GetMapping("/users")
    public List<User> loadUsers() {
        return userService.getAllUsers();
    }

}
