package com.Dat109.WasteWise.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vare_i_handlevogn")
public class VareHandlevogn {
    @EmbeddedId
    private VareIHandlevognId id;

    @ManyToOne
    @MapsId("vareStrekkode")
    @JoinColumn(name = "Vare_strekkode")
    private Vare vare;

    @ManyToOne
    @MapsId("handlevognHandlevognId")
    @JoinColumn(name = "handlevogn_handlevogn_id")
    private Handlevogn handlevogn;

}
