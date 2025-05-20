package Tema_5.EJ1;

import Tema_4.Base.Grafo;

import java.util.*;

public class BackTraking {

    private Grafo<?> grafo;
    private List<Integer> mejorSolucion;

    public BackTraking(Grafo<?> grafo) {
        this.grafo = grafo;
        this.mejorSolucion = new ArrayList<>();
    }

    public List<Integer> caminoMasLargo(Integer entrada, Integer salida) {
        Estado estado = new Estado(entrada);
        estado.getVisitados().add(entrada);
        estado.addCaminoParcial(entrada);
        caminoMasLargo(estado, salida);
        return mejorSolucion;
    }

    private void caminoMasLargo(Estado estado, Integer salida) {
        if (estado.getvActual().equals(salida)) {
            if (estado.esMejorSolucion(mejorSolucion)) {
                mejorSolucion.clear();
                mejorSolucion.addAll(estado.getCaminoParcial());
            }
            return;
        }

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(estado.getvActual());
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            if (!estado.getVisitados().contains(adyacente)) {
                estado.getVisitados().add(adyacente);
                estado.addCaminoParcial(adyacente);
                estado.setvActual(adyacente);

                caminoMasLargo(estado, salida);

                estado.removerUltimo(); // quita de camino parcial
                estado.getVisitados().remove(adyacente);
                estado.setvActual(estado.getCaminoParcial().get(estado.getCaminoParcial().size() - 1));
            }
        }
    }
}
