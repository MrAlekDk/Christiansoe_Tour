package com.dat20b.demo.services;

import com.dat20b.demo.model.*;
import com.dat20b.demo.repository.RouteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

class RouteServiceTest {

    @Mock
    RouteRepository routeRepository;

    @InjectMocks
    RouteService routeService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);

        Duration duration = Duration.ofMinutes(20);


        double routeTotalDuration = 60;

        Route route1 = new Route("name", "desc" , Interest.HISTORY.name(), duration,  routeTotalDuration);
        Route route2 = new Route("name", "desc" , Interest.ANIMALS.name(), duration,  routeTotalDuration);
        Route route3 = new Route("name", "desc" , Interest.HISTORY.name(), duration,  routeTotalDuration);

        ArrayList<Route> routeArrayList = new ArrayList<>();
        routeArrayList.add(route1);
        routeArrayList.add(route2);
        routeArrayList.add(route3);

        Mockito.when(routeRepository.findAll()).thenReturn(routeArrayList);
    }

    @Test
    void getAll(){
        //Arrange
        List<Route> routes;
        //Act
        routes = routeService.getAllRoutes();
        //Assert
        assertEquals(3, routes.size() );
        Mockito.verify(routeRepository, times(1)).findAll();
    }

    @Test
    void getAllRoutesByInterestAndTimeTest(){
        String interest = Interest.HISTORY.name();
        int departureTimeInMinutes = 22;

        List<Route> routes = routeService.getAllRoutesByInterestAndTime(interest,departureTimeInMinutes);

        assertEquals(2,routes.size());


    }
}