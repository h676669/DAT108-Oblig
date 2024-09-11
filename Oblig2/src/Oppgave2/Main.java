package Oppgave2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;
        skrivUtHeader(kokker, servitorer, KAPASITET);
        HamburgerBrett brett = new HamburgerBrett(KAPASITET);
        for (String navn : kokker) {
            new Thread(new Kokk(brett,navn)).start();
        }
        for (String navn : servitorer) {
            new Thread(new Servitor(brett,navn)).start();
        }
    }
    public static void skrivUtHeader(String[] kokker, String[] servitorer, int cap) {
        System.out.println("I denne simuleringen har vi ");
        System.out.println(kokker.length + " kokker " + Arrays.toString(kokker));
        System.out.println(servitorer.length + " servitører  " + Arrays.toString(servitorer));
        System.out.println("kapasiteten er " + cap + " hamburgere");
        System.out.println("Vi starter ...");

    }
}
