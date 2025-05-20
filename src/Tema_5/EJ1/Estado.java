package Tema_5.EJ1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Estado {

    private Integer vActual;
    private List<Integer> caminoParcial;
    private Set<Integer> visitados;

    public Estado( Integer vActual) {
        this.caminoParcial = new ArrayList<>();
        this.vActual = vActual;
        this.visitados = new HashSet<>();

    }


    public void removerUltimo(){
        this.caminoParcial.remove(this.caminoParcial.size()-1);
    }

    public void removerUltimoVisitados(){
        this.visitados.remove(this.caminoParcial.size()-1);
    }
    public void addCaminoParcial(Integer elem){
        this.caminoParcial.add(elem);
    }
    public boolean esMejorSolucion(List<Integer>mejorSolucion){
        return caminoParcial.size()>mejorSolucion.size();
    }

    public List<Integer> getCaminoParcial() {
        return caminoParcial;
    }

    public void setCaminoParcial(List<Integer> caminoParcial) {
        this.caminoParcial = caminoParcial;
    }

    public Integer getvActual() {
        return vActual;
    }

    public void setvActual(Integer vActual) {
        this.vActual = vActual;
    }

    public Set<Integer> getVisitados() {
        return visitados;
    }

    public void setVisitados(Set<Integer> visitados) {
        this.visitados = visitados;
    }
}
