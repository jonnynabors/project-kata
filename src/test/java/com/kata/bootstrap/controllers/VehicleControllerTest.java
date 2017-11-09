package com.kata.bootstrap.controllers;

import com.kata.bootstrap.models.Vehicle;
import com.kata.bootstrap.repositories.VehicleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehicleControllerTest {

    @InjectMocks
    private VehicleController vehicleController;

    @Mock
    private VehicleRepository vehicleRepository;

    @Test
    public void shouldCollaborateWithARepositoryWhenFetchingAllVehicles() {
        Vehicle vehicle = new Vehicle();
        when(vehicleRepository.findAll()).thenReturn(Arrays.asList(vehicle));
        List<Vehicle> actual = vehicleController.fetchVehicles();

        assertEquals(1, actual.size());
        verify(vehicleRepository).findAll();
    }

}