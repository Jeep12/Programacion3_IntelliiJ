package BacktrackingDeepSeek.EJ3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> conjunto = Arrays.asList(5, 19, 3, 7, 9, 2, 1, -10);
        Integer k = 9;
        EJ3 ej3 = new EJ3(conjunto);
//          System.out.print(ej3.subsecuencia(k));
        System.out.print(ej3.prueba2(k));

    }
}
