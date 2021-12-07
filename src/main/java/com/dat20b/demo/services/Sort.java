package com.dat20b.demo.services;

import com.dat20b.demo.model.Attraction;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Sort {

    public Sort() {
    }


    public List<Attraction> sortActiveAttractions(List<Attraction> allAttractions) {

        allAttractions.removeIf(this::checkIfInActiveSeason);
        return allAttractions;
    }

    private boolean checkIfInActiveSeason(Attraction attraction) {
        Month monthNow = LocalDate.now().getMonth();
        Month monthStart = attraction.getActiveSeasonStart().getMonth();
        Month monthEnd = attraction.getActiveSeasonEnd().getMonth();

        return monthNow.getValue() >= monthStart.getValue() && monthNow.getValue() <= monthEnd.getValue();
    }
}
