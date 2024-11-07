import Oblig4.model.Deltager;
import Oblig4.model.Kjonn;
import Oblig4.util.loginUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLoginUtil {
    private static final Logger log = LoggerFactory.getLogger(TestLoginUtil.class);
    private MockHttpServletRequest mockRequest;
    private Deltager deltager1;

    @BeforeEach
    void setUp() {
        mockRequest = new MockHttpServletRequest();
        deltager1 = new Deltager("12345678", "password123", "test1", "test1", Kjonn.Mann);
    }

    @Test
    void testLogInnBruker() {
        loginUtil.loggInnBruker(mockRequest,deltager1);
        assertTrue(loginUtil.erBrukerInnlogget(mockRequest.getSession()));
    }

    @Test
    void testErBrukerInnlogget() {
        loginUtil.loggInnBruker(mockRequest,deltager1);
        assertTrue(loginUtil.erBrukerInnlogget(mockRequest.getSession()));
    }

    @Test
    void testLoggUtBruker(){
        loginUtil.loggInnBruker(mockRequest,deltager1);
        loginUtil.loggUtBruker(mockRequest.getSession());
        assertFalse(loginUtil.erBrukerInnlogget(mockRequest.getSession()));
    }
}

