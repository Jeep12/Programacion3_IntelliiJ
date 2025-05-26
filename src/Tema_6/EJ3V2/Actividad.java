package Tema_6.EJ3V2;

public class Actividad implements Comparable<Actividad> {
    Integer comienzo;
    Integer fin;

    public Actividad(Integer comienzo, Integer fin) {
        this.comienzo = comienzo;
        this.fin = fin;
    }

    public Integer getComienzo() {
        return comienzo;
    }

    public void setComienzo(Integer comienzo) {
        this.comienzo = comienzo;
    }

    public Integer getFin() {
        return fin;
    }

    public void setFin(Integer fin) {
        this.fin = fin;
    }

    @Override
    public int compareTo(Actividad o) {
        return this.fin.compareTo(o.fin);
    }
}
