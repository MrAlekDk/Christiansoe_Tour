package com.dat20b.demo.services;

import com.dat20b.demo.model.Attraction;
import com.dat20b.demo.model.Coordinates;
import com.dat20b.demo.model.Location;
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

    Sort sort = new Sort();

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
    }

    @Test
    void getAttractionInActiveSeasonTest() {

        List<Attraction> attractionsToSort = allAttractions;

        List<Attraction> sortedList = sort.sortActiveAttractions(attractionsToSort);

        assertEquals(2,sortedList.size());
    }

}