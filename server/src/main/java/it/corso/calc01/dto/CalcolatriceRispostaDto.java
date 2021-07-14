package it.corso.calc01.dto;

import it.corso.calc01.model.RigaCalcolo;
import java.util.List;

public class CalcolatriceRispostaDto {
    private int risultato;
    private List<RigaCalcolo> righe;

    public CalcolatriceRispostaDto() {
    }

    public int getRisultato() {
        return risultato;
    }

    public void setRisultato(int risultato) {
        this.risultato = risultato;
    }

    public List<RigaCalcolo> getRighe() {
        return righe;
    }

    public void setRighe(List<RigaCalcolo> righe) {
        this.righe = righe;
    }
    
}
