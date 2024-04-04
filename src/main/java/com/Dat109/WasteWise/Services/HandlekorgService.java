package com.Dat109.WasteWise.Services;

import com.Dat109.WasteWise.Entities.Handlevogn;
import com.Dat109.WasteWise.Repositories.HandlevognRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandlekorgService {
    @Autowired
    HandlevognRepo handlevognRepo;

    public void leggTilHandlevogn(Handlevogn handlevogn){
        handlevognRepo.save(handlevogn);
    }
}
