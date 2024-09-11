package Oppgave1;

public class Main {
    public static String Melding;
    public static boolean runs;
    public static void main(String[] args) {
        Melding = "Hallo Verden!";
        runs = true;
        Thread skrivUtMelding = new Thread(){
            @Override
            public void run(){
                while(runs){
                    try {
                        Thread.sleep(3000);
                        if(!runs){
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
                while(runs){
                    Melding = javax.swing.JOptionPane.showInputDialog("Skriv inn melding din, skriv quit for å avslutte");
                    if(Melding == null){
                        runs = false;
                    }
                    else if(Melding.equalsIgnoreCase("quit")){
                        runs = false;
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
