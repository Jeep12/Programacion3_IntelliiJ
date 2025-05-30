package PracticaParciales.parcial2024Tresa.back;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> conjunto = Arrays.asList(5,19,3,7,9,2,1,-10);
        Integer suma= 9;

        Backtracking back = new Backtracking(conjunto);

        System.out.println(back.ejercicio4(suma));

    }
}

