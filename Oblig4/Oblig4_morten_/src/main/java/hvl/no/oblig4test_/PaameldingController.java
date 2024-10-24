package hvl.no.oblig4test_;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PaameldingController {

    private List<Deltager> deltagere = new ArrayList<>();

    // Deltagere til testing av deltagerliste
    @PostConstruct
    public void init() {
        deltagere.add(new Deltager("Arne", "Trolldeig", "80808080", "ostepopp", "kvinne"));
        deltagere.add(new Deltager("Jan", "Brunost", "80808081", "ostepopp", "kvinne"));
        deltagere.add(new Deltager("Lars-Petter", "Uchiha", "80808082", "ostepopp", "mann"));
        deltagere.add(new Deltager("Donald", "Trump", "80808083", "ostepopp", "mann"));
        deltagere.add(new Deltager("Donald", "Turnip", "80808084", "ostepopp", "mann"));
    }

    @GetMapping("/paamelding")
    public String paamelding(Model model) {
        model.addAttribute("deltager", new Deltager());
        return "paamelding";
    }

    @GetMapping("/deltagerliste")
    public String deltagerliste(Model model) {
        model.addAttribute("deltagere", deltagere);
        return "deltagerliste";
    }

    @PostMapping("/registrer")
    public String paaMelding(@Valid Deltager deltager, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (deltagere.stream().anyMatch(paaMeldtDeltager -> paaMeldtDeltager.getMobil().equals(deltager.getMobil()))) {
            bindingResult.rejectValue("mobil","mobil", "Mobilnummer allerede registrert.");
        }

        if (!deltager.getPassord().equals(deltager.getRepetertPassord())) {
            bindingResult.rejectValue("repetertPassord","passord", "Passord matcher ikke.");
        }
        if (bindingResult.hasErrors()) {
            List<String> feilmeldinger = bindingResult.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage()).toList();

            model.addAttribute("feilmeldinger", feilmeldinger);
            model.addAttribute("deltager", deltager);
            return "paamelding";
        }
        deltagere.add(deltager);
        redirectAttributes.addFlashAttribute("deltager", deltager);
        return "redirect:/paameldt";
    }

    @GetMapping("/paameldt")
    public String paameldt(Model model) {
        return "paameldt";
    }
}
