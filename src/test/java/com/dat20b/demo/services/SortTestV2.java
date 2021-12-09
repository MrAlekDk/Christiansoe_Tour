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

class SortTestV2 {

    List<Attraction> allAttractions = new ArrayList<>();
    List<Route> allRoutes = new ArrayList<>();


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

        Route routeTest1 = new Route("History","A description",Interest.HISTORY.name(), Duration.ofMinutes(45),1000.0);
        Route routeTest2 = new Route("History","A description",Interest.HISTORY.name(),Duration.ofMinutes(15),1000.0);
        Route routeTest3 = new Route("History","A description",Interest.ANIMALS.name(),Duration.ofMinutes(40),1000.0);
        Route routeTest4 = new Route("History","A description",Interest.HISTORY.name(),Duration.ofMinutes(100),1000.0);

        allRoutes.add(routeTest1);
        allRoutes.add(routeTest2);
        allRoutes.add(routeTest3);
        allRoutes.add(routeTest4);
    }

    @Test
    void getAttractionInActiveSeasonTest() {

        List<Attraction> attractionsToSort = allAttractions;

        List<Attraction> sortedList = Sort.sortActiveAttractions(attractionsToSort);

        assertEquals(2,sortedList.size());
    }

    @Test
    void sortRoutesByInterestAndDepartureTimeTest(){
        //Arrange
        String interest = Interest.HISTORY.name();

        //Departure time in minutes
        int departureTime = 46;

        List<Route> sortedList = Sort.sortRoutesByInterestAndDepartureTime(allRoutes,interest,departureTime);

        assertEquals(2,sortedList.size());
    }

}