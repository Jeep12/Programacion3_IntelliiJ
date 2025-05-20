package Tema_5.EJ1;

import Tema_4.Base.GrafoDirigido;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GrafoDirigido<String>grafo = new GrafoDirigido<>();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarVertice(7);


        grafo.agregarArco(1,2,"");
        grafo.agregarArco(2,3,"");
        grafo.agregarArco(2,5,"");
        grafo.agregarArco(3,4,"");
        grafo.agregarArco(4,5,"");
        grafo.agregarArco(5,6,"");
        grafo.agregarArco(6,7,"");


        BackTraking back = new BackTraking(grafo);


        List<Integer> caminoMasLargo = back.caminoMasLargo(1,7);


        System.out.println(caminoMasLargo);












    }

}
