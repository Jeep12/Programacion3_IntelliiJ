package Tema_5.Varios.GPT2;

import java.util.List;

public class Solucion {
    List<List<Integer>> solucion;


    public Solucion(List<List<Integer>> solucion) {
        this.solucion = solucion;
    }

    public void addSolucion(List<Integer>s){
        this.solucion.add(s);
    }
    public List<List<Integer>> getSolucion() {
        return solucion;
    }

    public void setSolucion(List<List<Integer>> solucion) {
        this.solucion = solucion;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Soluciones:\n");
        if (solucion == null || solucion.isEmpty()) {
            sb.append("No hay soluciones.");
        } else {
            for (List<Integer> lista : solucion) {
                sb.append(lista.toString()).append("\n");
            }
        }
        return sb.toString();
    }

}
