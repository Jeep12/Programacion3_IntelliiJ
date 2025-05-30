package Tema_5.Varios.GP4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Estado {
    private Set<Integer> visitados;
    private List<Integer> caminoParcial;
    private Integer sumaParcial;
    public Estado() {
        this.caminoParcial = new ArrayList<>();
        this.visitados = new HashSet<>();
        this.sumaParcial = 0;
    }


    public Integer getSumaParcial() {
        return sumaParcial;
    }

    public void setSumaParcial(Integer sumaParcial) {
        this.sumaParcial = sumaParcial;
    }

    public void sumar(Integer elemento){
        this.sumaParcial+=elemento;
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
