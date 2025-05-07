package Tema_4;

import Tema_4.Base.Grafo;
import Tema_4.Base.GrafoDirigido;

import java.util.*;

public class CaminoMasLargo {

    public static <T> List<Integer> caminoMasLargo(Integer verticeOrigen, Integer verticeDestino, GrafoDirigido<T> grafo) {
        List<Integer> mejorCamino = new ArrayList<>();
        List<Integer> caminoActual = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();//Visitados nos permite buscar caminos mas largos que usando colores.

        if (grafo.contieneVertice(verticeOrigen)) {
            dfsCaminoMasLargo(grafo, verticeOrigen, verticeDestino, caminoActual, mejorCamino, visitados);
        }

        return mejorCamino;
    }

    private static <T> void dfsCaminoMasLargo(
            Grafo<T> grafo,
            Integer vActual,
            Integer vDestino,
            List<Integer> caminoActual,
            List<Integer> mejorCamino,
            Set<Integer> visitados) {

        // Agregar el vértice actual al camino y marcarlo como visitado
        caminoActual.add(vActual);
        visitados.add(vActual);

        // Si llegamos al destino, comparamos con el mejor camino encontrado
        if (vActual.equals(vDestino)) {
            if (caminoActual.size() > mejorCamino.size()) {
                mejorCamino.clear();
                mejorCamino.addAll(new ArrayList<>(caminoActual));
            }
        } else {
            // Explorar todos los vértices adyacentes no visitados
            Iterator<Integer> it = grafo.obtenerAdyacentes(vActual);
            if (it != null) {
                while (it.hasNext()) {
                    Integer adyacente = it.next();
                    if (!visitados.contains(adyacente)) {
                        dfsCaminoMasLargo(grafo, adyacente, vDestino, caminoActual, mejorCamino, visitados);
                    }
                }
            }
        }

        // Backtracking: remover el vértice actual del camino y marcarlo como no visitado
        caminoActual.remove(caminoActual.size() - 1);
        visitados.remove(vActual);
    }
}