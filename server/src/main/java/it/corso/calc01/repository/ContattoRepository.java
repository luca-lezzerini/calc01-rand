package it.corso.calc01.repository;

import it.corso.calc01.model.Contatto;
import java.util.stream.Stream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Long> {

    Stream<Contatto> findByNomeLike(String s);
    Page<Contatto> findAll(Pageable p);
}
