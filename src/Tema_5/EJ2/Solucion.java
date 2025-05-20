package Tema_5.EJ2;

import java.util.List;

public class Solucion {
    private int suma;
    private List<Integer> camino;

    public Solucion(int suma, List<Integer> camino) {
        this.suma   = suma;
        this.camino = camino;
    }

    public void setCamino(List<Integer> camino) {
        this.camino.clear();
        this.camino = camino;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getSuma() {
        return suma;
    }

    public List<Integer> getCamino() {
        return camino;
    }

    @Override
    public String toString() {
        return "Mejor solucion: " + this.camino + " con una longitud de: " + suma;
    }
}
