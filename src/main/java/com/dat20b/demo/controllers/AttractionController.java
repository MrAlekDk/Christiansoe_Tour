package com.dat20b.demo.controllers;

import com.dat20b.demo.model.Attraction;
import com.dat20b.demo.services.AttractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/seværdigheder")
public class AttractionController {

    AttractionService attractionService;

    public AttractionController (AttractionService attractionService){
        this.attractionService = attractionService;
    }

    @GetMapping
    public ResponseEntity<List<Attraction>> getAllAttractions(){
        List<Attraction> allAttractions = attractionService.getAllAttractions();
        return ResponseEntity.status(HttpStatus.OK).body(allAttractions);
    }

    @PostMapping("/{location}")
    public ResponseEntity<Object> createAttraction(@RequestBody Attraction newAttraction, @PathVariable("location") Integer locationId){
        attractionService.addAttraction(newAttraction, locationId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
