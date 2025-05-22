package Tema_6.EJ2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Mochila mochila = new Mochila(10); // peso máximo 10

        List<Objeto> objetos = new ArrayList<>();
        objetos.add(new Objeto(100.0, 3.0));
        objetos.add(new Objeto(50.0, 5.0));
        objetos.add(new Objeto(70.0, 4.0));
        objetos.add(new Objeto(200.0, 2.0)); // se fracciona si hace falta

        GreedyEJ2 algoritmo = new GreedyEJ2(mochila);
        List<Objeto> resultado = algoritmo.mochila(objetos);

        System.out.println("Objetos en la mochila:");
        for (Objeto o : resultado) {
            System.out.println("- Valor: " + o.getValor() + " | Peso: " + o.getPeso());
        }


        System.out.println("Precio total " + mochila.precio());
        System.out.println("Peso total: " + mochila.getPesoActual());
    }
}
