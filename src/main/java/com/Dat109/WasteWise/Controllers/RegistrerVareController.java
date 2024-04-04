package com.Dat109.WasteWise.Controllers;

import com.Dat109.WasteWise.Services.VareService;

import com.Dat109.WasteWise.Entities.Vare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrerVareController {
    @Autowired
    VareService vareService;

    @GetMapping("/registrer-vare")
    public String scan(Model model){
        model.addAttribute("vare", new Vare());
        return "RegistrerVare";
    }
    @PostMapping("/registrer-vare")
    public String leggTilVare(@ModelAttribute Vare vare){
        vareService.leggTilVare(vare);
        return "redirect:/registrer-vare";
    }
}
