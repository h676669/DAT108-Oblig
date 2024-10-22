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

}
