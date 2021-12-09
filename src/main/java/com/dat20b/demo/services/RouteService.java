package com.dat20b.demo.services;

import com.dat20b.demo.model.Route;
import com.dat20b.demo.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {

    RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository){
        this.routeRepository = routeRepository;
    }

    public List<Route> getAllRoutes(){
        List<Route> allRoutes = new ArrayList<>();
        routeRepository.findAll().forEach(allRoutes::add);
        return allRoutes;
    }
}
