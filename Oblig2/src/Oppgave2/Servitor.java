package Oppgave2;

import java.util.Random;

public class Servitor implements Runnable {
    private String Navn;
    private HamburgerBrett brat;
    private Random random = new Random();

    public Servitor(HamburgerBrett brat, String Navn) {
        this.brat = brat;
        this.Navn = Navn;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(2000, 6000));
                brat.tilServitor(Navn);
            } catch (InterruptedException e) {
            }
        }
    }
}
