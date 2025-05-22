package Tema_5.EJ11V2;

import Tema_5.EJ11.Solucion;

import java.util.ArrayList;
import java.util.Arrays;
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

        estado.getVisitados().add(actual);
        estado.addCelda(actual);

        if (actual.equals(fuenteCarga)) {
            System.out.println("Llegue al a fuente de carga");
            if (mejorSolucion.isEmpty() || estado.getCaminoParcial().size() < mejorSolucion.size()) {
                mejorSolucion.clear();
                mejorSolucion.addAll(new ArrayList<>(estado.getCaminoParcial()));
            }
        } else {
            for (Celda vecino : vecinosValidos(actual)) {
                if (!estado.getVisitados().contains(vecino)) {

                    Celda anterior = estado.getCeldaActual();
                    estado.setCeldaActual(vecino); //Avanzamos
                    caminoACarga(estado);
                    estado.setCeldaActual(anterior); // Volvemos
                }
            }
        }
        estado.getVisitados().remove(actual);
        estado.removerUltimo();

    }


    private List<Celda> vecinosValidos(Celda c) {
        List<Celda> vecinos = new ArrayList<>();
        int f = c.getFila();
        int col = c.getColumna();

        // pregunta si desde c se puede ir arriba
        // pregunta si la fila actual no es la primera (f > 0)
        // pregunta si la celda de arriba no está obstaculizada
        if (c.isArriba() && f > 0 && matriz[f - 1][col].getObstaculizado() == 0)
            vecinos.add(matriz[f - 1][col]);

        // pregunta si desde c se puede ir abajo
        // pregunta si la fila actual no es la última (f < matriz.length - 1)
        // pregunta si la celda de abajo no está obstaculizada
        if (c.isAbajo() && f < matriz.length - 1 && matriz[f + 1][col].getObstaculizado() == 0)
            vecinos.add(matriz[f + 1][col]);

        // pregunta si desde c se puede ir a la izquierda
        // pregunta si la columna actual no es la primera (col > 0)
        // pregunta si la celda de la izquierda no está obstaculizada
        if (c.isIzquierda() && col > 0 && matriz[f][col - 1].getObstaculizado() == 0)
            vecinos.add(matriz[f][col - 1]);

        // pregunta si desde c se puede ir a la derecha
        // pregunta si la columna actual no es la última (col < matriz[0].length - 1)
        // pregunta si la celda de la derecha no está obstaculizada
        if (c.isDerecha() && col < matriz[0].length - 1 && matriz[f][col + 1].getObstaculizado() == 0)
            vecinos.add(matriz[f][col + 1]);

        return vecinos;
    }

}
