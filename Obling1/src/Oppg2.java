import java.util.Arrays;
import java.util.List;

public class Oppg2 {

    public static void main(String[] args) {
        List<Ansatt> ansattListe = Arrays.asList(
                new Ansatt("Truls", "Birger", "Kommandør", Kjonn.BODY_TYPE_1, 100 ),
                new Ansatt("Tond", "Atle", "Vaktmester", Kjonn.BODY_TYPE_2, 999999),
                new Ansatt("Rune", "Burgerleif", "Anime expert", Kjonn.BODY_TYPE_2, 99),
                new Ansatt("Kevin", "James", "Skodespelar", Kjonn.BODY_TYPE_1, 249),
                new Ansatt("Kong", "Harald", "Top guy", Kjonn.BODY_TYPE_1, 30)
        );

        skrivUtAlle(ansattListe);

        System.out.println();
        System.out.println("Fast kronetillegg, +25");
        lonnsoppgjor(ansattListe, x -> x.setAarslonn(x.getAarslonn() + 25));
        skrivUtAlle(ansattListe);

        System.out.println();
        System.out.println("Fast prosenttillegg, +100%");
        lonnsoppgjor(ansattListe, x -> x.setAarslonn(x.getAarslonn() * 2));
        skrivUtAlle(ansattListe);

        System.out.println();
        System.out.println("Fast prosenttillegg, +100% for de som har under 200 i lønn");
        lonnsoppgjor(ansattListe, x -> {
            if (x.getAarslonn() < 200) {
                x.setAarslonn(x.getAarslonn() + 200);
            }
        });
        skrivUtAlle(ansattListe);

        System.out.println();
        System.out.println("Fast prosenttillegg, +1000% kun for BODY TYPE 1 individer");
        lonnsoppgjor(ansattListe, x -> {
            if (x.getKjonn() == Kjonn.BODY_TYPE_1) {
                x.setAarslonn(x.getAarslonn() * 10);
            }
        });
        skrivUtAlle(ansattListe);
    }

    private static void skrivUtAlle(List<Ansatt> ansatte) {
        for (Ansatt a: ansatte) {
            System.out.println(a.getFornavn() + " " + a.getEtternavn() + ", kjønn: " + a.getKjonn() + ", årslønn: " + a.getAarslonn());
        }
    }

    public static void lonnsoppgjor(List<Ansatt> ansatte, Oppgjor o) {
        for (Ansatt ansatt : ansatte) {
            o.cookTheBooks(ansatt);
        }
    }

    @FunctionalInterface
    interface Oppgjor {
        public void cookTheBooks(Ansatt ansatt);
    }

}


