package com.dat20b.demo.services;

import com.dat20b.demo.model.Attraction;
import com.dat20b.demo.model.Coordinates;
import com.dat20b.demo.model.Location;
import com.dat20b.demo.repository.AttractionRepository;
import java.util.List;
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


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

class AttractionServiceTest {

    @Mock
    AttractionRepository attractionRepository;

    @InjectMocks
    AttractionService attractionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        //Duration and Localdate for attractions
        Duration d = Duration.between(LocalTime.NOON, LocalTime.MAX);
        LocalDate date = LocalDate.now();

        //Coordinates for a location
        Coordinates koor1 = new Coordinates(3, 6);
        Coordinates koor2 = new Coordinates(78, 24);
        Coordinates koor3 = new Coordinates(34, 71);
        Coordinates koor4 = new Coordinates(572, 679);

        //List of attractions for locations
        ArrayList<Attraction> attractionTestTable = new ArrayList<Attraction>();

        //Locations for
        Location lok1 = new Location(1, "Bjørnehulen", "Her bor bjørnen", koor1, attractionTestTable);

        //Attractions
        Attraction att1 = new Attraction(1, "Slottet", "Det gamle slot er bygget i 1900", d, date, "URLTilBillede", "URLTilLyd", lok1);
        Attraction att2 = new Attraction(2, "Slottet", "Det gamle slot er bygget i 1900", d, date, "URLTilBillede", "URLTilLyd", lok1);
        Attraction att3 = new Attraction(3, "Slottet", "Det gamle slot er bygget i 1900", d, date, "URLTilBillede", "URLTilLyd", lok1);
        Attraction att4 = new Attraction(4, "Slottet", "Det gamle slot er bygget i 1900", d, date, "URLTilBillede", "URLTilLyd",lok1);

        attractionTestTable.add(att1);
        attractionTestTable.add(att2);
        attractionTestTable.add(att3);
        attractionTestTable.add(att4);

        Mockito.when(attractionRepository.findAll()).thenReturn(attractionTestTable);

    }

    @Test
    void getAllAttractions() {

        //Arrange
        List<Attraction> testList;

        //act
        testList = attractionService.getAllAttractions();

        //assert
        assertEquals(4, testList.size());
        Mockito.verify(attractionRepository, times(1)).findAll();
    }
}