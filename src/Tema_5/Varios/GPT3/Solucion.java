package Tema_5.Varios.GPT3;

import java.util.ArrayList;
import java.util.List;

public class Solucion {
    List<List<Integer>> resultado;

    public Solucion() {
        this.resultado = new ArrayList<>();
    }

    public void addResultado(List<Integer> s){
        this.resultado.add(s);
    }

    public List<List<Integer>> getResultado() {
        return resultado;
    }

    public void setResultado(List<List<Integer>> resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Soluciones:\n");
        if (resultado == null || resultado.isEmpty()) {
            sb.append("No hay soluciones.");
        } else {
            for (List<Integer> lista : resultado ) {
                sb.append(lista.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
