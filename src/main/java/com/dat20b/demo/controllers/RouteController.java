package com.dat20b.demo.controllers;

import com.dat20b.demo.model.Route;
import com.dat20b.demo.services.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
