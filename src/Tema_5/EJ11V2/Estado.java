package Tema_5.EJ11V2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Estado {

    private Celda celdaActual;
    private Set<Celda> visitados;
    private List<Celda> caminoParcial;


    public Estado( Celda celdaActual) {
        this.visitados = new HashSet<>();
        this.celdaActual = celdaActual;
        this.caminoParcial = new ArrayList<>();
    }

    public Celda getCeldaActual() {
        return celdaActual;
    }

    public void setCeldaActual(Celda celdaActual) {
        this.celdaActual = celdaActual;
    }

    public Set<Celda> getVisitados() {
        return visitados;
    }

    public void setVisitados(Set<Celda> visitados) {
        this.visitados = visitados;
    }

    public List<Celda> getCaminoParcial() {
        return caminoParcial;
    }

    public void setCaminoParcial(List<Celda> caminoParcial) {
        this.caminoParcial = caminoParcial;
    }

    public void addCelda(Celda celda){
        this.caminoParcial.add(celda);
    }

    public void removerUltimo(){
        this.caminoParcial.remove(this.caminoParcial.size()-1);
    }
}
