package PracticaParciales.recuperatorior2024quequen.greedy.EJ1;

import Tema_4.Base.Grafo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DFS<T> {
    private Grafo<T> grafo;
    private Set<Integer> visitados;

    public DFS(Grafo<T> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
    }

    public boolean dfs(Integer origen, Integer destino) {
        return existeCamino(origen, destino);
    }

    private boolean existeCamino(Integer actual, Integer destino) {
        if (actual.equals(destino)) {
            return true;
        }

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();

            if (!visitados.contains(adyacente)) {
                visitados.add(adyacente);

                boolean encontrado = existeCamino(adyacente, destino);
                if (encontrado) {
                    return true;  // acá no removés porque ya salís
                }

                visitados.remove(adyacente);  // backtracking
            }
        }
        return false;
    }

}
