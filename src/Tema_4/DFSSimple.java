package Tema_4;

import Tema_4.Base.GrafoDirigido;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Implementación básica del recorrido DFS (Depth First Search) para grafos dirigidos
public class DFSSimple {

    // Método que inicia el recorrido DFS desde un vértice dado
    public static <T> void recorridoDFS(GrafoDirigido<T> grafo, Integer inicio) {
        Set<Integer> visitados = new HashSet<>(); // Conjunto para marcar vértices ya visitados
        System.out.println("Inicio DFS desde el vértice " + inicio);
        dfsRecursivo(grafo, inicio, visitados); // Llamada recursiva inicial
    }

    // Método recursivo que realiza el recorrido en profundidad
    private static <T> void dfsRecursivo(GrafoDirigido<T> grafo, Integer actual, Set<Integer> visitados) {
        // Si ya visité este vértice, corto la recursión
        if (visitados.contains(actual)) {
            return;
        }


        // Marco el vértice como visitado
        visitados.add(actual);
        System.out.println("→ Visito el vértice " + actual);

        // Obtengo los adyacentes del vértice actual
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
        if (adyacentes != null) {
            while (adyacentes.hasNext()) {
                Integer adyacente = adyacentes.next();
                System.out.print("  └─ El vértice " + actual + " tiene   adyacente a " + adyacente);
                if (visitados.contains(adyacente)) {
                    System.out.println(" (ya visitado)");
                } else {
                    System.out.println();
                    dfsRecursivo(grafo, adyacente, visitados);
                    System.out.println("↩ Vuelvo al vértice " + actual + " desde " + adyacente);

                }
            }

        }
        System.out.println("↩ Terminé con el vértice " + actual); // fuera del while

    }
}
