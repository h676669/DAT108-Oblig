package Oblig4.controller;


import Oblig4.model.Deltager;
import Oblig4.model.Deltagere;
import Oblig4.model.Passord;
import Oblig4.service.PassordService;
import Oblig4.util.loginUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    private final PassordService passordService = new PassordService();

    @GetMapping("/paamelding")
    public String paamelding(Model model) {
        model.addAttribute("deltager", new Deltager());
        return "paameldingView";
    }

    @PostMapping("/paamelding")
    public String registrerBruker(@ModelAttribute("deltager") Deltager deltager,@RequestParam("passord")String passord, RedirectAttributes redirectAttributes, HttpServletRequest request) {

        String ValiderValidering = ValiderBruker(deltager,passord);
        if (ValiderValidering != null) {
            redirectAttributes.addFlashAttribute("error", ValiderValidering);
            return "redirect:/paamelding";
        }

        deltager.setPassord(deltager.getPassord().getHash());

        if (!deltagere.leggTilDeltager(deltager)) {
            redirectAttributes.addFlashAttribute("error", "Mobilnummeret er allerede registrert.");
            return "redirect:/paamelding";
        }

        redirectAttributes.addFlashAttribute("deltager", deltager);
        redirectAttributes.addFlashAttribute("success", "Servant: B-Bwukew wegistewt suksessfult!!11");
        loginUtil.loggInnBruker(request, deltager);
        System.out.println("Fornavn: " + deltager.getFornavn());
        System.out.println("Etternavn: " + deltager.getEtternavn());
        return "redirect:/kvittering";
    }

    @GetMapping("/deltagerliste")
    public String deltagerliste(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        if (!loginUtil.erBrukerInnlogget(session)){
            redirectAttributes.addFlashAttribute("error", "Du er logget ut");
            return "redirect:/login";
        }
        model.addAttribute("deltagerliste", deltagere.getDeltagerliste());
        //deltagere.skrivUtDeltagere();
        return "deltagerlisteView";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "loginView";
    }

    @PostMapping("/login")
    public String loginBruker(@RequestParam("mobil") String mobil, @RequestParam("passord") String passord, RedirectAttributes redirectAttributes, HttpServletRequest request) {

        Deltager lagretDeltager= deltagere.deltagerMedMobilnummer(mobil);
        if (lagretDeltager == null) {
            return "redirect:/login";
        }
        Passord lagretDeltagerPassord = lagretDeltager.getPassord();
        System.out.println("PlainTextpassord " + passord);
        System.out.println("Passord fra database " + lagretDeltagerPassord);

        if(!passordService.erKorrektPassord(passord, lagretDeltagerPassord.getSalt(), lagretDeltagerPassord.getHash())){
            redirectAttributes.addFlashAttribute("error", "Ugyldig brukernavn og/eller passord");
            System.out.println("Mobilnummer: " + lagretDeltager.getMobil());
            return "redirect:/login";
        }
        loginUtil.loggInnBruker(request, lagretDeltager);
        redirectAttributes.addFlashAttribute("deltager", lagretDeltager);
        System.out.println("Bruker " + lagretDeltager.getMobil() + " Logget Inn");
        System.out.println("Fornavn: " + lagretDeltager.getFornavn());
        System.out.println("Etternavn: " + lagretDeltager.getEtternavn());
        return "redirect:/deltagerliste";
    }

    @PostMapping("/logout")
    public String logUt(HttpSession session, RedirectAttributes redirectAttributes) {
        loginUtil.loggUtBruker(session);
        redirectAttributes.addFlashAttribute("error", "Du er logget ut");
        System.out.println(session);
        return "redirect:/login";
    }

    @GetMapping("/kvittering")
    public String kvittering(HttpSession session) {
        if (!loginUtil.erBrukerInnlogget(session)){
            return "redirect:/login";
        }
        return "kvitteringView";
    }

    private String ValiderBruker(Deltager deltager, String passord) {
        if (deltager.getFornavn() == null || deltager.getFornavn().length() < 2 || deltager.getFornavn().length() > 20) {
            return "Servant: Fownyavn må OwO væwe mewwom 2 og 20 bokstavew.";
        }
        if (deltager.getEtternavn() == null || deltager.getEtternavn().length() < 2 || deltager.getEtternavn().length() > 20) {
            return "Servant: E-E-Ettewnyavn må OwO væwe mewwom 2 og 20 bokstavew.";
        }
        if (deltager.getMobil() == null || !deltager.getMobil().matches("^[1-9]\\d{7}$")) {
            return "Servant: Mobiwnyummew må OwO væwe nøyaktig 8 siffew og kan ikke starte med 0.";
        }

        if ((deltager.getPassord() == null || passord == null)|| passord.length() < 8) {
            return "Servant: Passowd må OwO væwe minst 8 tegn.";
        }
        return null;
    }
}
