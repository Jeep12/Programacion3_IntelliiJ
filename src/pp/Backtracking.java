package pp;

import Tema_5.Varios.GP4.Solucion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Backtracking {
    List<Integer> conjunto;


    public Backtracking(List<Integer> conjunto) {
        this.conjunto = conjunto;
    }

    public Solucion solucionar1(Integer suma) {
        Solucion solucion = new Solucion();
        Estado estado = new Estado();
        solucionar1(estado, solucion, suma, 0);

        return solucion;
    }

    private void solucionar1(Estado estado, Solucion solucion, Integer sumaBuscada, Integer indice) {
        if (estado.getSumaParcial().equals(sumaBuscada)) {
            solucion.getResultado().add(new ArrayList<>(estado.getCaminoParcial()));
        } else {

            for (int i = indice; i < conjunto.size(); i++) {
                Integer numero = conjunto.get(i);
                if (!estado.getVisitados().contains(numero)) {

                    estado.getVisitados().add(numero);
                    estado.getCaminoParcial().add(numero);
                    estado.aculumarSuma(numero);

                    solucionar1(estado, solucion, sumaBuscada, i + 1);

                    estado.aculumarSuma(-numero);
                    estado.getCaminoParcial().remove(estado.getCaminoParcial().size() - 1);
                    estado.getVisitados().remove(numero);


                }

            }

        }
    }


    public Solucion solucionar2(Integer suma) {
        Solucion solucion = new Solucion();
        Estado estado = new Estado();
        solucionar2(estado, solucion, suma);
        List<Integer> algo = new ArrayList<>();

        return solucion;
    }

    private void solucionar2(Estado estado, Solucion solucion, Integer sumaBuscada ) {
        if (estado.getSumaParcial().equals(sumaBuscada)) {

            List<Integer>solucionParcial = new ArrayList<>(estado.getCaminoParcial());

            Collections.sort(solucionParcial);

            solucion.getResultado().add(solucionParcial);

        } else {

            for (int i = 0; i < conjunto.size(); i++) {
                Integer numero = conjunto.get(i);
                if (!estado.getVisitados().contains(numero)) {

                    estado.getVisitados().add(numero);
                    estado.getCaminoParcial().add(numero);
                    estado.aculumarSuma(numero);

                    solucionar2(estado, solucion, sumaBuscada );

                    estado.aculumarSuma(-numero);
                    estado.getCaminoParcial().remove(estado.getCaminoParcial().size() - 1);
                    estado.getVisitados().remove(numero);


                }

            }

        }
    }

}
