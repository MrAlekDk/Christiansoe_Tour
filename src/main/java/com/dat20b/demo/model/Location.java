package com.dat20b.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.xml.bind.v2.runtime.Coordinator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int locationID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;


    @Column(name="lat",nullable = false)
    private double lattitude;

    @Column(name = "long",nullable = false)
    private double longitude;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    @JsonManagedReference("attractions")
    private List<Attraction> attractionList = new ArrayList<>();

    //join tables her
    @ManyToMany
    @JoinTable(name="route_locations", joinColumns = @JoinColumn(name="location_id"), inverseJoinColumns = @JoinColumn(name = "route_id"))
    private List<Route> allRoutes = new ArrayList<>();

    public Location(){}

    public Location(int lokationID, String navn, String beskrivelse, Coordinates koordinater) {
        this.locationID = lokationID;
        this.name = navn;
        this.description = beskrivelse;
        this.longitude = koordinater.getX();
        this.lattitude = koordinater.getY();
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int lokationID) {
        this.locationID = lokationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String navn) {
        this.name = navn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String beskrivelse) {
        this.description = beskrivelse;
    }

    public Coordinates getCoordinates() {

        return new Coordinates(lattitude,longitude);
    }

    public void setCoordinates(Coordinates koordinater) {
        lattitude = koordinater.getX();
        longitude = koordinater.getY();
    }

    public List<Attraction> getAttractionList() {
        return attractionList;
    }

    public void setAttractionList(List<Attraction> attractionList) {
        this.attractionList = attractionList;
    }
}
