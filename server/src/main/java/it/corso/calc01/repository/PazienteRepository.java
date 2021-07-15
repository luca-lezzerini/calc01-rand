package it.corso.calc01.repository;

import it.corso.calc01.model.Paziente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PazienteRepository extends JpaRepository<Paziente, Long>{

}
