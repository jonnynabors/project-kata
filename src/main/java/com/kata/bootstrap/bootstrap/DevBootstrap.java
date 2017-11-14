package com.kata.bootstrap.bootstrap;

import com.kata.bootstrap.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public DevBootstrap(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
}
