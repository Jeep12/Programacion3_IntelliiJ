package Tema_5.EJ2;

public class Casilla {

    private int posFila, posColumna;
    private Integer valor;
    private boolean puedeNorte, puedeSur, puedeEste, puedeOeste;

    public Casilla(Integer valor) {
        this.valor = valor;
    }

    public Casilla(Integer valor, int fila, int columna) {
        this.valor = valor;
        this.posFila = fila;
        this.posColumna = columna;
    }

    public Casilla(boolean puedeNorte, boolean puedeEste, boolean puedeOeste, boolean puedeSur, Integer valor, int fila, int columna) {
        this.valor = valor;
        this.posFila = fila;
        this.posColumna = columna;
        this.puedeNorte = puedeNorte;
        this.puedeEste = puedeEste;
        this.puedeOeste = puedeOeste;
        this.puedeSur = puedeSur;
    }

    public void setPosicion(int fila, int columna) {
        this.posFila = fila;
        this.posColumna = columna;
    }

    public int getPosFila() {
        return posFila;
    }

    public int getPosColumna() {
        return posColumna;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public boolean isPuedeSur() {
        return puedeSur;
    }

    public void setPuedeSur(boolean puedeSur) {
        this.puedeSur = puedeSur;
    }

    public boolean isPuedeOeste() {
        return puedeOeste;
    }

    public void setPuedeOeste(boolean puedeOeste) {
        this.puedeOeste = puedeOeste;
    }

    public boolean isPuedeNorte() {
        return puedeNorte;
    }

    public void setPuedeNorte(boolean puedeNorte) {
        this.puedeNorte = puedeNorte;
    }

    public boolean isPuedeEste() {
        return puedeEste;
    }

    public void setPuedeEste(boolean puedeEste) {
        this.puedeEste = puedeEste;
    }
}
