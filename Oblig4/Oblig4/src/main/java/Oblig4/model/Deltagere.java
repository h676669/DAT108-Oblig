package Oblig4.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Deltagere {
    public static final List<Deltager> Deltagerliste = new ArrayList<>(Arrays.asList(
            new Deltager("23456789", "Anne", "Panne", Kjonn.Kvinne),
            new Deltager("90123456", "Arne", "Arnese", Kjonn.Mann),
            new Deltager("12345679", "Lars-Petter", "Helland", Kjonn.Mann),
            new Deltager("34534534", "Per", "Viskelær", Kjonn.Mann),
            new Deltager("12321378", "Xx-x", "Xxx", Kjonn.Kvinne)
    ));

    public List<Deltager> getDeltagerliste() {
        skrivUtDeltagere();
        Deltagerliste.sort(Comparator.comparing((Deltager d) -> d.getFornavn().toLowerCase())
                .thenComparing((deltager -> deltager.getEtternavn().toLowerCase())));
        System.out.println();
        System.out.println("ting ble gjort her");
        return Deltagerliste;
    }

    public boolean leggTilDeltager(Deltager deltager) {
        if (!finnestMobilnummer(deltager.getMobil())) {
            Deltagerliste.add(deltager);
            return true;
        }
        System.out.println("noe gikk galt");
        return false;
    }
    public void skrivUtDeltagere(){
        int i = 0;
        for (Deltager deltager : Deltagerliste) {
            System.out.println();
            System.out.println("Deltager "+i);
            System.out.print("Fornavn: "+deltager.getFornavn() + " ");
            System.out.print("Etternavn: "+deltager.getEtternavn() + " ");
            System.out.print("Mobil: "+deltager.getMobil() + " ");
            System.out.print("Kjonn: "+deltager.getKjonn() + " ");
            i++;
        };
    }
    public boolean finnestMobilnummer(String mobilnummer){
       return Deltagerliste.stream().anyMatch(m -> m.getMobil().equals(mobilnummer));
    }
    public Deltager deltagerMedMobilnummer(String mobilnummer){
        for (Deltager deltager : Deltagerliste) {
            if (deltager.getMobil().equals(mobilnummer)) {
                return deltager;
            }
        }
        return null;
    }
}
