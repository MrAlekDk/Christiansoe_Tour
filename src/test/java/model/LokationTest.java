package model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

class LokationTest {

    @Test
    public void Lokation(){
        //Arrange
        Point lok1 = new Point(34,67);
        Lokation lokation1 = new Lokation(1, "Bjørnehulen", "Her bor bjørnen", lok1);

        //Assert
        assertEquals(lokation1.getLokationID(), 1);
        assertEquals(lokation1.getNavn(), "Bjørnehulen");
        assertEquals(lokation1.getBeskrivelse(), "Her bor bjørnen");
        assertEquals(lokation1.getKoordinater(), new Point(34,67));
    }

}