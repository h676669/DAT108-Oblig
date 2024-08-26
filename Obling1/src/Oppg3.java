import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Oppg3 {

    public static void main(String[] args) {
        List<Ansatt> ansattListe = Arrays.asList(
                new Ansatt("Truls", "Birger", "Kommandør", Kjonn.BODY_TYPE_1, 100 ),
                new Ansatt("Tond", "Atle", "Vaktmester", Kjonn.BODY_TYPE_2, 999999),
                new Ansatt("Rune", "Burgerleif", "Anime expert", Kjonn.BODY_TYPE_2, 99),
                new Ansatt("Kevin", "James", "Skodespelar", Kjonn.BODY_TYPE_1, 249),
                new Ansatt("Kong", "Harald", "Top guy", Kjonn.BODY_TYPE_1, 30)
        );

        List<String> etternavn = ansattListe.stream().map(Ansatt::getEtternavn).collect(Collectors.toList());
        System.out.println(etternavn);


        int antallKvinner = (int)ansattListe.stream().filter(a -> a.getKjonn() == Kjonn.BODY_TYPE_2).count();
        System.out.println(antallKvinner);

        double gjennomSnittlonnKvinner = ansattListe.stream().filter(a -> a.getKjonn() == Kjonn.BODY_TYPE_2).mapToDouble(a -> a.getAarslonn()).average().getAsDouble();
        System.out.println(gjennomSnittlonnKvinner);

        ansattListe.stream().filter(ansatt -> ansatt.getStilling().contains("sjef")).forEach(a -> a.setAarslonn(a.getAarslonn() * 1.07));

    }


}
