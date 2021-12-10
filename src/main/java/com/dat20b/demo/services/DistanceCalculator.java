package com.dat20b.demo.services;

import com.dat20b.demo.model.Coordinates;
import com.dat20b.demo.model.Location;

import java.util.List;

public abstract class DistanceCalculator {

    public static double getDistance(List<Location> locationList){
        double R = 6371.01;
        double distance = 0;
        for (int i = 0; i < locationList.size(); i++) {
            if (i+1 == locationList.size()){
                return Math.round(distance);
            }
            Coordinates from = locationList.get(i).getCoordinates();
            Coordinates to = locationList.get(i+1).getCoordinates();
            double latDistance = Math.toRadians(to.getY() - from.getY());
            double lonDistance = Math.toRadians(to.getX() - from.getX());
            double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                    + Math.cos(Math.toRadians(from.getY())) * Math.cos(Math.toRadians(to.getY()))
                    * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            distance += R * c * 1000; // convert to meters
        }
        return 0.0;
    }
}
