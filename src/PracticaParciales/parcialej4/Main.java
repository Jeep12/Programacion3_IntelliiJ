package PracticaParciales.parcialej4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> conjunto = Arrays.asList(1,2,3);




        BackTracking back = new BackTracking(conjunto);

        System.out.println(back.solucionar());


    }
}
