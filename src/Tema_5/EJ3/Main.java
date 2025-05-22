package Tema_5.EJ3;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> n = Arrays.asList(5,3,4,6);
        Integer m = 9;

        Backtracking back = new Backtracking(n);

        System.out.println(back.subconjuntos(m));

    }
}
