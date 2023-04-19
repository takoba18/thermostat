package com.hw.thermostat.service.impl;

import com.hw.thermostat.entity.User;
import com.hw.thermostat.model.request.UserRequest;
import com.hw.thermostat.model.response.UserResponse;
import com.hw.thermostat.repository.UserRepository;
import com.hw.thermostat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserResponse addUser(UserRequest req) {
        User user = new User();
        String username = req.getUsername();
        if (userRepo.findByUsername(username) == null) {
            String encryptedPwd = passwordEncoder.encode(req.getPassword());
            user.setUsername(req.getUsername());
            user.setPassword(encryptedPwd);
            user.setEnabled(req.isEnabled());
            user.setRoles(req.getRoles());
            userRepo.save(user);
        }
        return new UserResponse(user);
    }

}
