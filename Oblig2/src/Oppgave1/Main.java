package Oppgave1;
import javax.swing.JOptionPane;

public class Main {
    public static String Melding;
    public static boolean Kjorrer;
    public static void main(String[] args) {
        Melding = "Hallo Verden!";
        Kjorrer = true;
        Thread skrivUtMelding = new Thread(){
            @Override
            public void run(){
                while(Kjorrer){
                    try {
                        Thread.sleep(3000);
                        if(!Kjorrer){
                            break;
                        }
                        System.out.println(Melding);
                    } catch(InterruptedException e){}
                }
            }
        };
        Thread velgMelding = new Thread(){
            @Override
            public void run(){
                while(Kjorrer){
                    Melding = javax.swing.JOptionPane.showInputDialog("Skriv inn melding din, skriv quit for å avslutte");
                    if(Melding.equals("quit")){
                        Kjorrer = false;
                    }
                }
            }
        };
        velgMelding.start();
        skrivUtMelding.start();

        try {
            skrivUtMelding.join();
            velgMelding.join();
        } catch (InterruptedException e) {
        }
    }
}
