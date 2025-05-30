package Tema_5.Varios.GPT2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);

        BacktrackingPermutaciones back = new BacktrackingPermutaciones(numeros);
        System.out.println(back.resolver());
    }

}
