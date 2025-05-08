package Tema_4;

import Tema_4.Base.Grafo;
import Tema_4.Base.GrafoDirigido;
import Tema_4.Base.Arco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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


        grafo.agregarArco(5, 1, "H");
        grafo.agregarArco(5, 7, "<z>");
        grafo.agregarArco(2, 7, "asd");


        //System.out.println(CaminoMasLargo.caminoMasLargo(1,5,grafo));

        //DFSEJERCICIOS.recorrerColores(grafo);

        System.out.println(EJERCICIO4.caminoMayor(grafo, 1, 7));
        Grafo<String> grafo2 = new GrafoDirigido<>();

        grafo2.agregarVertice(1);
        grafo2.agregarVertice(2);
        grafo2.agregarVertice(3);
        grafo2.agregarVertice(4);
        grafo2.agregarVertice(5);
        grafo2.agregarVertice(6);
        grafo2.agregarVertice(7);
        grafo2.agregarVertice(8);
        grafo2.agregarVertice(9);

        grafo2.agregarVertice(10);
        grafo2.agregarVertice(11);


        grafo2.agregarArco(5, 1, "etiqueta");
        grafo2.agregarArco(1, 3, "etiqueta");
        grafo2.agregarArco(3, 4, "etiqueta");
        grafo2.agregarArco(3, 6, "etiqueta");
        grafo2.agregarArco(4, 2, "etiqueta");
        grafo2.agregarArco(4, 5, "etiqueta");
        grafo2.agregarArco(1, 5, "etiqueta");
        grafo2.agregarArco(2, 5, "etiqueta");
        grafo2.agregarArco(7, 1, "etiqueta");
        grafo2.agregarArco(7, 8, "etiqueta");
        grafo2.agregarArco(8, 9, "etiqueta");
        grafo2.agregarArco(9, 7, "etiqueta");

        grafo2.agregarArco(11, 10, "etiqueta");

        //DFSEJERCICIOS.recorrerColores2(grafo2);


        Grafo<String> grafo3 = new GrafoDirigido<>();

        grafo3.agregarVertice(1);
        grafo3.agregarVertice(2);
        grafo3.agregarVertice(3);
        grafo3.agregarVertice(4);
        grafo3.agregarVertice(5);
        grafo3.agregarVertice(6);
        grafo3.agregarVertice(7);
        grafo3.agregarVertice(8);
        grafo3.agregarVertice(9);


        grafo3.agregarArco(1,2,"Catro barro 100");
        grafo3.agregarArco(1,3,"Avenida malabia 100");
        grafo3.agregarArco(3,1,"Avenida malabia 100");

        grafo3.agregarArco(3,5,"Avenida malabia 200");
        grafo3.agregarArco(3,4,"Avenida victor h barrera 100");

        grafo3.agregarArco(5,3 , " Avenida malabia 200");

        grafo3.agregarArco(2,8,"Castro barros 200");
        grafo3.agregarArco(2,4," 25 de mayo 100");

        grafo3.agregarArco(4,3 , "Avenida victor h barrera");
        grafo3.agregarArco(4,6,"25 de mayo 200");
        grafo3.agregarArco(4,7,"Avenida victor h barerra 200");

        grafo3.agregarArco(7,4,"Avenida victor h barrera 200");
        grafo3.agregarArco(7,8,"25 de mayo 100");

        grafo3.agregarArco(9,7,"25 de mayo 200");

        grafo3.agregarArco(9,6,"Bulnes 200");
        grafo3.agregarArco(6,5,"Bulnes 100");



        List<Integer> camino = EJERCICIO4.caminoMayor(grafo3, 1, 8);
        System.out.println(camino);




    }
}
