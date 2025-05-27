package Tema_5.Varios.GPT1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Estado {
    List<Plato> visitados;
    Integer caloriasActual;
    Integer valorActual;
    Integer saborActual;

    public Estado() {
        this.visitados = new ArrayList<>();
        this.caloriasActual = 0;
        this.valorActual = 0;
        this.saborActual = 0;
    }


    public void addVisitado(Plato p) {
        this.visitados.add(p);
    }

    public void removerUltimo() {
        this.visitados.remove(this.visitados.size() - 1);
    }

    public Integer getSaborActual() {
        return saborActual;
    }

    public void setSaborActual(Integer saborActual) {
        this.saborActual += saborActual;
    }

    public Integer getCaloriasActual() {
        return caloriasActual;
    }

    public void setCaloriasActual(Integer caloriasActual) {
        this.caloriasActual += caloriasActual;
    }

    public Integer getValorActual() {
        return valorActual;
    }

    public void setValorActual(Integer valorActual) {
        this.valorActual += valorActual;
    }

    public List<Plato> getVisitados() {
        return visitados;
    }

    public void setVisitados(List<Plato> visitados) {
        this.visitados = visitados;
    }
}
