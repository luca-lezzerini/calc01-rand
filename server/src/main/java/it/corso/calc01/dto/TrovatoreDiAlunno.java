package it.corso.calc01.dto;

import it.corso.calc01.model.Alunno;
import java.util.function.Predicate;

public class TrovatoreDiAlunno implements Predicate<Alunno>{

    Long idDaTrovare;
    public TrovatoreDiAlunno(Long idDaTrovare) {
        this.idDaTrovare=idDaTrovare;
    }

    @Override
    public boolean test(Alunno t) {
       return t.getId() == idDaTrovare;
    }
    

}
