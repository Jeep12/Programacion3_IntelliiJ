package PracticaParciales.parcial2024Tresa.back;

import java.util.*;

public class Estado {

    Set<Integer> visitados;
    List<Integer> caminoParcial;
    Integer sumaActual;

    public Estado() {
        this.caminoParcial = new ArrayList<>();
        this.visitados = new HashSet<>();
        this.sumaActual = 0;
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

    public Integer getSumaActual() {
        return sumaActual;
    }

    public void sumar(Integer elem){
        this.sumaActual+=elem;
    }
    public void setSumaActual(Integer sumaActual) {
        this.sumaActual = sumaActual;
    }
    public void removerUltimoVisitado(){
        this.visitados.remove(this.visitados.size()-1);
    }
    public void removerUltimoCaminoParcial(){
        this.caminoParcial.remove(this.caminoParcial.size()-1);
    }
}
