package com.dat20b.demo.controllers;

import com.dat20b.demo.model.Location;
import com.dat20b.demo.model.Route;
import com.dat20b.demo.services.LocationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lokationer")
@CrossOrigin(origins = "*")
public class LocationController {

    private LocationService locationsService;

    public LocationController(LocationService locationService) {
        this.locationsService = locationService;

    }


    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> allLocations = locationsService.getAllLocations();
        return ResponseEntity.status(HttpStatus.OK).body(allLocations);
    }

}
