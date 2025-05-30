package Tema_4.OTRO;

import Tema_4.Base.Grafo;
import Tema_4.Base.GrafoDirigido;

public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo = new GrafoDirigido<>();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarVertice(7);

        grafo.agregarArco(1,2,"");
        grafo.agregarArco(1,3,"");
        grafo.agregarArco(2,1,"");
        grafo.agregarArco(3,2,"");
        grafo.agregarArco(2,4,"");
        grafo.agregarArco(4,5,"");
        grafo.agregarArco(4,6,"");
        grafo.agregarArco(5,6,"");
        grafo.agregarArco(7,4,"");
        grafo.agregarArco(5,2,"");


        DFSExisteCamino dfs = new DFSExisteCamino(grafo);

        System.out.println(dfs.existeCamino(1,5));
    }
}
