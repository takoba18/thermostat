package com.hw.thermostat;

import com.hw.thermostat.entity.Device;
import com.hw.thermostat.repository.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

import static com.hw.thermostat.config.Constant.THRESHOLD;

@Component
public class DeviceSimulator implements CommandLineRunner {
    @Autowired
    private DeviceRepository deviceRepository;

    private double generateTemperature() {
        Random random = new Random();
        return 70.0 + (random.nextDouble() * 50.0);
    }

    private boolean isCritical(double temperature) {
        return temperature > THRESHOLD;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            List<Device> devices = deviceRepository.findAll();
            int size = devices.size();
            if (size == 0) {
                throw new EntityNotFoundException("No devices found");
            }
            int randomIndex = (int) (Math.random() * size);
            Device device = devices.get(randomIndex);
            double temperature = generateTemperature();
            boolean isCritical = isCritical(temperature);
            device.setTemperature(temperature);
            device.setCritical(isCritical);
            deviceRepository.save(device);
            System.out.println("Device: " + device.getName() + ", Temperature: " + temperature +
                    (isCritical ? " (critical)" : ""));
            Thread.sleep(5000);
        }
    }
}

