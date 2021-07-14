package it.corso.calc01.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contatto implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private Integer eta;

    public Contatto() {
    }

    public Contatto(String nome, String cognome, Integer eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Contatto{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + '}';
    }
    
    
    
}
