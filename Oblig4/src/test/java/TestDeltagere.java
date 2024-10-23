import org.example.Deltager;
import org.example.Deltagere;
import org.example.Kjonn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDeltagere {
    Deltagere deltagere;

    @BeforeEach
    public void setUp() {
        deltagere = new Deltagere();
    }

    @Test
    public void testLeggTilDeltagere() {
        //mobil må være unik
        Deltager testRiktigDeltager = new Deltager("12345678","12345678","Fornavn","Etternavn", Kjonn.Mann);
        Deltager testMobilFeil = new Deltager("1234567","12345678","Fornavn","Etternavn", Kjonn.Mann);
        Deltager testPassordFeil = new Deltager("12345699","1234567","Fornavn","Etternavn", Kjonn.Mann);
        Deltager testFornavnFeil = new Deltager("12345999","12345678","Fornavn1","Etternavn", Kjonn.Mann);
        Deltager testEtternavnFeil = new Deltager("12349999","12345678","Fornavn","Etternavn1", Kjonn.Mann);

        assertTrue(deltagere.leggTilDeltager(testRiktigDeltager));
        assertFalse(deltagere.leggTilDeltager(testMobilFeil));
        assertFalse(deltagere.leggTilDeltager(testPassordFeil));
        assertFalse(deltagere.leggTilDeltager(testFornavnFeil));
        assertFalse(deltagere.leggTilDeltager(testEtternavnFeil));
    }
}
