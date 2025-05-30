package Tema_5.EJ8;

import java.util.List;
import java.util.Set;

public class Estado {
    Set<Integer> visitados;
    List<Integer> caminoParcial;


    public Estado(List<Integer> caminoParcial, Set<Integer> visitados) {
        this.caminoParcial = caminoParcial;
        this.visitados = visitados;
    }

    public List<Integer> getCaminoParcial() {
        return caminoParcial;
    }

    public void setCaminoParcial(List<Integer> caminoParcial) {
        this.caminoParcial = caminoParcial;
    }

    public Set<Integer> getVisitados() {
        return visitados;
    }

    public void setVisitados(Set<Integer> visitados) {
        this.visitados = visitados;
    }
}
