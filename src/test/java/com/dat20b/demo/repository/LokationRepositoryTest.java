package com.dat20b.demo.repository;

import com.dat20b.demo.model.location;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

class LocationRepositoryTest {

    @Mock
    LocationRepository lokationRepository = new LocationRepository() {

        @BeforeEach
        void before(){
            Point koor1 = new Point(3,6);
            Point koor2 = new Point(78,24);
            Point koor3 = new Point(34,71);
            Point koor4 = new Point(572,679);

            location lok1 = new location(1,"Bjørnehulen", "Her bor bjørnen", koor1);
            location lok2 = new location(2,"Kirken", "Her er kirken", koor2);
            location lok3 = new location(3,"Slottet", "Her er slottet", koor3);
            location lok4 = new location(4,"Kontoret", "Her er kontoret", koor4);

            ArrayList<location> testTable = new ArrayList<location>();

            testTable.add(lok1);
            testTable.add(lok2);
            testTable.add(lok3);
            testTable.add(lok4);

            Mockito.when(lokationRepository.findById(1))
        }

}