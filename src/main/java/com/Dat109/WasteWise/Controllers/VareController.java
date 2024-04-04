package com.Dat109.WasteWise.Controllers;

import com.Dat109.WasteWise.Services.VareService;
import com.Dat109.WasteWise.Entities.Vare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class VareController {
    @Autowired
    VareService vareService;



    @PostMapping("finnVare")
    public Optional<Vare> finnVare(@RequestBody String barcode){
        return vareService.finnVare(barcode);
    }



}
