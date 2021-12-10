package com.dat20b.demo.services;

import com.dat20b.demo.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TimeCalculatorTest {

    Duration duration;
    Double routeLength;

    List<Attraction> allAttractions = new ArrayList<>();
    List<Location> allLocations = new ArrayList<>();


    @BeforeEach
    void setUp() {

        Attraction at1 = new Attraction(1, "Attraktion1", "Beskrivelse",
                Duration.ofSeconds(21000L),
                LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 5, 20),
                "Photo",
                "Sound");
        Attraction at2 = new Attraction(2, "Attraktion2", "Beskrivelse",
                Duration.ofSeconds(10000L),
                LocalDate.of(2021, 6, 1),
                LocalDate.of(2021, 12, 20),
                "Photo",
                "Sound");
        Attraction at3 = new Attraction(3, "Attraktion3", "Beskrivelse",
                Duration.ofSeconds(5000L),
                LocalDate.of(2021, 8, 1),
                LocalDate.of(2021, 11, 30),
                "Photo",
                "Sound");

        allAttractions.add(at1);
        allAttractions.add(at2);
        allAttractions.add(at3);

        Coordinates koor5 = new Coordinates(55.32126968558762,15.18755896229778);
        Coordinates koor6 = new Coordinates(55.3180067325101,15.18806321759258);
        Coordinates koor7 = new Coordinates(55.320148518137,15.186273246075572);

        Location lok5 = new Location(1, "lokation", "Her bor bjørnen", koor5);
        Location lok6 = new Location(2, "Båden", "Her er kirken", koor6);
        Location lok7 = new Location(2, "Pak huset", "Her er kirken", koor7);
        Route routeTest = new Route("History","A description", Interest.HISTORY.name(), duration,  routeLength);


        allLocations.add(lok5);
        allLocations.add(lok6);
        allLocations.add(lok7);

    }

    @Test
    public void calculateLocationDuration() {
        //Assign//

        Route routeTest = new Route("History","A description", Interest.HISTORY.name(), duration,  routeLength);

        //Act//

        // Calculating location duration - if route only had one location.
        Duration calDuration = TimeCalculator.getLocationDuration(allAttractions);
        routeTest.setTimeDuration(calDuration);

        // Calculating route duration


        //Assert//

        // Testing location duration
        assertEquals(Duration.ofSeconds(36000).getSeconds(), routeTest.getTimeDuration().getSeconds());
    }

    @Test
    public void calculateRouteDuration() {
        //Assign//

        Route routeTest = new Route("History","A description", Interest.HISTORY.name(), duration,  routeLength);
        Location testLocation = allLocations.get(0);

        //Act//

        testLocation.setAttractionList(allAttractions);
        routeTest.setLocations(allLocations);
        Duration calDuration1 = TimeCalculator.getRouteDuration(routeTest.getLocations());
        routeTest.setTimeDuration(calDuration1);

        //Assert//

        // Testing location duration
        assertEquals(753.6, 1.2*628);
        assertEquals(Duration.ofSeconds(36753).getSeconds(), routeTest.getTimeDuration().getSeconds());
    }





}