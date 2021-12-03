package com.dat20b.demo.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

class LokationTest {

    @Test
    public void locationGettersTest(){
        //Arrange
        Coordinates lok1 = new Coordinates(34,67);
        Location lokation1 = new Location(1, "Bjørnehulen", "Her bor bjørnen", lok1);

        //Assert
        assertEquals(lokation1.getLocationID(), 1);
        assertEquals(lokation1.getName(), "Bjørnehulen");
        assertEquals(lokation1.getDescription(), "Her bor bjørnen");
        //assertEquals(lokation1.getCoordinates(), new Point(34,67));
    }

    @Test
    void locationConstructorTest(){

    }


}