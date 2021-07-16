package it.corso.calc01.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Professore implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private Integer eta;

    @ManyToMany
    @JoinTable(
            //            name = "classi_professori",
            joinColumns = {
                @JoinColumn(name = "fk_prof")},
            inverseJoinColumns = {
                @JoinColumn(name = "fk_classe")}
    )
    List<Classe> classi;

    public Professore() {
    }

    public Professore(String nome, String cognome, Integer eta) {
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

    public List<Classe> getClassi() {
        // non cambia classi!!!
//        return (classi == null ? new ArrayList<>() : classi);
        if (classi == null) {
            classi = new ArrayList<>();
        }
        return classi;
    }

    public void setClassi(List<Classe> classi) {
        this.classi = classi;
    }

    @Override
    public String toString() {
        return "Contatto{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + '}';
    }

}
