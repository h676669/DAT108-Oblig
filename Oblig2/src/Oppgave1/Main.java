package Oppgave1;
import javax.swing.JOptionPane;

public class Main {
    public static String Melding;
    public static void main(String[] args) {
        Melding = "Hallo Verden!";
        Thread skrivUtMelding = new Thread(){
            @Override
            public void run(){
                while(!Melding.equals("quit")){
                    try{
                        Thread.sleep(3000);
                        if(Melding.equals("quit")){
                            break;
                        }
                        System.out.println(Melding);
                    }catch(InterruptedException e){}
                }
            }
        };
        Thread velgMelding = new Thread(){
            @Override
            public void run(){
                while(!Melding.equals("quit")){
                    Melding = javax.swing.JOptionPane.showInputDialog("Skriv inn melding din, skriv quit for å avslutte");
                }
            }
        };
        velgMelding.start();
        skrivUtMelding.start();
    }
}
