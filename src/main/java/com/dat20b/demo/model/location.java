package com.dat20b.demo.model;

import javax.persistence.*;
import java.awt.*;

@Table(name = "location")
@Entity
public class location {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationID;

    private String name;

    private String Description;

    private Point coordinates;

      /*@OneToMany
    @JoinColumn(name = "attraction_id")
    private List<attraction>;
    */

    public location() {
    }

    public location(int lokationID, String navn, String beskrivelse, Point koordinater) {
        this.locationID = lokationID;
        this.name = navn;
        this.Description = beskrivelse;
        this.coordinates = koordinater;
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
        return Description;
    }

    public void setDescription(String beskrivelse) {
        this.Description = beskrivelse;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point koordinater) {
        this.coordinates = koordinater;
    }
}
