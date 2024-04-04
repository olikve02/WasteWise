package com.Dat109.WasteWise.Controllers;

import com.Dat109.WasteWise.Entities.AvfallPunkt;
import com.Dat109.WasteWise.Services.AvfallPunktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AvfallPunktController {
    @Autowired
    AvfallPunktService avfallPunktService;

    @GetMapping("/legg-til-avfall-punkt")
    public String viewLeggTilAvfallPunkt(Model model){
        model.addAttribute(new AvfallPunkt());
        return "/LeggTilAvfallPunkt";
    }
    @PostMapping("legg-til-avfall-punkt")
    public String leggTilAvfallPunkt(@ModelAttribute("avfallpunkt")AvfallPunkt avfallPunkt){
        avfallPunktService.leggTilAvfallPunkt(avfallPunkt);
        return "redirect:/legg-til-avfall-punkt";
    }
}
