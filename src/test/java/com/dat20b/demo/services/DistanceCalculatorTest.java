package com.dat20b.demo.services;

import com.dat20b.demo.model.Coordinates;
import com.dat20b.demo.model.Interest;
import com.dat20b.demo.model.Location;
import com.dat20b.demo.model.Route;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    Duration duration;
    double routeLength;

    @Test
    public void calculateDistance(){
        //Assign//
        // Set coordinates for locations
        Coordinates koor5 = new Coordinates(55.32126968558762,15.18755896229778);
        Coordinates koor6 = new Coordinates(55.3180067325101,15.18806321759258);
        Coordinates koor7 = new Coordinates(55.320148518137,15.186273246075572);
        // Created locations from coordinates
        Location lok5 = new Location(1, "lokation", "Her bor bjørnen", koor5);
        Location lok6 = new Location(2, "Båden", "Her er kirken", koor6);
        Location lok7 = new Location(2, "Pak huset", "Her er kirken", koor7);
        Route routeTest = new Route("History","A description", Interest.HISTORY.name(), duration,  routeLength);

        // Placed location in an arrayList as a "Route"
        List<Location> locations = new ArrayList<>();
        locations.add(lok5);
        locations.add(lok6);
        locations.add(lok7);

        //Act//
        // Test the "Routes" distance
        routeTest.setRouteLength(DistanceCalculator.getDistance(locations));
        //Assert//
        // 628 is the distance in meter measured by leaflets distance method.
        assertEquals(628.00, routeTest.getRouteLength());

    }

}