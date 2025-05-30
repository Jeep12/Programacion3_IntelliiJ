package Tema_5.EJ10;


/*
Utilizando la técnica Backtracking, escriba un algoritmo que dado un conjunto de números enteros,
devuelva (si existen) todos los subconjuntos de tamaño N (dado como parámetro), cuyas sumas
sean exactamente cero. Por ejemplo dado el conjunto {-7, -3, -2, -1, 5, 8 } y N = 3, los subconjuntos
que suman cero son: {-7, -1, 8} y {-3, -2, 5}.

 Input: Conjunto de numeros enteros, Tamañno N

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Backtracking {
    List<Integer> conjunto;
    Solucion mejorSolucion;

    public Backtracking(List<Integer> conjunto) {
        this.conjunto = conjunto;
        this.mejorSolucion = new Solucion(new ArrayList<>());

    }


    public Solucion ejercicio(Integer N) {
        Estado estado = new Estado(new ArrayList<>(), new ArrayList<>());
        ejercicio(estado, N, 0);

        return this.mejorSolucion;
    }

    private void ejercicio(Estado estado, Integer N, Integer indice) {
        if (estado.getCaminoParcial().size() == (N)) {
            if (estado.esCero()) {
                mejorSolucion.getResultado().add(new ArrayList<>(estado.getCaminoParcial()));
            }
        } else {

            for (int i = indice; i < conjunto.size(); i++) {
                if (!estado.getVisitados().contains(conjunto.get(i))) {
                    estado.getVisitados().add(conjunto.get(i));
                    estado.getCaminoParcial().add(conjunto.get(i));

                    ejercicio(estado, N, i + 1);

                    estado.getVisitados().remove(conjunto.get(i));
                    estado.getCaminoParcial().remove(conjunto.get(i));

                }
            }

        }
    }

}
