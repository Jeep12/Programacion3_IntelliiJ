package Tema_6.OTRO.CAMBIO;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Arrays.asList(1, 5, 10, 25);
        List<Integer> monedas = new ArrayList<>();
        monedas.add(1);
        monedas.add(5);
        monedas.add(10);
        monedas.add(25);
        GreedyMonedas gm = new GreedyMonedas(monedas);

        System.out.println(gm.cambio(93));

    }
}
