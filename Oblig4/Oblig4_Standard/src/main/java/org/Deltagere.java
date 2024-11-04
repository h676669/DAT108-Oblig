package org;

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
        System.out.println("Tok alle deltagere");
        return Deltagerliste;
    }

    public boolean leggTilDeltager(Deltager deltager) {
        boolean exists = Deltagerliste.stream().anyMatch(m -> m.getMobil().equals(deltager.getMobil()));
        if (!exists) {
            Deltagerliste.add(deltager);
            return true;
        }
        System.out.println("Fikk ikkje lagt til deltager");
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
}
