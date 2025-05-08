package Tema_4;

import Tema_4.Base.Grafo;

import java.util.*;

public class EJERCICIO4 {

    public static <T> List<Integer> caminoMayor(Grafo<T> grafo, Integer verticeOrigen, Integer verticeDestino) {
        Set<Integer> visitados = new HashSet<>();
        List<Integer> caminoMayor = new ArrayList<>();
        List<Integer> caminoParcial = new ArrayList<>();

        if (grafo.contieneVertice(verticeDestino) && grafo.contieneVertice(verticeOrigen)) {
            caminoMayor(grafo, verticeOrigen, verticeDestino, caminoMayor, caminoParcial, visitados);
        }


        return caminoMayor;

    }

    public static <T> void caminoMayor(
            Grafo<T> grafo,
            Integer vActual,
            Integer vDestino,
            List<Integer> caminoMayor,
            List<Integer> caminoParcial,
            Set<Integer> visitados) {

        //Marco visitado al vertice actual
        System.out.println("marco visitado al vertice " + vActual);
        visitados.add(vActual);
        //agrego el vertice actual al camino parcial
        caminoParcial.add(vActual);
        System.out.println("agrego el vertice  " + vActual + " al camino parcial " + " size caminoParcial " + caminoParcial.size());

        if (vActual.equals(vDestino)) {
            System.out.println("Llegamos al destino vertice actual: " + vActual + " destino " + vDestino);
            if (caminoParcial.size() > caminoMayor.size()) {
                caminoMayor.clear();
                caminoMayor.addAll(caminoParcial);
            }
        } else {

            Iterator<Integer> vertices = grafo.obtenerAdyacentes(vActual);

            while (vertices.hasNext()) {
                Integer vertice = vertices.next();
                if (!visitados.contains(vertice)) {
                    System.out.println("este adyacente aun no fue visitado " + vertice);
                    caminoMayor(grafo, vertice, vDestino, caminoMayor, caminoParcial, visitados);
                    System.out.println("Vuelvo del vertice " + vertice + " al vertice " + vActual);
                } else {

                    System.out.println("Este adyacente " + vertice + " ya fue visitado");
                }
            }

        }

        System.out.println("ultimo camino alcanzado" + caminoMayor);
        System.out.println("Borro el último elemento del camino parcial: " + caminoParcial.get(caminoParcial.size() - 1));

        caminoParcial.remove(caminoParcial.size()-1);
        visitados.remove(vActual);
    }

}
