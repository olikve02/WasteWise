package com.Dat109.WasteWise.Controllers;

import com.Dat109.WasteWise.Entities.User;
import com.Dat109.WasteWise.Services.AvfallPunktService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HjemController {
    @Autowired
    AvfallPunktService avfallPunktService;

    @GetMapping("/home")
    public String visHjem(Model model, HttpSession session) {

        model.addAttribute("avfallpunkt", avfallPunktService.finnAlleAvfallpunkt());
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "Hjemmeside";
    }
}
