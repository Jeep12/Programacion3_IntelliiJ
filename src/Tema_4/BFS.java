package Tema_4;

import Tema_4.Base.Grafo;

import java.util.*;

public class BFS {

    public static <T> List<String> encontrarCaminoMasCorto(Grafo<String> grafo, Integer origen, Integer destino) {
        // Estructuras auxiliares
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        Map<Integer, Integer> padres = new HashMap<>();
        Map<Integer, String> calles = new HashMap<>(); // Para guardar el nombre de la calle
        List<String> caminoCompleto = new ArrayList<>();

        // Caso especial: origen igual a destino
        if (origen.equals(destino)) {
            caminoCompleto.add("Origen y destino son el mismo: " + origen);
            return caminoCompleto;
        }

        // Inicialización
        visitados.add(origen);
        cola.add(origen);
        padres.put(origen, null);

        System.out.println("\nBuscando camino más corto desde " + origen + " hasta " + destino);

        while (!cola.isEmpty()) {
            Integer actual = cola.poll();
            System.out.println("\nProcesando vértice: " + actual);

            // Si encontramos el destino, reconstruimos el camino
            if (actual.equals(destino)) {
                System.out.println("¡Destino encontrado! Reconstruyendo camino...");
                return reconstruirCaminoCompleto(grafo, padres, calles, destino);
            }

            // Procesar adyacentes
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
            while (adyacentes.hasNext()) {
                Integer adyacente = adyacentes.next();

                if (!visitados.contains(adyacente)) {
                    visitados.add(adyacente);
                    padres.put(adyacente, actual);
                    // Obtenemos el nombre de la calle/arco
                    String nombreCalle = grafo.obtenerArco(actual, adyacente).getEtiqueta().toString();
                    calles.put(adyacente, nombreCalle);
                    cola.add(adyacente);
                    System.out.println("  Desde " + actual + " hasta " + adyacente + " por: " + nombreCalle);
                }
            }
        }

        System.out.println("No se encontró camino entre " + origen + " y " + destino);
        caminoCompleto.add("No existe camino entre " + origen + " y " + destino);
        return caminoCompleto;
    }

    private static <T> List<String> reconstruirCaminoCompleto(Grafo<String> grafo,
                                                              Map<Integer, Integer> padres,
                                                              Map<Integer, String> calles,
                                                              Integer destino) {

        LinkedList<String> camino = new LinkedList<>();
        Integer actual = destino;

        while (padres.get(actual) != null) {
            Integer padre = padres.get(actual);
            String calle = calles.get(actual);
            camino.addFirst("Desde " + padre + " hasta " + actual + " por: " + calle);
            actual = padre;
        }

        camino.addFirst("Inicio en vértice: " + actual);
        return camino;
    }

}