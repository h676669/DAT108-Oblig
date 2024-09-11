package Oppgave2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {
    private Queue<Hamburger> Brett;
    private int cap;

    public HamburgerBrett(int cap) {
        this.Brett = new LinkedList<>();
        this.cap = cap;
    }

    public synchronized void fraKokk(String kokkNavn) throws InterruptedException {
        while (Brett.size() > this.cap) {
            System.out.println(kokkNavn + " (kokk) klar med hamburger, men brett fullt. Venter!");
            wait();
        }
        ;
        Hamburger bur = new Hamburger();
        Brett.add(bur);
        System.out.println(kokkNavn + " (kokk) legger på hamburger " + bur.toString() + ". Brett: " + Brett.toString());
        ;
        notifyAll();
    }

    public synchronized void tilServitor(String servitorNavn) throws InterruptedException {
        while (Brett.isEmpty()) {
            System.out.println(servitorNavn + "(servitør) ønsker å ta hamburger, men brett tomt. Venter!");
            wait();
        }
        Hamburger bur = Brett.remove();
        System.out.println(servitorNavn + " (servitør) tar av hamburger " + bur.toString() + ". Brett: " + Brett.toString());
    }
}
