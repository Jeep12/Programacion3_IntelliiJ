package Tema_5.Varios.GPT2;

import java.util.ArrayList;
import java.util.List;

public class Estado {
    List<Integer> visitados;

    public Estado() {
        this.visitados = new ArrayList<>();
    }

    public void addVisitado(Integer visitado){
        this.visitados.add(visitado);
    }

    public List<Integer> getVisitados() {
        return visitados;
    }

    public void setVisitados(List<Integer> visitados) {
        this.visitados = visitados;
    }
}
