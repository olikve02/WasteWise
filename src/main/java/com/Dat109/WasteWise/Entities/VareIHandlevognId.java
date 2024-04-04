package com.Dat109.WasteWise.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class VareIHandlevognId implements Serializable {

    @Column(name = "Vare_strekkode")
    private String vareStrekkode;

    @Column(name = "handlevogn_handlevogn_id")
    private int handlevognHandlevognId;

    // Getters and setters
}
