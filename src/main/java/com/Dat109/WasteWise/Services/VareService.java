package com.Dat109.WasteWise.Services;

import com.Dat109.WasteWise.Repositories.VareRepo;

import com.Dat109.WasteWise.Entities.Vare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VareService {
    @Autowired
    VareRepo vareRepo;

    public void leggTilVare(String strekkode, String navn, String instruksjon, String materiale, int vektGram){
        vareRepo.save(new Vare(strekkode, navn, instruksjon, materiale, vektGram));
    }
    public void leggTilVare(Vare vare){
        vareRepo.save(vare);
    }

    public Optional<Vare> finnVare(String strekkode){
        return vareRepo.findById(strekkode);
    }

}
