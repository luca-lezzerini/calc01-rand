package it.corso.calc01.repository;

import it.corso.calc01.model.Alunno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunnoRepository extends JpaRepository<Alunno, Long>{

}
