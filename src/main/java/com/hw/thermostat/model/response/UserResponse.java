package com.hw.thermostat.model.response;

import com.hw.thermostat.entity.User;
import com.hw.thermostat.model.request.UserRequest;

public class UserResponse extends UserRequest {
    private Long id;

    public UserResponse(User user) {
        super(user.getUsername(), user.getPassword(), user.isEnabled(), user.getRoles());
        id = user.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
