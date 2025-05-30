package Tema_6.OTRO.monedasgp;

import java.util.Arrays;
import java.util.List;

public class GPTMONEDAS {
    public static void main(String[] args) {
        Integer monto = 63;
        List<Integer> monedas = Arrays.asList(25, 10, 5, 1);

        Greedy g = new Greedy(monedas,monto);

        System.out.println(g.cambio());
    }
}
