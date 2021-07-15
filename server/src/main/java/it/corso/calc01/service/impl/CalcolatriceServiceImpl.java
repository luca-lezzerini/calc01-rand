package it.corso.calc01.service.impl;

import it.corso.calc01.model.Alunno;
import it.corso.calc01.model.Classe;
import it.corso.calc01.model.Contatto;
import it.corso.calc01.model.Paziente;
import it.corso.calc01.model.Persona;
import it.corso.calc01.model.Professore;
import it.corso.calc01.model.RigaCalcolo;
import it.corso.calc01.repository.AlunnoRepository;
import it.corso.calc01.repository.CalcolatriceRepository;
import it.corso.calc01.repository.ClasseRepository;
import it.corso.calc01.repository.ContattoRepository;
import it.corso.calc01.repository.PazienteRepository;
import it.corso.calc01.repository.PersonaRepository;
import it.corso.calc01.repository.ProfessoreRepository;
import it.corso.calc01.service.CalcolatriceService;
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
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    PazienteRepository pazienteRepository;
    @Autowired
    AlunnoRepository alunnoRepository;
    @Autowired
    ClasseRepository classeRepository;
    @Autowired
    ProfessoreRepository professoreRepository;

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
        var pag1 = contattoRepository.findAll(PageRequest.of(1, 25));
        System.out.println(pag1.getContent());

//        contatti.stream().filter(c -> c.getEta()> 30).forEach(x -> System.out.println(x));
    }

    @Override
    public void generaConEreditarieta() {
        alunnoRepository.deleteAllInBatch();
        classeRepository.deleteAllInBatch();
        Persona p;
        p = new Persona("Mario", "Rossi", 30);
        personaRepository.save(p);
        p = new Persona("Maria", "Bianchi", 20);
        personaRepository.save(p);
        p = new Persona("Luigi", "Bianchi", 40);
        personaRepository.save(p);

        Paziente paz;
        paz = new Paziente("12345", "Giorgia", "Rossi", 34);
        pazienteRepository.save(paz);
        paz = new Paziente("54321", "Elisa", "Bianchi", 74);
        pazienteRepository.save(paz);

        Classe va  = new Classe("VA");
        va  = classeRepository.save(va);
        Classe vb = new Classe("VB");
        vb = classeRepository.save(vb);

        Alunno a1 = new Alunno("Ciro", "Vina", 18);
        a1 = alunnoRepository.save(a1);
        Alunno a2 = new Alunno("Elio", "Plutonio", 18);
        a2 = alunnoRepository.save(a2);
        Alunno b1 = new Alunno("Massimo", "Della Pena", 18);
        b1 = alunnoRepository.save(b1);
        Alunno b2 = new Alunno("Franco", "Bollo", 18);
        b2 = alunnoRepository.save(b2);

        // associo gli alunni alla classe VA
        a1.setClasse(va);
        alunnoRepository.save(a1);
        a2.setClasse(va);
        alunnoRepository.save(a2);
        va.getAlunni().add(a1);
        va.getAlunni().add(a2);
        classeRepository.save(va);

        // rimuovo a1 dalla VA
        a1.setClasse(null);
        alunnoRepository.save(a1);

//         TrovatoreDiAlunno tda = new TrovatoreDiAlunno(a1.getId());
//        Predicate<Alunno> tda = new Predicate<Alunno>() {
//            @Override
//            public boolean test(Alunno t) {
//                return t.getId().equals(elle);
//            }
//        }
        Long elle = a1.getId();
        va.getAlunni().removeIf(a -> a.getId().equals(elle));
        classeRepository.save(va);
        
        Professore p1 = new Professore("Aristotele", "De Grecis", 30);
        p1 = professoreRepository.save(p1);
        Professore p2 = new Professore("Archimede", "Pitagorico", 20);
        p2 = professoreRepository.save(p2);
        Professore p3 = new Professore("Albert", "Einstein", 60);
        p3 = professoreRepository.save(p3);
        va.getProfessori().add(p1);
        va.getProfessori().add(p2);
        vb.getProfessori().add(p1);
        vb.getProfessori().add(p2);
        vb.getProfessori().add(p3);
        classeRepository.save(va);
        classeRepository.save(vb);
        
        p1.getClassi().add(va);
        p1.getClassi().add(vb);
        professoreRepository.save(p1);
        p2.getClassi().add(va);
        p2.getClassi().add(vb);
        professoreRepository.save(p2);
        p3.getClassi().add(vb);
        professoreRepository.save(p3);

    }

}
