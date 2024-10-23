import org.example.Deltager;
import org.example.Deltagere;
import org.example.Kjonn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;


import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TestDeltagere {
    private Deltagere deltagere;
    private Validator validator;
    private Deltager testDeltager;

    @BeforeEach
    void setUp() {
        deltagere = new Deltagere();
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        testDeltager = new Deltager("87654321","12345678","TestFornavn","TestEtternavn",Kjonn.Kvinne);
    }

    @Test
    void testLeggTilDeltagere() {
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

    @Test
    void testDeltagerHarGyldigInitVerdier(){
        Set<ConstraintViolation<Deltager>> constraintViolations = validator.validate(testDeltager);
        assertTrue(constraintViolations.isEmpty());
    }
    @Test
    void passordErObligatorisk(){
        testDeltager.setPassord(null);
        sjekkOmErFeil("Servant: Passowd må OwO væwe minst 8 tegn.");

    }

    private void sjekkOmErFeil(String feilMelding){
        Set<ConstraintViolation<Deltager>> constraintViolations = validator.validate(testDeltager);
        assertFalse(constraintViolations.isEmpty());
        assertThat(constraintViolations).hasSize(1);

        String violationMessage = constraintViolations.iterator().next().getMessage();
        assertEquals(feilMelding,violationMessage);
    }
}
