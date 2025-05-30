package Tema_5.Varios.GP4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> conjunto = Arrays.asList(1,2,3);
        Integer longitudSubConjunto = 3;
        Integer sumaMax = 5;
        Backtracking back = new Backtracking(conjunto,longitudSubConjunto,sumaMax);

        System.out.println(back.resolver());

    }
}
