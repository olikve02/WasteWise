package com.Dat109.WasteWise.Controllers;

import com.Dat109.WasteWise.Entities.Bruker;
import com.Dat109.WasteWise.Services.BrukerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BrukerController {
    @Autowired
    BrukerService brukerService;
    @GetMapping("/registrer-bruker")
    public String viewRegistrerBruker(Model model){
        model.addAttribute("bruker", new Bruker());
        return "RegistrerBruker";
    }

    @PostMapping("registrer-bruker")
    public String registrerBruker(@ModelAttribute Bruker bruker ){
        brukerService.leggTilBruker(bruker);

        return "redirect:/login";
    }
}
