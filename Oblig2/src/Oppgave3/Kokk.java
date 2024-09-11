package Oppgave3;

import Oppgave2.Hamburger;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Kokk implements Runnable {
    private String navn;
    private BlockingQueue<Hamburger> brat;
    private Random random = new Random();

    public Kokk(BlockingQueue<Hamburger>brat, String Navn) {
        this.brat = brat;
        this.navn = Navn;
    }


    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(2000,6000));  // Simulate time to prepare a hamburger
                Hamburger hamburger = new Hamburger();
                brat.put(hamburger);  // Blocking if the queue is full
                System.out.println(navn + " (kokk) legger på hamburger " + hamburger.toString() + ". Brett: " + brat.toString());
            }
        } catch (InterruptedException e) {
        }
    }
}
