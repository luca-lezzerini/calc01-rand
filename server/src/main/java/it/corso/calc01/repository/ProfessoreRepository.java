package it.corso.calc01.repository;

import it.corso.calc01.model.Professore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessoreRepository extends JpaRepository<Professore, Long>{

}
