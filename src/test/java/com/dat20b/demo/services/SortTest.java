package com.dat20b.demo.services;

import com.dat20b.demo.model.Attraction;
import com.dat20b.demo.model.Coordinates;
import com.dat20b.demo.model.Location;
import com.dat20b.demo.repository.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

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

        //List of attractions for locations
        ArrayList<Attraction> attractionTestTable = new ArrayList<Attraction>();

        Location lok1 = new Location(1, "Bjørnehulen", "Her bor bjørnen", koor1,attractionTestTable);
        Location lok2 = new Location(2, "Kirken", "Her er kirken", koor2, attractionTestTable);
        Location lok3 = new Location(3, "Slottet", "Her er slottet", koor3,attractionTestTable);
        Location lok4 = new Location(4, "Kontoret", "Her er kontoret", koor4,attractionTestTable);

        //Attractions
        Attraction att1 = new Attraction(1, "Slottet", "Det gamle slot er bygget i 1900", d, date, "URLTilBillede", "URLTilLyd", lok1);
        Attraction att2 = new Attraction(2, "Slottet", "Det gamle slot er bygget i 1900", d, date, "URLTilBillede", "URLTilLyd", lok1);
        Attraction att3 = new Attraction(3, "Slottet", "Det gamle slot er bygget i 1900", d, date, "URLTilBillede", "URLTilLyd", lok2);
        Attraction att4 = new Attraction(4, "Slottet", "Det gamle slot er bygget i 1900", d, date, "URLTilBillede", "URLTilLyd",lok2);

        attractionTestTable.add(att1);
        attractionTestTable.add(att2);
        attractionTestTable.add(att3);
        attractionTestTable.add(att4);

        ArrayList<Location> testTable = new ArrayList<Location>();

        testTable.add(lok1);
        testTable.add(lok2);
        testTable.add(lok3);
        testTable.add(lok4);

        Mockito.when(locationRepository.findAll()).thenReturn(testTable);

        //Mockito.when(locationRepository.findById(1)).thenReturn(lok1);
    }

    @Test
    void sortForInterest(){

    }


    @Test
    public void sortActiveAttractions(){

        //Arrange
        List<Location> locationList;
        int currentLocation;
        List<Attraction> attractionList;

        //Act
        locationList = locationService.getAllLocations();
        currentLocation = 3;
        attractionList = locationList.get(currentLocation).getAttractionList();

        //Assert
        assertEquals(4, attractionList.size());
    }
}