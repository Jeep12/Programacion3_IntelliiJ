package BacktrackingDeepSeek.EJ2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> entrada = Arrays.asList(1, 1, 2);

        EJ2 ej2 = new EJ2(entrada);

        System.out.println(ej2.combinaciones());

    }
}
