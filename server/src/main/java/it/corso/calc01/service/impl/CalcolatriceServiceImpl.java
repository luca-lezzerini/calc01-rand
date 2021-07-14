package it.corso.calc01.service.impl;

import it.corso.calc01.service.CalcolatriceService;
import org.springframework.stereotype.Service;

@Service
public class CalcolatriceServiceImpl implements CalcolatriceService {

    @Override
    public int calcolaSomma(int p1, int p2) {
        System.out.println("Siamo nel service");
        int r = p1 + p2;
        return r;
    }

}
