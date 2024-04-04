package com.Dat109.WasteWise.Services;

import com.Dat109.WasteWise.Entities.AvfallPunkt;
import com.Dat109.WasteWise.Repositories.AvfallPunktRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvfallPunktService {
    @Autowired
    AvfallPunktRepo avfallPunktRepo;

    public List<AvfallPunkt> getAvfallPunkt(){
        return avfallPunktRepo.findAll();
    }

    public void leggTilAvfallPunkt(String navn, String adresse){
        avfallPunktRepo.save(new AvfallPunkt(navn, adresse));
    }
    public void leggTilAvfallPunkt(AvfallPunkt avfallPunkt){
        avfallPunktRepo.save(avfallPunkt);
    }
}
