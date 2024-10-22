package org.example;


import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class deltagerController {

    @GetMapping("/paamelding")
    public String paamelding(){
        return "paamelding";
    }
    @GetMapping("/deltagerliste")
    public String deltagerliste(){
        return "deltagerliste";
    }
    @GetMapping("/kvittering")
    public String kvittering(String fornavn, String etternavn,
                             String mbunmmer, String kjonn, Model model ){
        model.addAttribute("fornavn", fornavn);
        model.addAttribute("etternavn", etternavn);
        model.addAttribute("mbunmmer", mbunmmer);
        model.addAttribute("kjonn", kjonn);

        return "kvittering";
    }

}
