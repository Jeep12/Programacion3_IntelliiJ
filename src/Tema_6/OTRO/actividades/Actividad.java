package Tema_6.OTRO.actividades;

public class Actividad implements Comparable<Actividad> {
    Integer tiempoInicio;
    Integer tiempoFin;

    public Actividad(Integer tiempoFin, Integer tiempoInicio) {
        this.tiempoFin = tiempoFin;
        this.tiempoInicio = tiempoInicio;
    }

    public Integer getTiempoFin() {
        return tiempoFin;
    }

    public void setTiempoFin(Integer tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

    public Integer getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(Integer tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    @Override
    public int compareTo(Actividad o) {
        return this.tiempoFin.compareTo(o.getTiempoFin());
    }

    @Override
    public String toString() {
        return "Inicio " +getTiempoInicio() + " fin " + getTiempoFin();
    }
}
