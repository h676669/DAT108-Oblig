import org.example.Deltager;
import org.example.Deltagere;
import org.example.Kjonn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDeltagere {
    Deltagere deltagere;

    @BeforeEach
    public void setUp() {
        deltagere = new Deltagere();
    }

    @Test
    public void testLeggTilDeltagere() {
        Deltager testDeltager = new Deltager("12345678","12345678","Fornavn","Etternavn", Kjonn.Mann);
        assertTrue(deltagere.leggTilDeltager(testDeltager)); // true
    }
    @Test
}
