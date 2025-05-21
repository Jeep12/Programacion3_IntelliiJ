package Tema_5.EJ11;

import java.util.Set;

public class Solucion {
    Set<Celda> solucion;
    Integer cantPasos;

    public Solucion() {
        this.cantPasos = 0;
        this.solucion = null;
    }

    public Integer getCantPasos() {
        return cantPasos;
    }

    public void setCantPasos(Integer cantPasos) {
        this.cantPasos = cantPasos;
    }

    public Set<Celda> getSolucion() {
        return solucion;
    }

    public void setSolucion(Set<Celda> solucion) {
        this.solucion = solucion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cantidad de pasos: ").append(cantPasos).append("\n");
        sb.append("Camino:\n");
        if (solucion != null) {
            for (Celda c : solucion) {
                sb.append(" -> (").append(c.getFila()).append(", ").append(c.getColumna()).append(")\n");
            }
        }
        return sb.toString();
    }
}
