package Tema_5.EJ10;

import java.util.*;

public class Solucion {

    List<List<Integer>> resultado;

    public Solucion(List<List<Integer>> resultado) {
        this.resultado = resultado;
    }

    public List<List<Integer>> getResultado() {
        return resultado;
    }

    public void setResultado(List<List<Integer>> resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return resultado.toString();
    }
}
