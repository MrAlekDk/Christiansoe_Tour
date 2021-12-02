package model;

import javax.persistence.*;
import java.awt.*;

@Table(name = "lokation")
@Entity
public class Lokation {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lokationID;

    private String navn;

    private String beskrivelse;

    private Point koordinater;

      /*@OneToMany
    @JoinColumn(name = "seværdighed_id")
    private List<Seværdigheder>;
    */

    public Lokation() {
    }

    public Lokation(int lokationID, String navn, String beskrivelse, Point koordinater) {
        this.lokationID = lokationID;
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.koordinater = koordinater;
    }


    public int getLokationID() {
        return lokationID;
    }

    public void setLokationID(int lokationID) {
        this.lokationID = lokationID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public Point getKoordinater() {
        return koordinater;
    }

    public void setKoordinater(Point koordinater) {
        this.koordinater = koordinater;
    }
}
