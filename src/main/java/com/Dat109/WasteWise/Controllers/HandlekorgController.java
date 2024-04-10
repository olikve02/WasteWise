package com.Dat109.WasteWise.Controllers;

import com.Dat109.WasteWise.Entities.Vare;
import com.Dat109.WasteWise.Services.HandlekorgService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HandlekorgController {


    @GetMapping("/legg-til-handlekorg")
    public String viewleggTilHandlekorg(@ModelAttribute("vare") Vare vare, HttpSession httpSession, Model model){
        System.out.println(httpSession.getAttribute("user"));
        return "LeggTilHandlekorg";
    }

    @PostMapping("/legg-til-handlekorg")
    public String leggTilHandlekorg(@RequestBody Vare vare, RedirectAttributes ra){

        return "redirect:/handlekorg";
    }

    @GetMapping("/handlekorg")
    public String visHandlevogn(){
        return "Handlekorg";
    }
}
