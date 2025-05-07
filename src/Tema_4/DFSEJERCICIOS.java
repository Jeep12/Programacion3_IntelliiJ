package Tema_4;

import Tema_4.Base.Grafo;

import java.util.*;

public class DFSEJERCICIOS {

    public static <T> void avisarVuelta(Grafo<T> grafo, Integer origen) {

        Set<Integer> visitados = new HashSet<>();//LA COLECCION SET NO PERMITE ELEMENTOS DUPLICADOS
        System.out.println("El origen del recorrimiento dfs empieza del origen " + origen);
        avisarVuelta(grafo, origen, visitados);

    }

    private static <T> void avisarVuelta(Grafo<T> grafos, Integer vActual, Set<Integer> visitados) {

        if (visitados.contains(vActual)) { //Si el vertice actual esta en la lista de visitados.
            return;
        }
        visitados.add(vActual);//marcamos como visitado el vertice actual
        System.out.println("→ Visito el vértice " + vActual);

        Iterator<Integer> it = grafos.obtenerAdyacentes(vActual);//Obtengo los vertices destinos de la lista arcos del vertice actual

        if (it != null) {
            while (it.hasNext()) {
                Integer value = it.next();
                System.out.print("  └─ El vértice " + vActual + " tiene   adyacente a " + value);

                if (visitados.contains(value)) {
                    System.out.println(" Este vertice " + value + " ya fue visitado");
                } else {
                    System.out.println(" Vertice actual " + vActual);
                    avisarVuelta(grafos, value, visitados);
                    System.out.println("Vuelvo del vertice " + value + " al vertice " + vActual);

                }

            }
        }
    }

    public static <T> boolean esCiclico(Grafo<T> grafo) {
        Map<Integer, String> visitados = new HashMap<>();

        // Inicializo todos en BLANCO
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer v = vertices.next();
            visitados.put(v, "BLANCO");
            System.out.println("Inicio: vértice " + v + " en BLANCO");
        }

        // reinicio el iterator
        vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            if (visitados.get(vertice).equals("BLANCO")) {
                System.out.println("Empiezo DFS desde " + vertice);
                if (esCiclico(grafo, vertice, visitados)) {
                    System.out.println("Ciclo encontrado!");
                    return true;
                }
            }
        }

        System.out.println("No se encontraron ciclos.");
        return false;
    }

    private static <T> boolean esCiclico(Grafo<T> grafo, Integer vActual, Map<Integer, String> visitados) {
        visitados.put(vActual, "AMARILLO");
        System.out.println("Visito " + vActual + " y lo marco AMARILLO");

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vActual);
        if (adyacentes != null) {
            while (adyacentes.hasNext()) {
                Integer adyacente = adyacentes.next();
                System.out.println("  " + vActual + " -> adyacente: " + adyacente + " (" + visitados.get(adyacente) + ")");

                if (visitados.get(adyacente).equals("AMARILLO")) {
                    System.out.println("  ⚠️  Ciclo detectado: " + adyacente + " ya está AMARILLO");
                    return true;
                }

                if (visitados.get(adyacente).equals("BLANCO")) {
                    if (esCiclico(grafo, adyacente, visitados)) {
                        return true;
                    } else {
                    }
                    System.out.println("Vuelvo del vertice " + adyacente + " al vertice " + vActual);
                }
            }
        }

        visitados.put(vActual, "NEGRO");
        System.out.println("Marco " + vActual + " como NEGRO (completado)");
        return false;
    }


    public static <T> boolean puedeAlcanzarATodos(Grafo<T> grafo, Integer verticeDado) {
        if (!grafo.contieneVertice(verticeDado)) return false;

        Set<Integer> visitados = new HashSet<>();
        dfs(grafo, verticeDado, visitados);

        return visitados.size() == grafo.cantidadVertices();
    }

    private static <T> void dfs(Grafo<T> grafo, Integer actual, Set<Integer> visitados) {
        visitados.add(actual);
        Iterator<Integer> it = grafo.obtenerAdyacentes(actual);
        while (it.hasNext()) {
            Integer sig = it.next();
            if (!visitados.contains(sig)) {
                dfs(grafo, sig, visitados);
            }
        }
    }




    public static <T> boolean existeCamino(Grafo<T> grafo, Integer verticeOrigen, Integer verticeDestino) {
        Set<Integer> visitados = new HashSet<>();
        if ((grafo.contieneVertice(verticeOrigen)) && (grafo.contieneVertice(verticeDestino))) {
            return existeCamino(grafo, verticeOrigen, verticeDestino, visitados);
        }

        return false;


    }
    public static <T> boolean existeCamino(Grafo<T> grafo, Integer verticeActual, Integer verticeDestino, Set<Integer> visitados) {
        visitados.add(verticeActual);

        if (verticeActual.equals(verticeDestino)) {
            return true;
        } else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(verticeActual);

            while (adyacentes.hasNext()) {
                Integer adyacente = adyacentes.next();
                if (!visitados.contains(adyacente)) {
                    return existeCamino(grafo, adyacente, verticeDestino, visitados);
                }
            }
        }


        return false;
    }

    public static <T> void recorrerColores(Grafo<T> grafo) {
        Map<Integer, String> colores = new HashMap<>();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            colores.put(vertice, "BLANCO");
        }

        vertices = grafo.obtenerVertices();

        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            if (colores.get(vertice).equals("BLANCO")) {
                System.out.println("\n>>> Empezando DFS desde el vértice: " + vertice);
                recorrerColores(grafo, vertice, colores);
            }
        }
    }

    public static <T> void recorrerColores(Grafo<T> grafo, Integer vActual, Map<Integer, String> colores) {
        colores.put(vActual, "AMARILLO");
        System.out.println("Visitamos el vértice " + vActual + " -> lo pintamos de AMARILLO");

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vActual);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            System.out.println("Vértice actual: " + vActual + " | Adyacente: " + adyacente);

            if (colores.get(adyacente).equals("BLANCO")) {
                System.out.println("El adyacente " + adyacente + " está BLANCO → hacemos DFS recursivo");
                recorrerColores(grafo, adyacente, colores);
                System.out.println("Volvemos del vértice " + adyacente + " al vértice " + vActual);
            } else if (colores.get(adyacente).equals("AMARILLO")) {
                System.out.println("¡Ciclo detectado! El vértice " + adyacente + " ya estaba AMARILLO");
            } else if (colores.get(adyacente).equals("NEGRO")) {
                System.out.println("El adyacente " + adyacente + " ya fue procesado (NEGRO)");
            }
        }

        colores.put(vActual, "NEGRO");
        System.out.println("Terminamos de procesar el vértice " + vActual + " → lo pintamos de NEGRO");
    }


}
