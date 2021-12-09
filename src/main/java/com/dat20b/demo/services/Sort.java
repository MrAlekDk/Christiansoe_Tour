package com.dat20b.demo.services;

import com.dat20b.demo.model.Attraction;
import com.dat20b.demo.model.Route;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public abstract class Sort {

    public static List<Attraction> sortActiveAttractions(List<Attraction> allAttractions) {
        allAttractions.removeIf(attraction -> checkIfInActiveSeason(attraction));
        return allAttractions;
    }

    //Check if current month is between the attraction's starting and ending month
    private static boolean checkIfInActiveSeason(Attraction attraction) {
        Month monthNow = LocalDate.now().getMonth();
        Month monthStart = attraction.getActiveSeasonStart().getMonth();
        Month monthEnd = attraction.getActiveSeasonEnd().getMonth();

        return monthNow.getValue() >= monthStart.getValue() && monthNow.getValue() <= monthEnd.getValue();
    }


    public static List<Route> sortRoutesByInterestAndDepartureTime(List<Route> routes, String interest, int departureTime) {
        routes.removeIf(route -> checkInterestAndDepatureTime(route,interest,departureTime));
        return routes;
    }

    private static boolean checkInterestAndDepatureTime(Route route, String interest, int depTime){
        if(route.getTimeDuration().getSeconds() <= Duration.ofMinutes(depTime).getSeconds() && interest.equalsIgnoreCase(route.getInterest())){
            return false;
        }
        else{
            return true;
        }
    }
}
