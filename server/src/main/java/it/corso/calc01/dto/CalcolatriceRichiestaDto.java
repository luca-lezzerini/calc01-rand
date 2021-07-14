package it.corso.calc01.dto;

public class CalcolatriceRichiestaDto {
        private int numero1;
        private int numero2;

    public CalcolatriceRichiestaDto() {
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    @Override
    public String toString() {
        return "CalcolatriceRichiestaDto{" + "numero1=" + numero1 + ", numero2=" + numero2 + '}';
    }
        

}
