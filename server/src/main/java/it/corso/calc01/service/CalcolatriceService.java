package it.corso.calc01.service;

import it.corso.calc01.model.RigaCalcolo;
import java.util.List;

public interface CalcolatriceService {

    /**
     * Calcola la somma di due numeri interi passati come parametro.
     *
     * @param p1 il primo numero intero da sommare
     * @param p2 il secondo numero intero da sommare
     * @return la somma dei due (intero)
     */
    int calcolaSomma(int p1, int p2);

    /**
     * Recupera tutte le righe di calcolo nel DB
     * @return una lista di righe calcolo
     */
    List<RigaCalcolo> trovaTutti();
    
    void test();
}
