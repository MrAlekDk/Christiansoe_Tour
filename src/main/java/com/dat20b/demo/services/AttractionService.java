package com.dat20b.demo.services;

import com.dat20b.demo.model.Attraction;
import com.dat20b.demo.repository.AttractionRepository;
import com.dat20b.demo.repository.LocationRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttractionService {

    AttractionRepository attractionRepository;
    LocationRepository locationRepository;

    public AttractionService(AttractionRepository attractionRepository, LocationRepository locationRepository) {
        this.attractionRepository = attractionRepository;
        this.locationRepository = locationRepository;
    }

    public List<Attraction> getAllAttractions() {
        List<Attraction> allAttractions = new ArrayList<Attraction>();
        attractionRepository.findAll().forEach(allAttractions::add);
        return allAttractions;
}

    public void addAttraction(Attraction attraction, int locationId){
        attraction.setLocation(locationRepository.findById(locationId).get());
        attractionRepository.save(attraction);
    }
}

