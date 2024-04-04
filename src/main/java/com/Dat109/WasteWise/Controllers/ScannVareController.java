package com.Dat109.WasteWise.Controllers;


import com.Dat109.WasteWise.Services.VareService;
import com.Dat109.WasteWise.Entities.Vare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ScannVareController {

    @GetMapping("/scann-vare")
    public String scanVare(){
        return "ScannVare";
    }

    @Autowired
    VareService vareService;
    @PostMapping("/scann-vare")
    public String finnVare(@RequestBody MultiValueMap<String, String> strekkodeRaw, RedirectAttributes redirectAttributes){
        //Konverterer fra json til string
        String strekkode = strekkodeRaw.getFirst("strekkode");
        //Søker etter varen i databasen
        Optional<Vare> vare = vareService.finnVare(strekkode);
        //Sender bruker til riktig view ettersom varen blir funnet eller ikke
        if(!vare.isPresent()){
            redirectAttributes.addFlashAttribute("error", "com.Dat109.WasteWise.Entities.Vare ikke funnet");
            return "redirect:/scann-vare";
        }else {
            //Sender med scannet vare til handlekorg viewet
            Vare vare1 = vare.get();
            redirectAttributes.addFlashAttribute("vare", vare1);
            return "redirect:/legg-til-handlekorg";
        }
    }
}
