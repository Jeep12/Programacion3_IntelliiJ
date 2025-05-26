package PracticaParciales.recuperatorior2024quequen.greedy.EJ1;

import Tema_4.Base.GrafoDirigido;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido<String> grafo = new GrafoDirigido<>();

        // Agregar vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarVertice(7);


        // Agregar arcos
        //  grafo.agregarArco(1,1,"A");
        grafo.agregarArco(1, 2, "B");
        grafo.agregarArco(1, 3, "C");
        grafo.agregarArco(4, 2, "E");
        grafo.agregarArco(3, 4, "F");
        grafo.agregarArco(2, 5, "G");
        grafo.agregarArco(3, 6, "D");
        grafo.agregarArco(6, 5, "D");

        DFS dfs = new DFS<>(grafo);
        System.out.println(dfs.dfs(1,6));


    }
}
