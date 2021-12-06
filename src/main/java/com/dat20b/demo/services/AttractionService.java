package com.dat20b.demo.services;

import com.dat20b.demo.model.Attraction;
import com.dat20b.demo.repository.AttractionRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttractionService {

    AttractionRepository attractionRepository;

    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public List<Attraction> getAllAttractions() {
        List<Attraction> allAttractions = new ArrayList<Attraction>();
        attractionRepository.findAll().forEach(allAttractions::add);
        return allAttractions;
}
}

