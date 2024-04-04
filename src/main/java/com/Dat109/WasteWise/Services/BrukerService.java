package com.Dat109.WasteWise.Services;

import com.Dat109.WasteWise.Entities.Bruker;
import com.Dat109.WasteWise.Entities.Handlevogn;
import com.Dat109.WasteWise.Repositories.BrukerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrukerService {
    @Autowired
    BrukerRepo brukerRepo;
    @Autowired
    HandlekorgService handlekorgService;
    public Bruker finnBruker(String brukernavn){
        return brukerRepo.findById(brukernavn).isPresent() ? brukerRepo.findById(brukernavn).get() : null;
    }

    public void leggTilBruker(Bruker bruker){
        brukerRepo.save(bruker);
        handlekorgService.leggTilHandlevogn(new Handlevogn(bruker));
    }
}
