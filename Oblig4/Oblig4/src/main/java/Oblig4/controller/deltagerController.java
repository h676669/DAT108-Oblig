package Oblig4.controller;

import Oblig4.model.Deltager;
import Oblig4.service.DeltagerService;
import Oblig4.service.PassordService;
import Oblig4.util.loginUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class deltagerController {

    @Autowired
    private DeltagerService deltagerService;

    @Autowired
    private PassordService passordService;

    @GetMapping("/paamelding")
    public String paamelding(Model model) {
        model.addAttribute("deltager", new Deltager());
        return "paameldingView";
    }

    @PostMapping("/paamelding")
    public String registrerBruker(@ModelAttribute("deltager") Deltager deltager,
                                  @RequestParam("passord") String passord,
                                  RedirectAttributes redirectAttributes,
                                  HttpServletRequest request) {

        String validering = validerBruker(deltager, passord);
        if (validering != null) {
            redirectAttributes.addFlashAttribute("error", validering);
            return "redirect:/paamelding";
        }

        deltager.setPassord(passord);

        if (!deltagerService.leggTilDeltager(deltager)) {
            redirectAttributes.addFlashAttribute("error", "Mobilnummeret er allerede registrert.");
            return "redirect:/paamelding";
        }

        redirectAttributes.addFlashAttribute("deltager", deltager);
        redirectAttributes.addFlashAttribute("success", "Servant: Bruker registrert suksessfullt!!11");
        loginUtil.loggInnBruker(request, deltager);
        return "redirect:/kvittering";
    }

    @GetMapping("/deltagerliste")
    public String deltagerliste(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        if (!loginUtil.erBrukerInnlogget(session)) {
            redirectAttributes.addFlashAttribute("error", "Du er logget ut");
            return "redirect:/login";
        }
        model.addAttribute("deltagerliste", deltagerService.getAllDeltagere());
        return "deltagerlisteView";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "loginView";
    }

    @PostMapping("/login")
    public String loginBruker(@RequestParam("mobil") String mobil,
                              @RequestParam("passord") String passord,
                              RedirectAttributes redirectAttributes,
                              HttpServletRequest request) {

        Deltager lagretDeltager = deltagerService.getDeltagerByMobil(mobil);
        if (lagretDeltager == null) {
            redirectAttributes.addFlashAttribute("error", "Ugyldig brukernavn og/eller passord");
            return "redirect:/login";
        }

        String lagretHash = lagretDeltager.getPassord().getHash();
        String lagretSalt = lagretDeltager.getPassord().getSalt();

        if (!passordService.erKorrektPassord(passord, lagretSalt, lagretHash)) {
            redirectAttributes.addFlashAttribute("error", "Ugyldig brukernavn og/eller passord");
            return "redirect:/login";
        }

        loginUtil.loggInnBruker(request, lagretDeltager);
        redirectAttributes.addFlashAttribute("deltager", lagretDeltager);
        return "redirect:/deltagerliste";
    }

    @PostMapping("/logout")
    public String logUt(HttpSession session, RedirectAttributes redirectAttributes) {
        loginUtil.loggUtBruker(session);
        redirectAttributes.addFlashAttribute("error", "Du er logget ut");
        return "redirect:/login";
    }

    @GetMapping("/kvittering")
    public String kvittering(HttpSession session) {
        if (!loginUtil.erBrukerInnlogget(session)) {
            return "redirect:/login";
        }
        return "kvitteringView";
    }

    /**
     * Validates user input for participant registration.
     *
     * @param deltager Participant object
     * @param passord  Password entered
     * @return Error message if validation fails, otherwise null.
     */
    private String validerBruker(Deltager deltager, String passord) {
        if (deltager.getFornavn() == null || deltager.getFornavn().length() < 2 || deltager.getFornavn().length() > 20) {
            return "Servant: Fornavn må være mellom 2 og 20 bokstaver.";
        }
        if (deltager.getEtternavn() == null || deltager.getEtternavn().length() < 2 || deltager.getEtternavn().length() > 20) {
            return "Servant: Etternavn må være mellom 2 og 20 bokstaver.";
        }
        if (deltager.getMobil() == null || !deltager.getMobil().matches("^[1-9]\\d{7}$")) {
            return "Servant: Mobilnummer må være nøyaktig 8 sifre og kan ikke starte med 0.";
        }

        if (passord == null || passord.length() < 8) {
            return "Servant: Passord må være minst 8 tegn.";
        }
        return null;
    }
}


