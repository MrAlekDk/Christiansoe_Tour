package com.dat20b.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lokationer")
public class LocationController {


 /* @GetMapping
  public ResponseEntity<List<Location>> getAllLocations(){
        List<Location> allLocations = locationsService.getAllLocations();
        return ResponseEntity.status(HttpStatus.OK).body(allLocations);
    } */



}
