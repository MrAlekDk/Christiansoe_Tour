package com.dat20b.demo.controllers;

import com.dat20b.demo.services.LocationService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lokationer")
public class LocationController {

    private LocationService locationsService;

    public LocationController(LocationService locationService){
        this.locationsService = locationService;
    }


 /* @GetMapping
  public ResponseEntity<List<Location>> getAllLocations(){
        List<Location> allLocations = locationsService.getAllLocations();
        return ResponseEntity.status(HttpStatus.OK).body(allLocations);
    } */


}
