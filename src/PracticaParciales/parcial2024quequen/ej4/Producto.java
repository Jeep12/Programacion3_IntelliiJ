package PracticaParciales.parcial2024quequen.ej4;

public class Producto {

    Integer peso;
    Integer valor;

    public Producto(Integer valor, Integer peso) {
        this.valor = valor;
        this.peso = peso;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return " Valor " + this.getValor() + " Peso " + this.getPeso() + " ";
    }
}
