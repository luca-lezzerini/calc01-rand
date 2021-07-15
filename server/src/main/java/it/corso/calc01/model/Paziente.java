package it.corso.calc01.model;

import javax.persistence.Entity;

@Entity
public class Paziente extends Persona {

    private String numeroPolizza;

    public Paziente() {
    }

    public Paziente(String numeroPolizza, String nome, String cognome, Integer eta) {
        super(nome, cognome, eta);
        this.numeroPolizza = numeroPolizza;
    }
    
    public String getNumeroPolizza() {
        return numeroPolizza;
    }

    public void setNumeroPolizza(String numeroPolizza) {
        this.numeroPolizza = numeroPolizza;
    }

}
