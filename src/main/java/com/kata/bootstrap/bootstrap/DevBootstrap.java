package com.kata.bootstrap.bootstrap;

import com.kata.bootstrap.repositories.VehicleRepository;
import com.kata.bootstrap.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setMake("Ford");
        vehicle1.setModel("Transit");
        vehicle1.setYear(2007);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setMake("Mercury");
        vehicle2.setModel("Villager");
        vehicle2.setYear(1997);

        vehicleRepository.save(Arrays.asList(vehicle1, vehicle2));
    }
}
