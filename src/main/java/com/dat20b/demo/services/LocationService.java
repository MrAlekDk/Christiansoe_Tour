package com.dat20b.demo.services;

import com.dat20b.demo.model.Location;
import com.dat20b.demo.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    public List<Location> getAllLocations() {
        List<Location> allLocations = new ArrayList<Location>();
        locationRepository.findAll().forEach(allLocations::add);
        return allLocations;
    }



}
