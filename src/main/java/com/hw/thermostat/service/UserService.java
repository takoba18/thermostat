package com.hw.thermostat.service;

import com.hw.thermostat.entity.User;
import com.hw.thermostat.model.request.UserRequest;
import com.hw.thermostat.model.response.UserResponse;


import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    UserResponse addUser(UserRequest req);


}
