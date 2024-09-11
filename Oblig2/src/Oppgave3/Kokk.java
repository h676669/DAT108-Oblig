package Oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Kokk implements Runnable {
    private String Navn;
    private BlockingQueue<Hamburger> brat;
    private Random random = new Random();

    public Kokk(BlockingQueue<Hamburger>brat, String Navn) {
        this.brat = brat;
        this.Navn = Navn;
    }


    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((int) (Math.random() * 4000) + 2000);  // Simulate time to prepare a hamburger
                Hamburger hamburger = new Hamburger();
                brat.put(hamburger);  // Blocking if the queue is full
                System.out.println(Navn + " (kokk) legger på hamburger " + hamburger + ". Brett: " + brat.size() + "/" + brat.remainingCapacity());
            }
        } catch (InterruptedException e) {
        }
    }
}
