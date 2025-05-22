package Tema_6.EJ2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Mochila mochila = new Mochila(10); // peso máximo 10

        Objeto obj1 = new Objeto(100.0, 3.0);
        Objeto obj2 = new Objeto(50.0, 5.0);
        Objeto obj3 = new Objeto(70.0, 4.0);
        Objeto obj4 = new Objeto(40.0, 3.0); // este ya se pasa del peso máximo
// este ya se pasa del peso máximo

        mochila.addObjecto(obj1);
        mochila.addObjecto(obj2);
        mochila.addObjecto(obj3);
        mochila.addObjecto(obj4);


        System.out.println("Objetos en la mochila:");
        for (Objeto o : mochila.getMochila()) {
            System.out.println("- Valor: " + o.getValor() + " | Peso: " + o.getPeso());
        }

        System.out.println("Peso total: " + mochila.getPesoActual());
    }
}
