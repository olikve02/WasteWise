package com.Dat109.WasteWise.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "avfallpunkt")
public class AvfallPunkt {
    @Id String navn;
    String adresse;



    public AvfallPunkt() {
    }

    public AvfallPunkt(String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
