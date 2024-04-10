package com.Dat109.WasteWise.Controllers;

import com.Dat109.WasteWise.Entities.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HjemController {


    @GetMapping("/home")
    public String visHjem(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "Hjemmeside";
    }
}
