package com.kata.bootstrap.controllers;

import com.kata.bootstrap.models.Vehicle;
import com.kata.bootstrap.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping(path = "/vehicles")
    public List<Vehicle> fetchVehicles() {
        return vehicleRepository.findAll();
    }
}
