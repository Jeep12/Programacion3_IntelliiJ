package PracticaParciales.parcial2024Tresa.back;

import java.util.ArrayList;
import java.util.List;

public class Solucion {
    private List<List<Integer>>resultado;

    public Solucion() {
        this.resultado = new ArrayList<>();
    }

    public void addResultado(List<Integer>resultado){
        this.resultado.add(resultado);
    }

    public List<List<Integer>> getResultado() {
        return resultado;
    }

    public void setResultado(List<List<Integer>> resultado) {
        this.resultado = resultado;
    }
    public Integer returnSize(){
        return this.resultado.size();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Solucion{\n");
        for (List<Integer> lista : resultado) {
            sb.append("  ").append(lista).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

}
