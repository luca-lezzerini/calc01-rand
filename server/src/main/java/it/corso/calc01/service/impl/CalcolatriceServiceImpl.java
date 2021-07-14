package it.corso.calc01.service.impl;

import it.corso.calc01.model.Contatto;
import it.corso.calc01.model.RigaCalcolo;
import it.corso.calc01.repository.CalcolatriceRepository;
import it.corso.calc01.repository.ContattoRepository;
import it.corso.calc01.service.CalcolatriceService;
import java.awt.print.Pageable;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CalcolatriceServiceImpl implements CalcolatriceService {

    @Autowired
    CalcolatriceRepository calcolatriceRepository;
    @Autowired
    ContattoRepository contattoRepository;

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
        System.out.println("--------------------------");
        var lista = calcolatriceRepository.findByRisultato(32.0);
        System.out.println(lista);
        return calcolatriceRepository.findAll();
    }

    @Override
    public void test() {
        contattoRepository.deleteAllInBatch();
        var contatti = new ArrayList<Contatto>();
        contatti.add(new Contatto("Mario", "Rossi", 30));
        contatti.add(new Contatto("Alberto", "Bianchi", 30));
        contatti.add(new Contatto("Elisa", "Rossi", 25));
        contatti.add(new Contatto("Marcella", "Verdi", 40));

        // modo n. 1
        for (Contatto contatto : contatti) {
            contattoRepository.save(contatto);
        }

        // modo n. 2
        contatti.forEach(x -> contattoRepository.save(x));

        // modo n. 3
        contatti.stream().forEach(x -> contattoRepository.save(x));

        // modo n. 3
        contattoRepository.saveAll(contatti);

        // piccola osservazione sul metodo 2 -> 2.a e 2.b
        // creo piccola collezione su DB
        int limite = 5_000;
        for (int i = 0; i < limite; i++) {
            Contatto cx = new Contatto("Nome " + i, "Cognome " + i, i);
            contatti.add(cx);
        }
        Instant i1 = Instant.now();
        // Modo 2.a
        contattoRepository.saveAll(contatti);
        Instant f1 = Instant.now();
        Duration d1 = Duration.between(i1, f1);
        System.out.println("Tempo di salvataggio 2.a " + d1.toMillis());

        Instant i2 = Instant.now();
        // Modo 2.b
        contatti.stream().forEach(x -> contattoRepository.save(x));
        Instant f2 = Instant.now();
        Duration d2 = Duration.between(i2, f2);
        System.out.println("Tempo di salvataggio 2.b " + d2.toMillis());

        Instant i3 = Instant.now();
        // Modo 2.c
        contatti.parallelStream().forEach(x -> contattoRepository.save(x));
        Instant f3 = Instant.now();
        Duration d3 = Duration.between(i3, f3);
        System.out.println("Tempo di salvataggio 2.c " + d3.toMillis());
        
        // usiamo la paginazione
        var pag1 = contattoRepository.findAll(PageRequest.of(1,25));
        System.out.println(pag1.getContent());
    }

}
