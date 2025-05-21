package Tema_5.EJ11V2;

import Tema_5.EJ11.Solucion;

import java.util.ArrayList;
import java.util.List;

public class BackTracking {

    private Celda[][] matriz;
    private List<Celda> mejorSolucion;
    private Celda fuenteCarga;

    public BackTracking(Celda fuenteCarga, Celda[][] matriz) {
        this.fuenteCarga = fuenteCarga;
        this.matriz = matriz;
        this.mejorSolucion = new ArrayList<>();
    }

    public List<Celda> caminoACarga(Celda posRobot) {

        Estado estado = new Estado(posRobot);
        caminoACarga(estado);
        return this.mejorSolucion;
    }

    private void caminoACarga(Estado estado) {
        Celda actual = estado.getCeldaActual();

        estado.getVisitados().add(actual); // ✅ Marcar como visitado
        estado.addCelda(actual);           // ✅ Agregar al camino

        if (actual.equals(fuenteCarga)) {
            System.out.println("Llegue al a fuente de carga");
            if (mejorSolucion.isEmpty() || estado.getCaminoParcial().size() < mejorSolucion.size()) {
                mejorSolucion.clear();
                mejorSolucion.addAll(new ArrayList<>(estado.getCaminoParcial()));
            }
        } else {
            for (Celda vecino : vecinosValidos(actual)) {
                if (!estado.getVisitados().contains(vecino)) {
                    // Hacemos backup del estado actual
                    Celda anterior = estado.getCeldaActual();

                    estado.setCeldaActual(vecino);
                    caminoACarga(estado);
                    estado.setCeldaActual(anterior); // 🔙 volver atrás
                }
            }
        }

        estado.getVisitados().remove(actual);  // 🔁 Backtrack
        estado.removerUltimo();                // 🔁 Backtrack
    }


    private List<Celda> vecinosValidos(Celda c) {
        List<Celda> vecinos = new ArrayList<>();
        int f = c.getFila();
        int col = c.getColumna();

        if (c.isArriba() && f > 0 && matriz[f - 1][col].getObstaculizado() == 0)
            vecinos.add(matriz[f - 1][col]);

        if (c.isAbajo() && f < matriz.length - 1 && matriz[f + 1][col].getObstaculizado() == 0)
            vecinos.add(matriz[f + 1][col]);

        if (c.isIzquierda() && col > 0 && matriz[f][col - 1].getObstaculizado() == 0)
            vecinos.add(matriz[f][col - 1]);

        if (c.isDerecha() && col < matriz[0].length - 1 && matriz[f][col + 1].getObstaculizado() == 0)
            vecinos.add(matriz[f][col + 1]);

        return vecinos;
    }

}
