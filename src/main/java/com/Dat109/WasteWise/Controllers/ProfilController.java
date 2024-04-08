package com.Dat109.WasteWise.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfilController {


    @GetMapping("/profil")
    public String visProfil() {


        return "Profil";
    }
}
