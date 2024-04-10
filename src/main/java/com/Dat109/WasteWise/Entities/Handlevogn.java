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
    private User user;


    public Handlevogn(){

    }

    public Handlevogn(User bruker) {
        this.user = bruker;
    }

    public User getBruker() {
        return user;
    }

    public void setBruker(User bruker) {
        this.user = bruker;
    }




    // Getters and setters
}
