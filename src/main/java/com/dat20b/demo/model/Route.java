package com.dat20b.demo.model;

import javax.persistence.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id", nullable = false, unique = true)
    private int routeId;

    @Column(name="name")
    private String name;

    @Column(name="description", length = 1000)
    private String description;

    @Column(name="interest")
    private String interest;

    @Column(name="timeD")
    private Duration timeDuration;

    //mapped by her
    @ManyToMany(mappedBy = "allRoutes")
    private List<Location> locations = new ArrayList<>();

    @Column(name="routelength")
    private Double routeLength;

    //private List<Activity> routeActivities;

    public Route(){}

    public Route(String name, String description, String interest, int timeDuration, Double routeLength) {
        this.name = name;
        this.description = description;
        this.interest = interest;
        this.timeDuration = Duration.ofMinutes(timeDuration);
        this.routeLength = routeLength;
    }

    public Route(String name, String description, String interest, Duration timeDuration, Double routeLength) {
        this.name = name;
        this.description = description;
        this.interest = interest;
        this.timeDuration = timeDuration;
        this.routeLength = routeLength;
    }


    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public Duration getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(Duration timeDuration) {
        this.timeDuration = timeDuration;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Double getRouteLength() {
        return routeLength;
    }

    public void setRouteLength(Double routeLength) {
        this.routeLength = routeLength;
    }
}
