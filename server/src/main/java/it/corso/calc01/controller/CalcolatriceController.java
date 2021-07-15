package it.corso.calc01.controller;

import it.corso.calc01.dto.CalcolatriceRichiestaDto;
import it.corso.calc01.dto.CalcolatriceRispostaDto;
import it.corso.calc01.model.Classe;
import it.corso.calc01.model.Professore;
import it.corso.calc01.service.CalcolatriceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CalcolatriceController {

    @Autowired
    CalcolatriceService cs;

    @RequestMapping("/saluta")
    public void salutaServer() {
        System.out.println("Ciao, sono il server");
    }

    @RequestMapping("/test")
    public void test() {
        System.out.println("Siamo in test");
        cs.test();
    }

    @RequestMapping("/mostra-classi")
    @ResponseBody
    public List<Classe> mostraClassi() {
        System.out.println("Siamo in mostra-classi");
        return cs.mostraClassi();
    }

    @RequestMapping("/mostra-docenti")
    @ResponseBody
    public List<Professore> mostraDocenti(@RequestBody Classe c) {
        System.out.println("Siamo in mostra-docenti");
        return cs.mostraProfessori(c);
    }

    @RequestMapping("/genera-classi")
    public void generaClassi() {
        System.out.println("Siamo in generaClassi");
        cs.generaConEreditarieta();
    }

    @RequestMapping("/somma")
    @ResponseBody
    public CalcolatriceRispostaDto somma(@RequestBody CalcolatriceRichiestaDto dto) {
        System.out.println("Service iniettato "+ cs.getClass().getName());
        System.out.println("Entrato in somma");
        System.out.println("Ricevuto dto " + dto);
        int s = cs.calcolaSomma(dto.getNumero1(), dto.getNumero2());
        CalcolatriceRispostaDto risp = new CalcolatriceRispostaDto();
        risp.setRisultato(s);
        risp.setRighe(cs.trovaTutti());
        return risp;
    }
    @RequestMapping("/sottrai")
    @ResponseBody
    public CalcolatriceRispostaDto sottrai(@RequestBody CalcolatriceRichiestaDto dto) {
        System.out.println("Service iniettato "+ cs.getClass().getName());
        System.out.println("Entrato in sottrai");
        System.out.println("Ricevuto dto " + dto);
        int s = cs.calcolaDifferenza(dto.getNumero1(), dto.getNumero2());
        CalcolatriceRispostaDto risp = new CalcolatriceRispostaDto();
        risp.setRisultato(s);
        risp.setRighe(cs.trovaTutti());
        return risp;
    }
}
