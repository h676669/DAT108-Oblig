package util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class loginUtil {
    public static void loggUtBruker(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
    }

    public static void loggInnBruker(HttpServletRequest request) {

        //NB!
        loggUtBruker(request.getSession());

        HttpSession sesjon = request.getSession();
        //sesjon.setAttribute();
        sesjon.setMaxInactiveInterval(60); //sekunder
    }

    public static boolean erBrukerInnlogget(HttpSession session) {
        return session != null && session.getAttribute("username") != null;
    }
}
