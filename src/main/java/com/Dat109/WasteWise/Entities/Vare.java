package com.Dat109.WasteWise.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Vare {
    @Id String strekkode;
    String navn;
    String instruksjon;
    String materiale;
    int vektgram;


    public Vare(){

    }
    public Vare(String strekkode, String navn, String instruksjon, String materiale, int vektgram) {
        this.strekkode = strekkode;
        this.navn = navn;
        this.instruksjon = instruksjon;
        this.materiale = materiale;
        this.vektgram = vektgram;
    }

    public String getStrekkode() {
        return strekkode;
    }

    public void setStrekkode(String strekkode) {
        this.strekkode = strekkode;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }



    @Override
    public String toString() {
        return "com.Dat109.WasteWise.Entities.Vare{" +
                "strekkode='" + strekkode + '\'' +
                ", navn='" + navn + '\'' +
                ", instruksjon='" + instruksjon + '\'' +
                '}';
    }

    public int getVektgram() {
        return vektgram;
    }

    public void setVektgram(int vektGram) {
        this.vektgram = vektGram;
    }

    public String getInstruksjon() {
        return instruksjon;
    }

    public void setInstruksjon(String instruksjon) {
        this.instruksjon = instruksjon;
    }
}
