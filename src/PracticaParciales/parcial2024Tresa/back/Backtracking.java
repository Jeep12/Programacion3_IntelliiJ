package PracticaParciales.parcial2024Tresa.back;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Backtracking {
    public final Integer MAXSUBCONJUNTOS = 4;

    private List<Integer> conjunto;

    public Backtracking(List<Integer> conjunto) {
        this.conjunto = conjunto;
    }

    public Solucion ejercicio4(Integer sumaBuscada) {
        Solucion solucion = new Solucion();
        Estado estado = new Estado();
        ejercicio4(estado, solucion, sumaBuscada,0);

        return solucion;
    }


    // En la clase Backtracking
    public void ejercicio4(Estado estado, Solucion solucion, Integer sumaBuscada,Integer indice) {
        if (estado.getSumaActual().equals(sumaBuscada)) {
            // Verificamos que no hayamos excedido el número de subconjuntos
            if (solucion.getResultado().size() < MAXSUBCONJUNTOS) {
                solucion.addResultado(new ArrayList<>(estado.getCaminoParcial()));

                Estado nuevoEstado = new Estado();
                nuevoEstado.setVisitados(estado.getVisitados());
                nuevoEstado.setSumaActual(0);
                ejercicio4(nuevoEstado,solucion,sumaBuscada,0);
            }

        }


        for (Integer numero : conjunto) {
            if (!estado.getVisitados().contains(numero)) {

                if (estado.getSumaActual() < sumaBuscada) {
                    estado.getVisitados().add(numero);
                    estado.getCaminoParcial().add(numero);
                    estado.sumar(numero);


                    ejercicio4(estado, solucion, sumaBuscada,0);

                    estado.sumar(-numero);
                    estado.getCaminoParcial().remove(numero); // Corregido
                    estado.getVisitados().remove(numero); // Corregido
                }
            }
        }
    }
}
