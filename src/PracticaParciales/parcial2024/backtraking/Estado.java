package PracticaParciales.parcial2024.backtraking;

import java.util.ArrayList;
import java.util.List;

public class Estado {
    List<String> visitados;

    public Estado() {
        this.visitados = new ArrayList<>();
    }


    public void agregarElemento(String elem) {
        visitados.add(elem);
    }

    public void quitarUltimo() {
        if (!visitados.isEmpty())
            visitados.remove(visitados.size() - 1);
    }


    public List<String> getVisitados() {
        return visitados;
    }

    public void setVisitados(List<String> visitados) {
        this.visitados = visitados;
    }
}
