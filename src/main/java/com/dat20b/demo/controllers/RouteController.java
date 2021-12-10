package com.dat20b.demo.controllers;

import com.dat20b.demo.model.Route;
import com.dat20b.demo.services.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ruter")
public class RouteController {

    RouteService routeService;

    public RouteController(RouteService routeService){
        this.routeService = routeService;
    }

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes(){
        List<Route> allRoutes = routeService.getAllRoutes();
        return ResponseEntity.status(HttpStatus.OK).body(allRoutes);
    }

    @GetMapping(value = "/specifikRuter")
    public ResponseEntity<List<Route>> getSpecificRoutes(@RequestParam("userInterest") String userInterest, @RequestParam("userDepatureTime") String userDepatureTime){
        System.out.println(userInterest);
        System.out.println(userDepatureTime);
        return null;
    }
}
