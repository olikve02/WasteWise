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
        return vareService.finnVareOgRedirect(strekkodeRaw, redirectAttributes);
    }
}
