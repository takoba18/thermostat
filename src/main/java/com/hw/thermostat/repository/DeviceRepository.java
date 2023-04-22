package com.hw.thermostat.repository;

import com.hw.thermostat.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Query("SELECT d FROM Device d WHERE d.id = :id")
    Optional<Device> findDeviceById(@Param("id") int id);


    @Query("SELECT count (d) > 0  FROM Device d WHERE d.name = :name")
    boolean existsByName(@Param("name") String name);


    List<Device> findAll();
}
