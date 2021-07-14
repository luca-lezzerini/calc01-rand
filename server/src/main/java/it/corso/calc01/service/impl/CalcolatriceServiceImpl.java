package it.corso.calc01.service.impl;

import it.corso.calc01.model.RigaCalcolo;
import it.corso.calc01.repository.CalcolatriceRepository;
import it.corso.calc01.service.CalcolatriceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcolatriceServiceImpl implements CalcolatriceService {
    
    @Autowired
    CalcolatriceRepository calcolatriceRepository;

    @Override
    public int calcolaSomma(int p1, int p2) {
        System.out.println("Siamo nel service");
        int r = p1 + p2;
        RigaCalcolo riga = new RigaCalcolo();
        riga.setNumero1(Double.valueOf(p1));
        riga.setNumero2(Double.valueOf(p2));
        riga.setRisultato(Double.valueOf(r));
        calcolatriceRepository.save(riga);
        return r;
    }

    @Override
    public List<RigaCalcolo> trovaTutti() {
        return calcolatriceRepository.findAll();
    }
    
    

}
