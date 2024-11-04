package Oblig4.util;

import Oblig4.model.Deltager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class loginUtil {
    public static void loggUtBruker(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
    }

    public static void loggInnBruker(HttpServletRequest request, Deltager deltager) {

        //NB!
        loggUtBruker(request.getSession());

        HttpSession sesjon = request.getSession();
        sesjon.setAttribute("deltager", deltager);
        sesjon.setMaxInactiveInterval(60); //sekunder
    }

    public static boolean erBrukerInnlogget(HttpSession session) {
        return session != null && session.getAttribute("deltager") != null;
    }
}
