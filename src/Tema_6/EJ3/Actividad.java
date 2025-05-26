package Tema_6.EJ3;

public class Actividad implements Comparable<Actividad> {
    int comienzo;
    int fin;

    public Actividad(int comienzo, int fin) {
        this.comienzo = comienzo;
        this.fin = fin;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getComienzo() {
        return comienzo;
    }

    public void setComienzo(int comienzo) {
        this.comienzo = comienzo;
    }

    @Override
    public int compareTo(Actividad otra) {
        return Integer.compare(this.fin, otra.fin); // ordenar por tiempo de fin ascendente
    }
    @Override
    public String toString() {
        return "[" + comienzo + ", " + fin + ")";
    }
}
