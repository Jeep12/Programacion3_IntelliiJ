package PracticaParciales.parcial2024quequen.ej4;

import java.util.List;

public class Solucion {
    List<Producto> subconjunto;


    public Solucion(List<Producto> subconjunto, Integer mejorValorActual) {
        this.subconjunto = subconjunto;
    }
    public Integer valorActual() {
        Integer suma = 0;
        for (Producto p : subconjunto) {
            suma += p.getValor();

        }

        return suma;
    }





    public void addProducto(List<Producto>p){
        this.subconjunto.addAll(p);
    }
    public List<Producto> getSubconjunto() {
        return subconjunto;
    }

    public void setSubconjunto(List<Producto> subconjunto) {
        this.subconjunto = subconjunto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mejor Solución:\n");
        sb.append("Valor total: ").append(valorActual()).append("\n");
        sb.append("Productos:\n");
        for (Producto p : subconjunto) {
            sb.append(" - Valor: ").append(p.getValor())
                    .append(", Peso: ").append(p.getPeso()).append("\n");
        }
        return sb.toString();
    }

}
