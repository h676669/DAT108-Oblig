import Oblig4.model.Deltager;
import Oblig4.model.Kjonn;
import Oblig4.model.Passord;
import Oblig4.repository.DeltagerRepository;
import Oblig4.service.DeltagerService;
import Oblig4.service.PassordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class TestDeltagerService {

    @Mock
    private DeltagerRepository mockDeltagerRepository;

    @Mock
    private PassordService mockPassordService;

    @InjectMocks
    private DeltagerService testDeltagerService;

    private Deltager deltager1;
    private Deltager deltager2;

    @BeforeEach
    void setUp() {
        when(mockPassordService.genererTilfeldigSalt()).thenReturn("1A2B3C4D5E6F7G8H9I0J1K2L3M4N5O6P");
        when(mockPassordService.hashMedSalt("password123", "1A2B3C4D5E6F7G8H9I0J1K2L3M4N5O6P")).thenReturn("AABBCCDDEEFF00112233445566778899AABBCCDDEEFF00112233445566778899");

        deltager1 = new Deltager("12345678", "password123", "test1", "test1", Kjonn.Mann);
        deltager1.setPassord("password123", mockPassordService);

        deltager2 = new Deltager("11223344", "password123", "test2", "test2", Kjonn.Kvinne);
        deltager2.setPassord("password123", mockPassordService);
    }

    @Test
    void testGetAllDeltagers() {
        when(mockDeltagerRepository.findAll()).thenReturn(new ArrayList<>(List.of(deltager1, deltager2)));

        List<Deltager> resultat = testDeltagerService.getAllDeltagere();

        assertEquals(2, resultat.size());
        assertTrue(resultat.contains(deltager1));
        assertTrue(resultat.contains(deltager2));
    }

    @Test
    void testGetDeltagerByMobil() {
        when(mockDeltagerRepository.findById("12345678")).thenReturn(Optional.of(deltager1));

        Deltager resultat = testDeltagerService.getDeltagerByMobil("12345678");

        assertNotNull(resultat);
        assertEquals("test1", resultat.getFornavn());
    }

    @Test
    void testGetDeltagerByMobil_NotFound() {
        when(mockDeltagerRepository.findById("00000000")).thenReturn(Optional.empty());

        Deltager resultat = testDeltagerService.getDeltagerByMobil("00000000");

        assertNull(resultat);
    }
}
