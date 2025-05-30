package Tema_5.Varios.GPT3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Estado {
    Set<Integer> visitados;
    List<Integer> caminoParcial;
    Integer sumaActual;

    public Estado() {
        this.caminoParcial = new ArrayList<>();
        this.visitados = new HashSet<>();
        this.sumaActual = 0;
    }

    public Integer getSumaActual() {
        return sumaActual;
    }

    public void setSumaActual(Integer sumaActual) {
        this.sumaActual = sumaActual;
    }

    public Integer suma() {
        Integer suma = 0;
        for (Integer value : caminoParcial) {
            suma += value;
        }
        return suma;
    }

    public void sumarActual(Integer elem) {
        this.sumaActual += elem;
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

    public void removerUltimoVisitado() {
        if (!visitados.isEmpty()) {
            this.visitados.remove(this.visitados.size() - 1);
        }
    }
}
