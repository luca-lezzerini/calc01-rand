package it.corso.calc01.repository;

import it.corso.calc01.model.RigaCalcolo;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalcolatriceRepository extends JpaRepository<RigaCalcolo, Long>{
    // select * from rigacalcolo where risultato=?
    // query by method name
    Set<RigaCalcolo> findByRisultato(Double d);
}
