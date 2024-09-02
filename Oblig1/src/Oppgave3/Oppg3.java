package Oppgave3;

import Oppgave2.Ansatt;
import Oppgave2.Kjonn;

import java.util.*;
import java.util.stream.IntStream;

public class Oppg3 {
    public static void main(String[] args) {
        List<Oppgave2.Ansatt> ansatte = Arrays.asList(
                new Oppgave2.Ansatt("Lars-Christian", "Selland", Kjonn.MANN, "Sjef", 830260),
                new Oppgave2.Ansatt("Pika", "Chu", Kjonn.POKÉMON, "SjefsRotte", 69399),
                new Oppgave2.Ansatt("Eduard", "Laksehånd Steenslid", Kjonn.MANN, "Morder", 420666),
                new Oppgave2.Ansatt("Maria", "Bygeland", Kjonn.KVINNE, "Female employee", 320100),
                new Ansatt("Keanu", "Reeves", Kjonn.MANN, "Breathtaking", 2600400)
        );

        //Skriver ut en liste med etternavnene til de ansatte.
        List<String> etternavnListe = ansatte.stream().map(Ansatt::getEtternavn).toList();
        System.out.println("Etternavnene til de ansatte: " + etternavnListe);
        System.out.println();

        //Finner antall kvinner.
        int antallKvinner = (int) ansatte.stream().filter(p -> p.getKjonn() == Kjonn.KVINNE).count();
        System.out.println("Antall Kvinner: " + antallKvinner);
        System.out.println();

        //finner gjennomsnittslønnen til kvinner.
        double avgKvinnelonn = ansatte.stream().filter(p -> p.getKjonn() == Kjonn.KVINNE).mapToDouble(Ansatt::getAarslonn).average().orElse(0.0);
        System.out.println("Gjennomsnittlig kvinnelønn: " + avgKvinnelonn);
        System.out.println();

        //Gir en lønnsøkning på 7% til alle sjefer
        ansatte.stream().filter(p -> p.getStilling().contains("Sjef")).peek(p -> System.out.println("Før lønnsøkning: " + p)).forEach(p -> {
            p.setAarslonn(p.getAarslonn() * 1.07);
            System.out.println("Etter lønnsøkning: " + p);
        });
        System.out.println();


        //Skriv ut alle ansatte med sout uten å bruke løkke.
        System.out.println("Liste over ansatte skrevet ut uten for-løkke:");
        ansatte.forEach(System.out::println);
        System.out.println();

        //True False om det finnes ansatte som tjener mer enn 800.000,-
        System.out.println("Finnes det ansatte med lønn over 800.000,- ?: " + ansatte.stream().anyMatch(p -> p.getAarslonn() > 800000));
        System.out.println();

        //Finner den/de ansatte med laveste lønn
        List<Ansatt> lavesteLonn = ansatte.stream().min(Comparator.comparing(Ansatt::getAarslonn)).stream().toList();
        System.out.println("Den/de ansatte med laveste lønn: " + lavesteLonn);
        System.out.println();

        //Finn summen av alle heltall i [1,1000> som er delelig med 3 eller 5.
        int sumAvHeltall = IntStream.range(1, 1000).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
        System.out.println("Sum: " + sumAvHeltall);
    }
}
