package it.corso.calc01.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RigaCalcolo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Double numero1;
    @Column
    private Double numero2;
    @Column
    private Double risultato;

    public RigaCalcolo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNumero1() {
        return numero1;
    }

    public void setNumero1(Double numero1) {
        this.numero1 = numero1;
    }

    public Double getNumero2() {
        return numero2;
    }

    public void setNumero2(Double numero2) {
        this.numero2 = numero2;
    }

    public Double getRisultato() {
        return risultato;
    }

    public void setRisultato(Double risultato) {
        this.risultato = risultato;
    }

    @Override
    public String toString() {
        return "RigaCalcolo{" + "id=" + id + ", numero1=" + numero1 + ", numero2=" + numero2 + ", risultato=" + risultato + '}';
    }
    
    
}
