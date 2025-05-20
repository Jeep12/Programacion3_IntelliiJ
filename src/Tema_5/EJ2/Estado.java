package Tema_5.EJ2;

import java.util.ArrayList;
import java.util.List;

public class Estado {

    public int fila, col, suma;
    public boolean[][] visitado;
    public List<Integer> camino;


    public Estado(int fila, int columna, int n) {
        this.visitado = new boolean[n][n];
        this.camino = new ArrayList<>();
        this.suma = 0;
        this.fila = fila;
        this.col = columna;
    }


    public List<Integer> getCamino() {
        return camino;
    }

    public void setCamino(List<Integer> camino) {
        this.camino = camino;
    }

    public boolean[][] getVisitado() {
        return visitado;
    }

    public void setVisitado(boolean[][] visitado) {
        this.visitado = visitado;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
