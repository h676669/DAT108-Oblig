import org.Deltager;
import org.Kjonn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;


import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TestDeltagere {
    private Validator validator;
    private Deltager testDeltager;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        testDeltager = new Deltager("87654321","12345678","TestFornavn","TestEtternavn",Kjonn.Kvinne);
    }

    @Test
    void testGyldingDeltager(){
        Set<ConstraintViolation<Deltager>> constraintViolations = validator.validate(testDeltager);
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    void testPassord(){
        testDeltager.setPassord(null);
        sjekkOmErFeil("Passord må være minst 8 tegn");
        testDeltager.setPassord("132");
        sjekkOmErFeil("Passord må være minst 8 tegn");
    }

    @Test
    void testFornavn(){
        testDeltager.setFornavn("X");
        sjekkOmErFeil("Fornavn må være mellom 2 og 20 bokstaver.");
        testDeltager.setFornavn("XX1");
        sjekkOmErFeil("Fornavn må være mellom 2 og 20 bokstaver.");
    }

    @Test
    void testEtternavn(){
        testDeltager.setEtternavn("X");
        sjekkOmErFeil("Etternavn må være mellom 2 og 20 bokstaver.");
        testDeltager.setEtternavn("XX1");
        sjekkOmErFeil("Etternavn må være mellom 2 og 20 bokstaver.");
    }

    @Test
    void testMobilnummer(){
        testDeltager.setMobil(null);
        sjekkOmErFeil("Mobilnummer må være nøyaktig 8 siffer og kan ikke begynne på 0.");
        testDeltager.setMobil("01234567");
        sjekkOmErFeil("Mobilnummer må være nøyaktig 8 siffer og kan ikke begynne på 0.");
    }
    @Test
    void testKjonn(){
        testDeltager.setKjonn(null);
        sjekkOmErFeil("kan ikke være tom");
    }


    private void sjekkOmErFeil(String feilMelding){
        Set<ConstraintViolation<Deltager>> constraintViolations = validator.validate(testDeltager);
        assertFalse(constraintViolations.isEmpty());
        assertThat(constraintViolations).hasSize(1);

        String violationMessage = constraintViolations.iterator().next().getMessage();
        assertEquals(feilMelding,violationMessage);
    }
}
