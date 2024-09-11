package Oppgave2;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {
    private Queue<Hamburger> Brett;
    private int cap;

    public HamburgerBrett(int cap){
        this.Brett = new LinkedList<>();
        this.cap = cap;
    }

    public synchronized void fraKokk(String kokkNavn) throws InterruptedException {
        while(Brett.size() > this.cap){
            System.out.println(kokkNavn + " kan ikkje legge til hamburger, er fullt");
            wait();
        };
        Hamburger bur = new Hamburger();
        Brett.add(bur);
        System.out.println(kokkNavn +"(kokk) la til "+bur.toString());
        notifyAll();
    }
    public synchronized void tilServitor(String servitorNavn) throws InterruptedException {
        while(Brett.isEmpty()){
            System.out.println(servitorNavn + " kan ikkje ta en hamburger, er tomt");
            wait();
        }
        Hamburger bur = Brett.remove();
        System.out.println(servitorNavn +"(servitor) tok " + bur.toString());
    }
}
