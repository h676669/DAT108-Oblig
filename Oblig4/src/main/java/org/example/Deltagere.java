package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Deltagere {
    public static final List<Deltager> Deltagerliste = new ArrayList<>(List.of(
            new Deltager("23456789", "Anne", "Panne", Kjonn.Kvinne),
            new Deltager("90123456", "Arne", "Arnese", Kjonn.Mann),
            new Deltager("12345679", "Lars-Petter", "Helland", Kjonn.Mann),
            new Deltager("34534534", "Per", "Viskelær", Kjonn.Mann),
            new Deltager("12321378", "Xx-x", "Xxx", Kjonn.Kvinne)
    ));

    public List<Deltager> getDeltagerliste() {
        Deltagerliste.sort(Comparator.comparing(Deltager::getFornavn).thenComparing(Deltager::getEtternavn));
        return Deltagerliste;
    }

    public boolean leggTilDeltager(Deltager deltager) {
        boolean exists = Deltagerliste.stream().anyMatch(m -> m.getMobil().equals(deltager.getMobil()));
        if (!exists) {
            Deltagerliste.add(deltager);
            return true;
        }
        return false;
    }
}
