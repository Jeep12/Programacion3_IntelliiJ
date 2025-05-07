package Tema_4;

import Tema_4.Base.Grafo;
import Tema_4.Base.GrafoDirigido;

import java.util.*;

/**
 * Clase que proporciona métodos estáticos para detectar ciclos en un grafo dirigido
 * mediante un algoritmo de búsqueda en profundidad (DFS) usando colores.
 */
public class DFS {

    /**
     * Realiza una búsqueda en profundidad (DFS) en el grafo para detectar ciclos.
     * Utiliza tres colores para marcar el estado de cada vértice:
     * <ul>
     *   <li>BLANCO: no visitado</li>
     *   <li>AMARILLO: en proceso (en la pila de recursión)</li>
     *   <li>NEGRO: completamente procesado</li>
     * </ul>
     * <p>
     * Imprime la traza de la recursión y detiene la búsqueda al encontrar el primer ciclo.
     * </p>
     *
     * @param <T>   el tipo de etiqueta utilizado en los arcos del grafo
     * @param grafo el grafo dirigido en el cual buscar ciclos
     * @return {@code true} si se detecta al menos un ciclo, {@code false} en caso contrario
     */
    public static <T> boolean tieneCiclo(GrafoDirigido<T> grafo) {
        Map<Integer, String> colores = new HashMap<>();

        // Inicializar todos los vértices en color BLANCO
        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()) {
            Integer vertice = it.next();
            colores.put(vertice, "BLANCO");
        }

        //
        it = grafo.obtenerVertices();
        while (it.hasNext()) {
            Integer vertice = it.next();
            if (colores.get(vertice).equals("BLANCO")) {
                System.out.println("Iniciando DFS desde vértice " + vertice);
                if (dfsVisit(grafo, vertice, colores)) {
                    System.out.println("Ciclo detectado, se detiene búsqueda. Último vértice analizado: " + vertice);
                    return true;
                }
            }
        }

        System.out.println("No se detectaron ciclos.");
        return false;
    }

    /**
     * Método recursivo auxiliar para la búsqueda en profundidad (DFS).
     * Marca el vértice actual como en proceso y recorre sus adyacentes.
     * Detecta ciclos al encontrar un arco hacia un vértice en proceso.
     *
     * @param <T>     el tipo de etiqueta utilizado en los arcos del grafo
     * @param grafo   el grafo dirigido que se está explorando
     * @param u       el identificador del vértice actual en la recursión
     * @param colores mapa que asocia cada vértice a su color (BLANCO, AMARILLO, NEGRO)
     * @return {@code true} si se detecta un ciclo en la rama actual, {@code false} en caso contrario
     */
    private static <T> boolean dfsVisit(GrafoDirigido<T> grafo, Integer u, Map<Integer, String> colores) {
        // Marca el vértice como en proceso (AMARILLO)
        colores.put(u, "AMARILLO");
        System.out.println("visitando vértice: " + u + " pintado de AMARILLO");

        Iterator<Integer> it = grafo.obtenerAdyacentes(u);
        if (it != null) {
            while (it.hasNext()) {
                Integer v = it.next();

                // Verificamos que el vértice exista en nuestro mapa de colores
                String color = colores.get(v);
                if (color == null) {
                    // Este caso no debería ocurrir si el grafo está bien implementado
                    // pero por robustez lo tratamos
                    System.out.println("Advertencia: Vértice " + v + " no inicializado en el mapa de colores");
                    colores.put(v, "BLANCO");
                    color = "BLANCO";
                }

                // Si es blanco no fue visitado, seguimos con la recursión
                if (color.equals("BLANCO")) {
                    System.out.println("Explorando arco: " + u + " -> " + v);
                    if (dfsVisit(grafo, v, colores)) {
                        return true;
                    }
                }
                // Si es amarillo ya fue visitado y está en proceso: encontramos un ciclo
                else if (color.equals("AMARILLO")) {
                    System.out.println("Ciclo detectado! Arco " + u + " -> " + v + " (vértice " + v + " ya está en proceso)");
                    return true;
                }
                // Si es negro, ya fue completamente procesado, no hay ciclo por aquí
                else {
                    System.out.println("Vértice " + v + " ya procesado (NEGRO), continuamos");
                }
            }
        }

        // Marca el vértice como completamente procesado (NEGRO)
        colores.put(u, "NEGRO");
        System.out.println("Vértice: " + u + " pintado de NEGRO (completamente procesado)");
        return false;
    }

    public static <T> List<Integer> caminoMasLargo(Integer verticeOrigen, Integer verticeDestino, GrafoDirigido<T> grafo) {
        List<Integer> resultado = new ArrayList<>();
        Map<Integer, String> colores = new HashMap<>();

        // Inicializar todos los vértices en color BLANCO
        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()) {
            Integer v = it.next();
            colores.put(v, "BLANCO");
        }

        // Para cada vértice en BLANCO, iniciar DFS
        it = grafo.obtenerVertices();
        while (it.hasNext()) {
            Integer v = it.next();
            if (colores.get(v).equals("BLANCO")) {
                System.out.println("Iniciando DFS desde vértice " + v);
                caminoMasLargo(grafo,verticeOrigen,verticeDestino,resultado,colores);

            }
        }

        System.out.println("No se detectaron ciclos.");

        return resultado;
    }

    private static <T> void caminoMasLargo(Grafo<T> grafo, Integer vOrigen, Integer vDestino, List<Integer> resultado, Map<Integer, String> colores) {
        // Marca el vértice como en proceso (AMARILLO)
        colores.put(vOrigen, "AMARILLO");
        System.out.println("visitando vértice: " + vOrigen + " pintado de AMARILLO");
        resultado.add(vDestino);
        Iterator<Integer> it = grafo.obtenerAdyacentes(vOrigen);
        if (it != null) {
            while (it.hasNext()) {
                Integer v = it.next();

                // Verificamos que el vértice exista en nuestro mapa de colores
                String color = colores.get(v);
                if (color == null) {

                    System.out.println("Advertencia: Vértice " + v + " no inicializado en el mapa de colores");
                    colores.put(v, "BLANCO");
                    color = "BLANCO";
                }



            }
        }

        // Marca el vértice como completamente procesado (NEGRO)




    }
}