package org.example;

import java.util.Arrays;
import java.util.List;

public class Deltagere {
    public static final List<Deltager> Deltagerliste = Arrays.asList(
        new Deltager("23456789","Anne", "Panne",Kjonn.Kvinne),
        new Deltager("90123456","Arne", "Arnese",Kjonn.Mann),
        new Deltager("12345679","Lars-Petter", "Helland",Kjonn.Mann),
        new Deltager("34534534","Per", "Viskelær",Kjonn.Mann),
        new Deltager("12321378","Xx-x", "Xxx",Kjonn.Kvinne)
    );

    public List<Deltager> getDeltagerliste() {
        return Deltagerliste;
    };
    public boolean leggTilDeltager(Deltager deltager) {
        List<Deltager> Testdeltagerliste = Deltagerliste.stream().filter(m -> m.getMobil().equals(deltager.getMobil())).toList();
      if (Testdeltagerliste.isEmpty()) {
          Deltagerliste.add(deltager);
          return true;
      }
      return false;
    };

}
