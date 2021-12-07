package com.dat20b.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;

@Table(name = "attractions")
@Entity
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    int attraction_id;

    private String name;

   // private String description;

   // private Duration time;

   // private LocalDate activeSeason;

    //private String photo;

    //private String sound;

   @ManyToOne
   @JsonBackReference(value = "attractions")
   @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    public Attraction(){
    }

    public Attraction(int attraction_id, String name, String description, Duration time, LocalDate activeSeason, String photo, String sound, Location location) {
        this.attraction_id = attraction_id;
        this.name = name;
        /*
        this.description = description;
        this.time = time;
        this.activeSeason = activeSeason;
        this.photo = photo;
        this.sound = sound;

         */
        this.location = location;
    }

    public int getAttraction_id() {
        return attraction_id;
    }

    public void setAttraction_id(int attraction_id) {
        this.attraction_id = attraction_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }

    public LocalDate getActiveSeason() {
        return activeSeason;
    }

    public void setActiveSeason(LocalDate activeSeason) {
        this.activeSeason = activeSeason;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }


 */
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
