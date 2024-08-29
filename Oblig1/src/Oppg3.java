import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Oppg3 {

    public static void main(String[] args) {
        List<Ansatt> ansattListe = Arrays.asList(
                new Ansatt("Truls", "Birger", "Kommandør", Kjonn.BODY_TYPE_1, 100 ),
                new Ansatt("Tond", "Atle", "Vaktmester", Kjonn.BODY_TYPE_2, 999999),
                new Ansatt("Rune", "Burgerleif", "Anime expert", Kjonn.BODY_TYPE_2, 99),
                new Ansatt("Kevin", "James", "Skodespelar", Kjonn.BODY_TYPE_1, 249),
                new Ansatt("Kong", "Harald", "Top guy", Kjonn.BODY_TYPE_1, 30)
        );
        // a
        List<String> etternavnListe = ansattListe.stream().map(Ansatt::getEtternavn).collect(Collectors.toList());
        System.out.println(etternavnListe);
        System.out.println();

        // b
        int antallKvinner = (int)ansattListe.stream().filter(a -> a.getKjonn() == Kjonn.BODY_TYPE_2).count();
        System.out.println("Antall kvinner: " + antallKvinner);
        System.out.println();

        // c
        double gjennomSnittlonnKvinner = ansattListe.stream().filter(a -> a.getKjonn() == Kjonn.BODY_TYPE_2).mapToDouble(a -> a.getAarslonn()).average().getAsDouble();
        System.out.println("Gjennomsnittslønn for kvinner: " + gjennomSnittlonnKvinner);
        System.out.println();

        // d
        ansattListe.stream().filter(ansatt -> ansatt.getStilling().contains("sjef")).forEach(a -> a.setAarslonn(a.getAarslonn() * 1.07));
        skrivUtAlle(ansattListe); // har ingen sjefer så ingen får lønnsøkning...
        System.out.println();

        // e
        System.out.println("Tjener noen mer enn 800.000,-?");
        //ansattListe.stream().filter(a -> a.getAarslonn() > 800000).forEach(System.out::println); // Hvem tjener mer en 800000
        System.out.println(ansattListe.stream().anyMatch(ansatt -> ansatt.getAarslonn() > 800000));
        System.out.println();

        // f
        ansattListe.forEach(System.out::println);
        System.out.println();

        // g
        System.out.println("Lavest lønn: ");
        ansattListe.stream().min(Comparator.comparing(Ansatt::getAarslonn)).stream().forEach(System.out::println);
        System.out.println();

        // h
        System.out.println("Sum av alle heltall fra 1 til og ikke med 1000 som er delelig med 3 eller 5: ");
        System.out.println(IntStream.range(1, 1000).filter(i -> i % 3 == 0 || i % 5 == 0).sum());
    }

    private static void skrivUtAlle(List<Ansatt> ansattListe) {
        System.out.println();
        ansattListe.forEach(System.out::println);
    }
}
