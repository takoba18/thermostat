package com.hw.thermostat.repository;

import com.hw.thermostat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT count (u) > 0  FROM User u WHERE u.username = :username")
    boolean existsByUsername(@Param("username") String username);

    Optional<User> findByUsername(String username);

    List<User> findAll();

}
