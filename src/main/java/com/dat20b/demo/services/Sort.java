package com.dat20b.demo.services;

import com.dat20b.demo.model.Attraction;
import com.dat20b.demo.model.Location;
import reactor.core.Scannable;

import java.util.ArrayList;
import java.util.List;

public class Sort {

    public List<Attraction> getAllActiveAttractions(Location location) {

        List<Attraction> attractionList = location.getAttractionList();
        List<Attraction> sortedAttractionList = new ArrayList<>();

        for (int i = 0; i < attractionList.size(); i++) {
            if (attractionList.get(i).getLocation().getLocationID() == location.getLocationID()) {
                sortedAttractionList.add(attractionList.get(i));
            }
        }
        return sortedAttractionList;
    }
}
