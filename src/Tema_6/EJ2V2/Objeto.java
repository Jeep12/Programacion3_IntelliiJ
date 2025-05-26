package Tema_6.EJ2V2;

public class Objeto implements Comparable<Objeto>  {

    Double valor;
    Double peso;


    public Objeto(Double valor, Double peso) {
        this.valor = valor;
        this.peso = peso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return   "Objeto con valor " + this.getValor();
    }

    @Override
    public int compareTo(Objeto otro) {
        double r1 = this.valor / this.peso;
        double r2 = otro.valor / otro.peso;
        return Double.compare(r2, r1); // de mayor a menor
    }




}
