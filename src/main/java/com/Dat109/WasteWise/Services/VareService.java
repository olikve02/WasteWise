package com.Dat109.WasteWise.Services;

import com.Dat109.WasteWise.Repositories.VareRepo;

import com.Dat109.WasteWise.Entities.Vare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String finnVareOgRedirect(@RequestBody MultiValueMap<String, String> strekkodeRaw, RedirectAttributes redirectAttributes){
        //Konverterer fra json til string
        String strekkode = strekkodeRaw.getFirst("strekkode");
        //Søker etter varen i databasen
        Optional<Vare> vare = finnVare(strekkode);
        //Sender bruker til riktig view ettersom varen blir funnet eller ikke
        if(!vare.isPresent()){
            redirectAttributes.addFlashAttribute("error", "com.Dat109.WasteWise.Entities.Vare ikke funnet");
            return "redirect:/registrer-vare";
        }else {
            //Sender med scannet vare til handlekorg viewet
            Vare vare1 = vare.get();
            redirectAttributes.addFlashAttribute("vare", vare1);
            return "redirect:/legg-til-handlekorg";
        }
    }
}
