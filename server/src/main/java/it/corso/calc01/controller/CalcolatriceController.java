package it.corso.calc01.controller;

import it.corso.calc01.dto.CalcolatriceRichiestaDto;
import it.corso.calc01.dto.CalcolatriceRispostaDto;
import it.corso.calc01.service.CalcolatriceService;
import it.corso.calc01.service.impl.CalcolatriceServiceImpl;
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
}
