package Oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Servitor implements Runnable {
    private final BlockingQueue<Hamburger> brett;
    private final String navn;
    private Random random = new Random();

    public Servitor(BlockingQueue<Hamburger> brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(2000,6000));
                Hamburger hamburger = brett.take();  // Blocking if the queue is empty
                System.out.println(navn + " (servitør) tar av hamburger " + hamburger + ". Brett: " + brett.size() + "/" + brett.remainingCapacity());
            }
        } catch (InterruptedException e) {
        }
    }
}
