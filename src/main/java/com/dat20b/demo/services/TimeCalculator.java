package com.dat20b.demo.services;

import com.dat20b.demo.model.Attraction;
import com.dat20b.demo.model.Coordinates;
import com.dat20b.demo.model.Location;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public abstract class TimeCalculator {


    public static Duration getLocationDuration(List<Attraction> attractionList){
       AtomicLong totalTime = new AtomicLong();
        attractionList.forEach(attraction -> totalTime.addAndGet(attraction.getTime().getSeconds()));
        return Duration.ofSeconds(totalTime.get());

    }

    public static Duration getRouteDuration(List<Location> locationList){
        double normalWalkSpeed = 1.2;
        long distance = (long) DistanceCalculator.getDistance(locationList);
        AtomicLong routeTime = new AtomicLong();
        locationList.forEach(location -> routeTime.addAndGet(getLocationDuration(location.getAttractionList()).getSeconds()));
        double walkTime = normalWalkSpeed * distance;
        routeTime.addAndGet((long)walkTime);
        return Duration.ofSeconds(routeTime.get());
    }


}
