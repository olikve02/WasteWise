package com.Dat109.WasteWise.Controllers;

import com.Dat109.WasteWise.Entities.Vare;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HandlekorgController {


    @GetMapping("/legg-til-handlekorg")
    public String viewleggTilHandlekorg(@ModelAttribute("vare") Vare vare){
        return "LeggTilHandlekorg";
    }

    @PostMapping("/legg-til-handlekorg")
    public String leggTilHandlekorg(@ModelAttribute("vare") Vare vare){
        System.out.println(vare.getNavn());
        return "";
    }
}
