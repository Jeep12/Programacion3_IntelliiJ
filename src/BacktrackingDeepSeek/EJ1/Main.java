package BacktrackingDeepSeek.EJ1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> entrada = Arrays.asList(2,3,5,7);
        Integer T=7;

        EJ1 ej1 = new EJ1(entrada);
        System.out.println(ej1.solucionRepetidos(T));
    }
}
