package com.Dat109.WasteWise.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Handlevogn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "handlevogn_id")
    private int handlevogn_id;

    @ManyToOne
    @JoinColumn(name = "bruker_brukernavn")
    private Bruker bruker;


    public Handlevogn(){

    }

    public Handlevogn(Bruker bruker) {
        this.bruker = bruker;
    }

    public Bruker getBruker() {
        return bruker;
    }

    public void setBruker(Bruker bruker) {
        this.bruker = bruker;
    }




    // Getters and setters
}
