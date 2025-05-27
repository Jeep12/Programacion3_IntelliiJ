package PracticaParciales.parcial2024quequen.ej4;

import java.util.ArrayList;
import java.util.List;

public class Estado {
    List<Producto> visitados;

    public Estado() {
        this.visitados = new ArrayList<>();
    }


    public Integer pesoActual() {
        Integer suma = 0;
        for (Producto p : visitados) {
            suma += p.getPeso();
        }
        return suma;
    }


    public Integer valorActual() {
        Integer suma = 0;
        for (Producto p : visitados) {
            suma += p.getValor();

        }

        return suma;
    }

    public List<Producto> getVisitados() {
        return visitados;
    }

    public void setVisitados(List<Producto> visitados) {
        this.visitados = visitados;
    }

    public void addVisitado(Producto p) {
        this.visitados.add(p);
    }


    public void removerUltimo() {
        this.visitados.remove(this.visitados.size() - 1);
    }
}
