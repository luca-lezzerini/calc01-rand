package it.corso.calc01.repository;

import it.corso.calc01.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{
    
}
