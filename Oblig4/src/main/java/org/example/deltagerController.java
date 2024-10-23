package org.example;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class deltagerController {
    @PostMapping("/paamelding")
    public String registrerBruker(@RequestParam("fornavn") String fornavn,
                                  @RequestParam("etternavn") String etternavn,
                                  @RequestParam("mbnummer") String mobilnummer,
                                  @RequestParam("password") String password,
                                  @RequestParam("kjonn") Kjonn kjonn,
                                  Model model, RedirectAttributes redirectAttributes) {

        if (fornavn == null || fornavn.length() < 2 || fornavn.length() > 20) {
            model.addAttribute("error", "Servant: Fownyavn må OwO væwe mewwom 2 og 20 bokstavew.");
            return "paameldingView";
        }


        if (etternavn == null || etternavn.length() < 2 || etternavn.length() > 20) {
            model.addAttribute("error", "Servant: E-E-Ettewnyavn må OwO væwe mewwom 2 og 20 bokstavew.");
            return "paameldingView";
        }


        if (!mobilnummer.matches("^[1-9]\\d{7}$")) {
            model.addAttribute("error", "Servant: Mobiwnyummew må OwO væwe nøyaktig 8 siffew og kan ikke starte med 0.");
            return "paameldingView";
        }


        if (password == null || password.length() < 8) {
            model.addAttribute("error", "Servant: Passowd må OwO væwe minst 8 tegn.");
            return "paameldingView";
        }
        redirectAttributes.addFlashAttribute("success", "Servant: B-Bwukew wegistewt suksessfult!!11");
        redirectAttributes.addFlashAttribute("kjonn", kjonn);
        redirectAttributes.addFlashAttribute("fornavn", fornavn);
        redirectAttributes.addFlashAttribute("etternavn", etternavn);
        redirectAttributes.addFlashAttribute("mobilnummer", mobilnummer);
        redirectAttributes.addFlashAttribute("password", password);
        return "redirect:/kvittering";
    }

    @GetMapping("/paamelding")
    public String paamelding(){
        return "paameldingView";
    }
    @GetMapping("/deltagerliste")
    public String deltagerliste(){
        return "deltagerlistView";
    }
    @GetMapping("/kvittering")
    public String kvittering(Model model) {
        return "kvitteringView";
    }
}
