package Tema_6.EJ1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> monedas = Arrays.asList(100,25,10,5,1);
        //Pagar 289


        GreedyEJ1 g1 = new GreedyEJ1(monedas,289);
        System.out.println(g1.ej1());



    }
}
