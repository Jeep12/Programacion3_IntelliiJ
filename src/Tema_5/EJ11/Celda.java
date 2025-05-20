package Tema_5.EJ11;

public class Celda {

    int fila,columna;
    boolean arriba,abajo,izquierda,derecha;
    int obstaculizado;

    public Celda(int obstaculizado ,boolean abajo,boolean izquierda, boolean derecha, boolean arriba,int fila,int columna) {
        this.abajo = abajo;
        this.obstaculizado = obstaculizado;
        this.izquierda = izquierda;
        this.derecha = derecha;
        this.arriba = arriba;
        this.fila = fila;
        this.columna = columna;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public boolean isAbajo() {
        return abajo;
    }

    public void setAbajo(boolean abajo) {
        this.abajo = abajo;
    }

    public boolean isArriba() {
        return arriba;
    }

    public void setArriba(boolean arriba) {
        this.arriba = arriba;
    }

    public boolean isIzquierda() {
        return izquierda;
    }

    public void setIzquierda(boolean izquierda) {
        this.izquierda = izquierda;
    }

    public int getObstaculizado() {
        return obstaculizado;
    }

    public void setObstaculizado(int obstaculizado) {
        this.obstaculizado = obstaculizado;
    }

    public boolean isDerecha() {
        return derecha;
    }

    public void setDerecha(boolean derecha) {
        this.derecha = derecha;
    }

    @Override
    public String toString() {
        return "Celda{" +
                "fila=" + fila +
                ", columna=" + columna +
                ", obstaculziada " + this.getObstaculizado() +
                '}';
    }
}
