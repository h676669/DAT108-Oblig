package Oppgave1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class oppg1a {
    public static void main(String[] args) {
        List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");
        Collections.sort(listen, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));
        System.out.println(listen);
    }
}
