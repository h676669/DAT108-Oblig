package org.example;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class deltagerController {

    private final Deltagere deltagere = new Deltagere();

    @GetMapping("/paamelding")
    public String paamelding(Model model) {
        model.addAttribute("deltager", new Deltager());
        return "paameldingView";
    }

    @PostMapping("/paamelding")
    public String registrerBruker(@ModelAttribute("deltager") Deltager deltager, Model model, RedirectAttributes redirectAttributes) {

        String ValiderValidering = ValiderBruker(deltager);
        if (ValiderValidering != null) {
            redirectAttributes.addFlashAttribute("error", ValiderValidering);
            return "redirect:/paamelding";
        }
        if (!deltagere.leggTilDeltager(deltager)) {
            redirectAttributes.addFlashAttribute("error", "Mobilnummeret er allerede registrert.");
            return "redirect:/paamelding";
        }

        redirectAttributes.addFlashAttribute("deltager", deltager);
        redirectAttributes.addFlashAttribute("success", "Servant: B-Bwukew wegistewt suksessfult!!11");
        System.out.println("Fornavn: " + deltager.getFornavn());
        System.out.println("Etternavn: " + deltager.getEtternavn());
        return "redirect:/kvittering";
    }

    @GetMapping("/deltagerliste")
    public String deltagerliste(Model model) {
        model.addAttribute("deltagerliste", deltagere.getDeltagerliste());
        return "deltagerlisteView";
    }

    @GetMapping("/kvittering")
    public String kvittering() {
        return "kvitteringView";
    }

    private String ValiderBruker(Deltager deltager) {
        if (deltager.getFornavn() == null || deltager.getFornavn().length() < 2 || deltager.getFornavn().length() > 20) {
            return "Servant: Fownyavn må OwO væwe mewwom 2 og 20 bokstavew.";
        }
        if (deltager.getEtternavn() == null || deltager.getEtternavn().length() < 2 || deltager.getEtternavn().length() > 20) {
            return "Servant: E-E-Ettewnyavn må OwO væwe mewwom 2 og 20 bokstavew.";
        }
        if (deltager.getMobil() == null || !deltager.getMobil().matches("^[1-9]\\d{7}$")) {
            return "Servant: Mobiwnyummew må OwO væwe nøyaktig 8 siffew og kan ikke starte med 0.";
        }
        if (deltager.getPassord() == null || deltager.getPassord().length() < 8) {
            return "Servant: Passowd må OwO væwe minst 8 tegn.";
        }
        return null;
    }
}
