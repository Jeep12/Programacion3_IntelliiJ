package Tema_5.EJ11;

import java.util.HashSet;
import java.util.Set;

public class Estado {

    private Celda celdaActual;
    private Set<Celda> visitados;
    private Integer cantPasos;

    public Estado(Celda celdaActual) {
        this.cantPasos = 0;
        this.celdaActual = celdaActual;
        this.visitados = new HashSet<>();

    }


    public Integer getCantPasos() {
        return cantPasos;
    }

    public void setCantPasos(Integer cantPasos) {
        this.cantPasos = cantPasos;
    }

    public Celda getCeldaActual() {
        return celdaActual;
    }

    public void setCeldaActual(Celda celdaActual) {
        this.cantPasos++;
        this.celdaActual = celdaActual;
    }

    public Set<Celda> getVisitados() {
        return visitados;
    }

    public void addVisitado(Celda celda){
        this.visitados.add(celda);
    }

    public void removetVisitado(){
        this.visitados.remove(this.visitados.size()-1);
    }
    public void restarCantPasos(){
        this.cantPasos--;
    }
    public void setVisitados(Set<Celda> visitados) {
        this.visitados = visitados;
    }
}
