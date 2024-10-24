package hvl.no.oblig4test_;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Oblig4TestApplicationTests {

    private Validator validator;
    private Deltager testDeltager;



    @BeforeEach
    public void beforeEach() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        testDeltager = new Deltager("Arne", "Trolldeig", "80808080", "ostepopp", "kvinne");
    }
    @Test
    void contextLoads() {
    }

    @Test
    void testDeltagerErGyldig() {
        Set<ConstraintViolation<Deltager>> violations = validator.validate(testDeltager);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testNavnErObligatorisk() {
        testDeltager.setFornavn(null);
        deltagerFullBodyCavitySearch("Fornavn er obligatorisk");
    }




    //Hjelpemetode for å sjekke feilmeldinger
    private void deltagerFullBodyCavitySearch(String feilmelding) {
        Set<ConstraintViolation<Deltager>> violations = validator.validate(testDeltager);
        assertFalse(violations.isEmpty());
        assertThat(violations).hasSize(1);

        String violationMessage = violations.iterator().next().getMessage();
        assertEquals(feilmelding, violationMessage);
    }


}
