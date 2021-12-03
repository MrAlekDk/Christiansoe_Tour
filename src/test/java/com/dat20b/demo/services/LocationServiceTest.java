package com.dat20b.demo.services;

import com.dat20b.demo.model.Coordinates;
import com.dat20b.demo.repository.LocationRepository;
import com.dat20b.demo.model.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.awt.*;
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

        Location lok1 = new Location(1, "Bjørnehulen", "Her bor bjørnen", koor1);
        Location lok2 = new Location(2, "Kirken", "Her er kirken", koor2);
        Location lok3 = new Location(3, "Slottet", "Her er slottet", koor3);
        Location lok4 = new Location(4, "Kontoret", "Her er kontoret", koor4);

        ArrayList<Location> testTable = new ArrayList<Location>();

        testTable.add(lok1);
        testTable.add(lok2);
        testTable.add(lok3);
        testTable.add(lok4);

        Mockito.when(locationRepository.findAll()).thenReturn(testTable);

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