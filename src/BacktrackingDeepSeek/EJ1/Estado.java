package BacktrackingDeepSeek.EJ1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Estado {
    List<Integer> caminoParcial;
    Set<Integer> visitados;
    Integer sumaParcial;

    public Estado() {
        this.caminoParcial = new ArrayList<>();
        this.visitados = new HashSet<>();
        this.sumaParcial = 0;
    }

    public void acumularActual(Integer elem) {
        this.sumaParcial += elem;
    }

    public List<Integer> getCaminoParcial() {
        return caminoParcial;
    }

    public void setCaminoParcial(List<Integer> caminoParcial) {
        this.caminoParcial = caminoParcial;
    }

    public Integer getSumaParcial() {
        return sumaParcial;
    }

    public void setSumaParcial(Integer sumaParcial) {
        this.sumaParcial = sumaParcial;
    }

    public Set<Integer> getVisitados() {
        return visitados;
    }

    public void setVisitados(Set<Integer> visitados) {
        this.visitados = visitados;
    }
}
