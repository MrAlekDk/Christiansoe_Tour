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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Column(name = "time", nullable = false)
    private int time;

    @Column(name = "ass", nullable = false)
    private LocalDate activeSeasonStart;

    @Column(name = "ase", nullable = false)
    private LocalDate activeSeasonEnd;

    @Column(name = "photo", nullable = false)
    private String photo;

    @Column(name = "sound", nullable = false)
    private String sound;

    @ManyToOne
    @JsonBackReference(value = "attractions")
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    public Attraction() {
    }

    public Attraction(int attraction_id, String name, String description, long time, LocalDate activeSeasonStart, LocalDate activeSeasonEnd, String photo, String sound) {
        this.attraction_id = attraction_id;
        this.name = name;
        this.description = description;
        this.time = (int) time;
        this.activeSeasonStart = activeSeasonStart;
        this.activeSeasonEnd = activeSeasonEnd;
        this.photo = photo;
        this.sound = sound;
    }

    public Attraction(int attraction_id, String name, String description, Duration time, LocalDate activeSeasonStart, LocalDate activeSeasonEnd, String photo, String sound) {
        this.attraction_id = attraction_id;
        this.name = name;
        this.description = description;
        this.time = (int) time.toMinutes();
        this.activeSeasonStart = activeSeasonStart;
        this.activeSeasonEnd = activeSeasonEnd;
        this.photo = photo;
        this.sound = sound;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration getTime() {
        return Duration.ofMinutes(time);
    }

    /*public void setTime(Duration time) {
        this.time = (int) time.toMinutes();
    }*/

    public LocalDate getActiveSeasonStart() {
        return activeSeasonStart;
    }

    public void setActiveSeasonStart(LocalDate activeSeasonStart) {
        this.activeSeasonStart = activeSeasonStart;
    }

    public LocalDate getActiveSeasonEnd() {
        return activeSeasonEnd;
    }

    public void setActiveSeasonEnd(LocalDate activeSeasonEnd) {
        this.activeSeasonEnd = activeSeasonEnd;
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


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
