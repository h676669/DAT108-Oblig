package Oblig4.service;

import Oblig4.model.Deltager;
import Oblig4.repository.DeltagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DeltagerService {

    @Autowired
    private DeltagerRepository deltagerRepository;

    public List<Deltager> getAllDeltagere() {
        List<Deltager> deltagere = deltagerRepository.findAll();
        deltagere.sort(Comparator.comparing((Deltager d) -> d.getFornavn().toLowerCase()).thenComparing(d -> d.getEtternavn().toLowerCase()));
        return deltagere;
    }

    public Deltager getDeltagerByMobil(String mobil) {
        return deltagerRepository.findById(mobil).orElse(null);
    }

    public boolean leggTilDeltager(Deltager deltager) {
        if (deltagerRepository.existsById(deltager.getMobil())) {
            System.out.println("kan ikkje legge til deltager");
            return false;
        }
        System.out.println("låg til deltager");
        deltagerRepository.save(deltager);
        return true;
    }
}


