package BacktrackingDeepSeek.EJ2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Estado {
    Set<Integer> visitados;
    List<Integer> caminoParcial;

    public Estado() {
        this.visitados = new HashSet<>();
        this.caminoParcial = new ArrayList<>();

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
