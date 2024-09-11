package Oppgave2;

import java.util.Random;

public class Kokk implements Runnable {
    private String Navn;
    private HamburgerBrett brat;
    private Random random = new Random();

    public Kokk(HamburgerBrett brat, String Navn) {
        this.brat = brat;
        this.Navn = Navn;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(2000,6000));
                brat.fraKokk(Navn);
            } catch (InterruptedException e) {
            }
        }
    }
}
