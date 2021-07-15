package it.corso.calc01.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Classe {

    @Id
    @GeneratedValue
    Long id;

    @Column
    String codice;

    @OneToMany(mappedBy = "classe")
    List<Alunno> alunni;

    @ManyToMany
    List<Professore> professori;

    public Classe() {
    }

    public Classe(String codice) {
        this.codice = codice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public List<Alunno> getAlunni() {
        if (alunni == null) {
            alunni = new ArrayList<>();
        }
        return alunni;
    }

    public void setAlunni(List<Alunno> alunni) {
        this.alunni = alunni;
    }

    public List<Professore> getProfessori() {
        if (professori == null) {
            professori = new ArrayList<>();
        }
        return professori;
    }

    public void setProfessori(List<Professore> professori) {
        this.professori = professori;
    }

    @Override
    public String toString() {
        return "Classe{" + "id=" + id + ", codice=" + codice + '}';
    }

}
