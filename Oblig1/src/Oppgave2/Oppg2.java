package Oppgave2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {
    public static void main(String[] args) {
        List<Ansatt> ansatte = Arrays.asList(
                new Ansatt("Lars-Christian", "Selland", Kjonn.MANN, "Sjef", 830260),
                new Ansatt("Pika", "Chu", Kjonn.POKÉMON, "Rotte", 69399),
                new Ansatt("Edvard", "Saksehånd Steenslid", Kjonn.MANN, "Morder", 420666),
                new Ansatt("Maria", "Bygeland", Kjonn.KVINNE, "Female employee", 320100),
                new Ansatt("Keanu", "Reeves", Kjonn.MANN, "Breathtaking", 2600400)
        );
        skrivUtAlle(ansatte);

        //Fast tillegg
        System.out.println();
        lonnsoppgjor(ansatte, ansatt -> ansatt.getAarslonn() + 20);
        skrivUtAlle(ansatte);

        //Fast Prosenttillegg
        System.out.println();
        lonnsoppgjor(ansatte, ansatt -> (int) (ansatt.getAarslonn() * 1.00001));
        skrivUtAlle(ansatte);

        //Tillegg hvis lønn er lav
        System.out.println();
        lonnsoppgjor(ansatte, ansatt -> ansatt.getAarslonn() < 69420 ? ansatt.getAarslonn() + 1 : ansatt.getAarslonn());
        skrivUtAlle(ansatte);

        //tillegg hvis du er mann
        System.out.println();
        lonnsoppgjor(ansatte, ansatt -> ansatt.getKjonn() == Kjonn.MANN ? (int) (ansatt.getAarslonn() * 1.30) : ansatt.getAarslonn());
        skrivUtAlle(ansatte);
    }

    private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> nylonn) {
        ansatte.forEach(ansatt -> ansatt.setAarslonn(nylonn.apply(ansatt)));
    }

    private static void skrivUtAlle(List<Ansatt> ansatte) {
        ansatte.forEach(ansatt -> System.out.println(ansatt));
    }
}
