package com.Dat109.WasteWise;

import com.Dat109.WasteWise.Controllers.AvfallPunktController;
import com.Dat109.WasteWise.Entities.AvfallPunkt;
import com.Dat109.WasteWise.Repositories.AvfallPunktRepo;
import com.Dat109.WasteWise.Services.AvfallPunktService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

 @SpringBootTest
public class AvfallPunktControllerTest {

    @Mock
    private Model model;

    @Mock
    private RedirectAttributes redirectAttributes;

    @InjectMocks
    private AvfallPunktController controller;

    @Mock
    private AvfallPunktRepo avfallPunktRepo;

    @InjectMocks
    private AvfallPunktService avfallPunktService;


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
    @Test
    public void testLeggTilAvfallPunkt() {
        // Arrange
        String navn = "Test avfallspunkt";
        String adresse = "Test adresse";
        AvfallPunkt avfallPunkt = new AvfallPunkt(navn, adresse);

        avfallPunktService.leggTilAvfallPunkt(avfallPunkt);

        verify(avfallPunktRepo).save(avfallPunkt);
    }

    @Test
    public void testFinnAlleAvfallpunkt() {
        List<AvfallPunkt> avfallPunkter = List.of(
                new AvfallPunkt("Avfallspunkt 1", "Adresse 1"),
                new AvfallPunkt("Avfallspunkt 2", "Adresse 2")
        );
        when(avfallPunktRepo.findAll()).thenReturn(avfallPunkter);

        List<AvfallPunkt> result = avfallPunktService.finnAlleAvfallpunkt();

        assertEquals(avfallPunkter.size(), result.size());
        assertEquals(avfallPunkter, result);
    }

}





