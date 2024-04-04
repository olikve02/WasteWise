package com.Dat109.WasteWise.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bruker {
    @Id String brukernavn;
    String passord;
    String adresse;
    String email;
    int telefon;


    public Bruker() {
    }

    public Bruker(String brukernavn, String passord, String adresse, String email, int telefon) {
        this.brukernavn = brukernavn;
        this.passord = passord;
        this.adresse = adresse;
        this.email = email;
        this.telefon = telefon;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String epost) {
        this.email = epost;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }
}
