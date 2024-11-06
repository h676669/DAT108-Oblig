import Oblig4.model.Deltager;
import Oblig4.model.Kjonn;
import Oblig4.service.PassordService;
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
    private PassordService passordService;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        passordService = new PassordService();
        testDeltager = new Deltager("87654321","12345678","TestFornavn","TestEtternavn",Kjonn.Kvinne);
    }

    @Test
    void testDeltagerHarGyldigInitVerdier(){
        Set<ConstraintViolation<Deltager>> constraintViolations = validator.validate(testDeltager);
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    void testPassord(){
        testDeltager.setPassord(null,passordService);
        sjekkOmErFeil("Servant: Passowd må OwO væwe minst 8 tegn.");
        testDeltager.setPassord("132",passordService);
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
    void testMobilnummer(){
        testDeltager.setMobil(null);
        sjekkOmErFeil("Servant: Mobiwnyummew må OwO væwe nøyaktig 8 siffew og kan ikke starte med 0.");
        testDeltager.setMobil("01234567");
        sjekkOmErFeil("Servant: Mobiwnyummew må OwO væwe nøyaktig 8 siffew og kan ikke starte med 0.");
    }
    @Test
    void testKjonn(){
        testDeltager.setKjonn(null);
        sjekkOmErFeil("kan ikkje være tom");
    }


    private void sjekkOmErFeil(String feilMelding){
        Set<ConstraintViolation<Deltager>> constraintViolations = validator.validate(testDeltager);
        assertFalse(constraintViolations.isEmpty());
        assertThat(constraintViolations).hasSize(1);

        String violationMessage = constraintViolations.iterator().next().getMessage();
        assertEquals(feilMelding,violationMessage);
    }
}
