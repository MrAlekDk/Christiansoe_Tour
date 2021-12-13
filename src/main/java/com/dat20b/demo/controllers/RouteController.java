package com.dat20b.demo.controllers;

import com.dat20b.demo.model.Route;
import com.dat20b.demo.services.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
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
        Time date1 = Time.valueOf(userDepatureTime+":00");
        Time date2 = Time.valueOf(LocalTime.now());
        int depatureTime = date1.getMinutes() - date2.getMinutes();

        List<Route> allRoutes = routeService.getAllRoutesByInterestAndTime(userInterest, depatureTime);
        return ResponseEntity.status(HttpStatus.OK).body(allRoutes);
    }
}
