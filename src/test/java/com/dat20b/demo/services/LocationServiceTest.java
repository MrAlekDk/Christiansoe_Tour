package com.dat20b.demo.services;

import com.dat20b.demo.model.Attraction;
import com.dat20b.demo.model.Coordinates;
import com.dat20b.demo.repository.LocationRepository;
import com.dat20b.demo.model.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;


class LocationServiceTest {

    @Mock
    LocationRepository locationRepository;

    @InjectMocks
    LocationService locationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        Coordinates koor1 = new Coordinates(3, 6);
        Coordinates koor2 = new Coordinates(78, 24);
        Coordinates koor3 = new Coordinates(34, 71);
        Coordinates koor4 = new Coordinates(572, 679);

        Duration d = Duration.between(LocalTime.NOON, LocalTime.MAX);
        LocalDate date = LocalDate.now();

        ArrayList<Attraction> attractionTestTable = new ArrayList<Attraction>();

        Location lok1 = new Location(1, "Bjørnehulen", "Her bor bjørnen", koor1, attractionTestTable);
        Location lok2 = new Location(2, "Kirken", "Her er kirken", koor2, attractionTestTable);
        Location lok3 = new Location(3, "Slottet", "Her er slottet", koor3, attractionTestTable);
        Location lok4 = new Location(4, "Kontoret", "Her er kontoret", koor4, attractionTestTable);

        ArrayList<Location> locationTestTable = new ArrayList<Location>();

        locationTestTable.add(lok1);
        locationTestTable.add(lok2);
        locationTestTable.add(lok3);
        locationTestTable.add(lok4);

        Mockito.when(locationRepository.findAll()).thenReturn(locationTestTable);

        //Mockito.when(locationRepository.findById(1)).thenReturn(lok1);
    }

    @Test
    void getAllLocationsTest() {
        //Arrange
        List<Location> testList;

        //act
        testList = locationService.getAllLocations();

        //assert
        assertEquals(4, testList.size());
        Mockito.verify(locationRepository, times(1)).findAll();
    }

}