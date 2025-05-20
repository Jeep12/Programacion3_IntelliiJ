package Tema_5.EJ11;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BackTracking {

    private Celda[][] matriz;
    private Solucion mejorSolucion;
    private Celda fuenteCarga;


    public BackTracking(Celda[][] matriz, Celda fuenteCarga) {
        this.matriz = matriz;
        this.mejorSolucion = new Solucion();
    }

    public Solucion caminoACarga(Celda posicionRobot) {

        Estado estado = new Estado(posicionRobot);
        caminoACarga(estado);
        return mejorSolucion;
    }

    public void caminoACarga(Estado estado) {
        estado.addVisitado(estado.getCeldaActual());

        if (estado.getCeldaActual().equals(fuenteCarga)) {//estado final
            if (mejorSolucion == null || estado.getCantPasos() < this.mejorSolucion.getCantPasos()) {
                this.mejorSolucion.setSolucion(new HashSet<>(estado.getVisitados()));
                this.mejorSolucion.setCantPasos(estado.getCantPasos());
            }
        } else {
            //Se puede?
            //    for (Celda[] celdaActual : matriz){
            //      for (Celda posActual : celdaActual){
            //        System.out.println( " " + posActual );
            //  }
            // }

            List<Celda> hijos = generarHijos(estado.getCeldaActual());
            for (Celda celdaActual : hijos) {
                if (!estado.getVisitados().contains(celdaActual)) {

                    //Es poda?
                    if (celdaActual.getObstaculizado() != 1) {
                        estado.setCeldaActual(celdaActual);
                        estado.addVisitado(celdaActual);

                        caminoACarga(estado);

                        estado.restarCantPasos();
                        estado.removetVisitado();


                    }

                }

            }


        }

    }

    public void poda(Estado estado) {

    }

    private List<Celda> generarHijos(Celda actual) {
        List<Celda> hijos = new LinkedList<>();

        int f = actual.getFila();
        int c = actual.getColumna();
        int filas = matriz.length;
        int columnas = matriz[0].length;

        // ARRIBA
        if (actual.isArriba() && f > 0) {
            Celda arriba = matriz[f - 1][c];
            if (arriba != null && arriba.getObstaculizado() == 0) {
                hijos.add(arriba);
            }
        }

        // ABAJO
        if (actual.isAbajo() && f < filas - 1) {
            Celda abajo = matriz[f + 1][c];
            if (abajo != null && abajo.getObstaculizado() == 0) {
                hijos.add(abajo);
            }
        }

        // IZQUIERDA
        if (actual.isIzquierda() && c > 0) {
            Celda izquierda = matriz[f][c - 1];
            if (izquierda != null && izquierda.getObstaculizado() == 0) {
                hijos.add(izquierda);
            }
        }

        // DERECHA
        if (actual.isDerecha() && c < columnas - 1) {
            Celda derecha = matriz[f][c + 1];
            if (derecha != null && derecha.getObstaculizado() == 0) {
                hijos.add(derecha);
            }
        }

        return hijos;
    }


}
