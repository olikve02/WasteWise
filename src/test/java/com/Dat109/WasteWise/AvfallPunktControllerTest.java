package com.Dat109.WasteWise;

import com.Dat109.WasteWise.Controllers.AvfallPunktController;
import com.Dat109.WasteWise.Entities.AvfallPunkt;
import com.Dat109.WasteWise.Services.AvfallPunktService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AvfallPunktControllerTest {

    @Mock
    private AvfallPunktService avfallPunktService;

    @Mock
    private Model model;

    @Mock
    private RedirectAttributes redirectAttributes;

    @InjectMocks
    private AvfallPunktController controller;

//    @Test
//    public void testFinnNaermestAvfallPunkt() {
//
//        String currentPosition = "User's Current Position";
//
//        AvfallPunkt naermestAvfallPunkt = new AvfallPunkt();
//        naermestAvfallPunkt.setNavn("Nearest AvfallPunkt");
//        naermestAvfallPunkt.setAdresse("Address of Nearest AvfallPunkt");
//        when(avfallPunktService.finnNaermestAvfallpunkt(currentPosition)).thenReturn(naermestAvfallPunkt);
//
//        String viewName = controller.finnNaermestAvfallpunkt(currentPosition, model, redirectAttributes);
//
//        assertEquals("NearestAvfallPunktView", viewName);
//
//        verify(model, times(1)).addAttribute("avfallPunkt", naermestAvfallPunkt);
//    }
}