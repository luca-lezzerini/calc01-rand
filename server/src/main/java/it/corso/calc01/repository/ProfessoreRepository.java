package it.corso.calc01.repository;

import it.corso.calc01.model.Professore;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessoreRepository extends JpaRepository<Professore, Long>{
    @Query("select p from Professore p join p.classi c where c.id = :classeId")
    List<Professore> trovaProfPerClasse(@Param("classeId") Long idClasse);
}
