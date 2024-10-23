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
    void testDeltagerHarGyldigInitVerdier(){
        Set<ConstraintViolation<Deltager>> constraintViolations = validator.validate(testDeltager);
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    void testPassord(){
        testDeltager.setPassord(null);
        sjekkOmErFeil("Servant: Passowd må OwO væwe minst 8 tegn.");
        testDeltager.setPassord("132");
        sjekkOmErFeil("Servant: Passowd må OwO væwe minst 8 tegn.");
    }

    @Test
    void testNavn(){
        testDeltager.setFornavn("X");
        sjekkOmErFeil("Servant: Fownyavn må OwO væwe mewwom 2 og 20 bokstavew.");
        testDeltager.setFornavn("XX1");
        sjekkOmErFeil("Servant: Fownyavn må OwO væwe mewwom 2 og 20 bokstavew.");
        testDeltager.setFornavn("TestFornavn"); // reset
        testDeltager.setEtternavn("X");
        sjekkOmErFeil("Servant: E-E-Ettewnyavn må OwO væwe mewwom 2 og 20 bokstavew.");
        testDeltager.setEtternavn("XX1");
        sjekkOmErFeil("Servant: E-E-Ettewnyavn må OwO væwe mewwom 2 og 20 bokstavew.");
    }

    @Test
    void testMobilNummerRiktig(){
        testDeltager.setMobil(null);
        sjekkOmErFeil("Servant: Mobiwnyummew må OwO væwe nøyaktig 8 siffew og kan ikke starte med 0.");
        testDeltager.setMobil("01234567");
        sjekkOmErFeil("Servant: Mobiwnyummew må OwO væwe nøyaktig 8 siffew og kan ikke starte med 0.");
    }


    private void sjekkOmErFeil(String feilMelding){
        Set<ConstraintViolation<Deltager>> constraintViolations = validator.validate(testDeltager);
        assertFalse(constraintViolations.isEmpty());
        assertThat(constraintViolations).hasSize(1);

        String violationMessage = constraintViolations.iterator().next().getMessage();
        assertEquals(feilMelding,violationMessage);
    }
}
