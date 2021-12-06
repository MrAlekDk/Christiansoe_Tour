package com.dat20b.demo.services;

import com.dat20b.demo.model.Attraction;
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

        Duration d = Duration.between(LocalTime.NOON, LocalTime.MAX);
        LocalDate date = LocalDate.now();

        Attraction att1 = new Attraction(1, "Slottet", "Det gamle slot er bygget i 1900", d, date, "URLTilBillede", "URLTilLyd");
        Attraction att2 = new Attraction(2, "Slottet", "Det gamle slot er bygget i 1900", d, date, "URLTilBillede", "URLTilLyd");
        Attraction att3 = new Attraction(3, "Slottet", "Det gamle slot er bygget i 1900", d, date, "URLTilBillede", "URLTilLyd");
        Attraction att4 = new Attraction(4, "Slottet", "Det gamle slot er bygget i 1900", d, date, "URLTilBillede", "URLTilLyd");


        ArrayList<Attraction> testTable = new ArrayList<Attraction>();

        testTable.add(att1);
        testTable.add(att2);
        testTable.add(att3);
        testTable.add(att4);

        Mockito.when(attractionRepository.findAll()).thenReturn(testTable);

    }

    @Test
    void getAllAttractions() {

        //Arrange
        List<Attraction> testList;

        //act
        testList = attractionService.getAttractions();

        //assert
        assertEquals(4, testList.size());
        Mockito.verify(attractionRepository, times(1)).findAll();
    }
}