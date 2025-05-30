package BacktrackingDeepSeek.EJ1;

import java.util.ArrayList;
import java.util.List;

/*
1. Subconjuntos que suman un objetivo
Enunciado: Dada una lista de números enteros positivos, encuentra todos los subconjuntos que sumen un valor objetivo T.

Ejemplo:

Entrada: [2, 3, 5, 7], T = 7

Salida: [2, 5], [7]

Variante:

Permite repetición de elementos. Ejemplo: [2, 2, 3] para T = 7.
 */
public class EJ1 {
    List<Integer> conjunto;

    public EJ1(List<Integer> conjunto) {
        this.conjunto = conjunto;
    }

    public Solucion solucionSinRepetir(Integer T) {
        Solucion solucion = new Solucion();

        Estado estado = new Estado();
        solucionSinRepetir(estado, solucion, T, 0);
        return solucion;
    }

    public void solucionSinRepetir(Estado estado, Solucion solucion, Integer T, Integer indice) {
        if (estado.getSumaParcial().equals(T)) {
            solucion.getResultado().add(new ArrayList<>(estado.getCaminoParcial()));
        } else {
            for (int i = indice; i < conjunto.size(); i++) {
                Integer numero = conjunto.get(i);
                if (!estado.getVisitados().contains(numero)) {
                    if (estado.getSumaParcial() <= T) {//PODA

                        estado.getVisitados().add(numero);
                        estado.getCaminoParcial().add(numero);
                        estado.acumularActual(numero);

                        solucionSinRepetir(estado, solucion, T, i + 1);

                        estado.getVisitados().remove(numero);
                        estado.getCaminoParcial().remove(numero);
                        estado.acumularActual(-numero);

                    }
                }

            }
        }
    }


    public Solucion solucionRepetidos(Integer T) {
        Solucion solucion = new Solucion();

        Estado estado = new Estado();
        solucionRepetidos(estado, solucion, T);
        return solucion;
    }


    public void solucionRepetidos(Estado estado, Solucion solucion, Integer T) {
        if (estado.getSumaParcial().equals(T)) {
            solucion.getResultado().add(new ArrayList<>(estado.getCaminoParcial()));
        } else {
            for (Integer numero : conjunto) {

                if (estado.getSumaParcial() <= T) {//PODA

                    estado.getCaminoParcial().add(numero);
                    estado.acumularActual(numero);

                    solucionRepetidos(estado, solucion, T);

                    estado.getCaminoParcial().remove(numero);
                    estado.acumularActual(-numero);


                }

            }
        }
    }


}
