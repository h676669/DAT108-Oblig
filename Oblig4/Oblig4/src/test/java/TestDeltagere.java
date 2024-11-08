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
        testDeltager = new Deltager("87654321", "12345678", "TestFornavn", "TestEtternavn", Kjonn.Kvinne);
    }

    @Test
    void testDeltagerHarGyldigInitVerdier() {
        Set<ConstraintViolation<Deltager>> constraintViolations = validator.validate(testDeltager);
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    void testPassordNotNull() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            testDeltager.setPassord(null, passordService);
            sjekkOmErFeil("Servant: Passord må være minst 8 tegn.");
        });
    }

    @Test
    void testNavn() {
        testDeltager.setFornavn("X");
        sjekkOmErFeil("Servant: Fornavn må være mellom 2 og 20 bokstaver.");
        testDeltager.setFornavn("XX1");
        sjekkOmErFeil("Servant: Fornavn må være mellom 2 og 20 bokstaver.");
        testDeltager.setFornavn("TestFornavn"); // reset
        testDeltager.setEtternavn("X");
        sjekkOmErFeil("Servant: Etternavn må være mellom 2 og 20 bokstaver.");
        testDeltager.setEtternavn("XX1");
        sjekkOmErFeil("Servant: Etternavn må være mellom 2 og 20 bokstaver.");
    }

    @Test
    void testMobilnummer() {
        testDeltager.setMobil(null);
        sjekkOmErFeil("Servant: Mobilnummer må være nøyaktig 8 sifre og kan ikke starte med 0.");
        testDeltager.setMobil("01234567");
        sjekkOmErFeil("Servant: Mobilnummer må være nøyaktig 8 sifre og kan ikke starte med 0.");
    }

    @Test
    void testKjonn() {
        testDeltager.setKjonn(null);
        sjekkOmErFeil("Kjønn kan ikke være tomt.");
    }


    private void sjekkOmErFeil(String feilMelding) {
        Set<ConstraintViolation<Deltager>> constraintViolations = validator.validate(testDeltager);
        assertFalse(constraintViolations.isEmpty());
        assertThat(constraintViolations).hasSize(1);

        String violationMessage = constraintViolations.iterator().next().getMessage();
        assertEquals(feilMelding, violationMessage);
    }
}
