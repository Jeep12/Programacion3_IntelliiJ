package Tema_5.EJ11;

import java.util.HashSet;
import java.util.Set;

public class BackTracking {

    private Celda[][] matriz;
    private Solucion mejorSolucion;
    private Celda fuenteCarga;

    public BackTracking(Celda[][] matriz, Celda fuenteCarga) {
        this.fuenteCarga = fuenteCarga;
        this.matriz = matriz;
        this.mejorSolucion = null;
    }

    public Solucion caminoACarga(Celda posicionRobot) {
        Estado estado = new Estado(posicionRobot);
        caminoACarga(estado);
        return mejorSolucion;
    }

    public void caminoACarga(Estado estado) {

        System.out.println("En celda: " + estado.getCeldaActual());

        if (estado.getCeldaActual().equals(fuenteCarga)) {
            System.out.println("Encontré fuente en: " + estado.getCeldaActual());



        } else {
            Celda celdaActual = estado.getCeldaActual();
            int f = celdaActual.getFila();
            int c = celdaActual.getColumna();

            Set<Celda> visitados = new HashSet<>(estado.getVisitados());
            visitados.add(celdaActual);

            if (celdaActual.isAbajo() && f + 1 < matriz.length && matriz[f + 1][c].getObstaculizado() == 0 && !visitados.contains(matriz[f + 1][c])) {
                Estado hijo = new Estado(matriz[f + 1][c]);
                hijo.setCantPasos(estado.getCantPasos() + 1);
                hijo.setVisitados(visitados);
                caminoACarga(hijo);
            }
            if (celdaActual.isIzquierda() && c - 1 >= 0 && matriz[f][c - 1].getObstaculizado() == 0 && !visitados.contains(matriz[f][c - 1])) {
                Estado hijo = new Estado(matriz[f][c - 1]);
                hijo.setCantPasos(estado.getCantPasos() + 1);
                hijo.setVisitados(visitados);
                caminoACarga(hijo);
            }
            if (celdaActual.isDerecha() && c + 1 < matriz[0].length && matriz[f][c + 1].getObstaculizado() == 0 && !visitados.contains(matriz[f][c + 1])) {
                Estado hijo = new Estado(matriz[f][c + 1]);
                hijo.setCantPasos(estado.getCantPasos() + 1);
                hijo.setVisitados(visitados);
                caminoACarga(hijo);
            }
            if (celdaActual.isArriba() && f - 1 >= 0 && matriz[f - 1][c].getObstaculizado() == 0 && !visitados.contains(matriz[f - 1][c])) {
                Estado hijo = new Estado(matriz[f - 1][c]);
                hijo.setCantPasos(estado.getCantPasos() + 1);
                hijo.setVisitados(visitados);
                caminoACarga(hijo);
            }
        }
    }

}
