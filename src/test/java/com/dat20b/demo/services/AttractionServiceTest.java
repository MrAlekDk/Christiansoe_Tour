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


        LocalDate dateStart = LocalDate.of(2021,1,1);
        LocalDate dateEnd = LocalDate.of(2021,5,1);

        //Coordinates for a location
        Coordinates koor1 = new Coordinates(3, 6);
        Coordinates koor2 = new Coordinates(78, 24);
        Coordinates koor3 = new Coordinates(34, 71);
        Coordinates koor4 = new Coordinates(572, 679);

        //List of attractions for locations
        ArrayList<Attraction> attractionTestTable = new ArrayList<Attraction>();

        //Locations for
        Location lok1 = new Location(1, "Bjørnehulen", "Her bor bjørnen", koor1);

        //Attractions
        Attraction att1 = new Attraction(1, "Slottet", "Det gamle slot er bygget i 1900", d, dateStart, dateEnd, "URLTilBillede", "URLTilLyd");
        Attraction att2 = new Attraction(2, "Slottet", "Det gamle slot er bygget i 1900", d, dateStart, dateEnd, "URLTilBillede", "URLTilLyd");
        Attraction att3 = new Attraction(3, "Slottet", "Det gamle slot er bygget i 1900", d, dateStart, dateEnd, "URLTilBillede", "URLTilLyd");
        Attraction att4 = new Attraction(4, "Slottet", "Det gamle slot er bygget i 1900", d, dateStart, dateEnd, "URLTilBillede", "URLTilLyd");

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

    @Test
    void addAttraction(){
        //arrange
        Duration d = Duration.between(LocalTime.NOON, LocalTime.MAX);
        LocalDate dateStart = LocalDate.of(2021,1,1);
        LocalDate dateEnd = LocalDate.of(2021,5,1);
        Attraction att1 = new Attraction(1, "Slottet", "Det gamle slot er bygget i 1900", d, dateStart, dateEnd, "URLTilBillede", "URLTilLyd");

        //act
        attractionService.addAttraction(att1, 1);

        //assert
        assertEquals(1, att1.getAttraction_id());
        assertEquals("Slottet", att1.getName());
        assertEquals("Det gamle slot er bygget i 1900", att1.getDescription());
        assertEquals(Duration.between(LocalTime.NOON, LocalTime.MAX), att1.getTime());
        assertEquals(LocalDate.of(2021,1,1), att1.getActiveSeasonStart());
        assertEquals(LocalDate.of(2021,5,1), att1.getActiveSeasonEnd());
        assertEquals("URLTilBillede",att1.getPhoto());
        assertEquals("URLTilLyd", att1.getSound());
        Mockito.verify(attractionRepository, times(1)).save(att1);
    }
}