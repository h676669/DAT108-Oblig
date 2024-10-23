package org.example;


import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class deltagerController {
    @PostMapping("/paamelding")
    public String registrerBruker(@RequestParam("fornavn") String fornavn,
                                  @RequestParam("etternavn") String etternavn,
                                  @RequestParam("mbnummer") String mobilnummer,
                                  @RequestParam("password") String password,
                                  @RequestParam("kjonn") Kjonn kjonn,
                                  Model model) {

        if (fornavn == null || fornavn.isEmpty() || fornavn.length() < 2 || fornavn.length() > 20) {
            model.addAttribute("error", "Servant: Fownyavn må OwO væwe mewwom 2 og 20 bokstavew.");
            return "paameldingView";
        }


        if (etternavn == null || etternavn.isEmpty() || etternavn.length() < 2 || etternavn.length() > 20) {
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
        model.addAttribute("success", "Servant: B-Bwukew wegistewt suksessfult!!11");
        model.addAttribute("fornavn", fornavn);
        model.addAttribute("etternavn", etternavn);
        model.addAttribute("mbnummer", mobilnummer);
        model.addAttribute("kjonn", kjonn);
        return "kvitteringView";
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
    public String kvittering(@RequestParam("fornavn") String fornavn,
                             @RequestParam("etternavn") String etternavn,
                             @RequestParam("mbnummer") String mobilnummer,
                             @RequestParam("kjonn") Kjonn kjonn,
                             Model model) {
        model.addAttribute("fornavn", fornavn);
        model.addAttribute("etternavn", etternavn);
        model.addAttribute("mbnummer", mobilnummer);
        model.addAttribute("kjonn", kjonn);

        return "kvitteringView";
    }
}
