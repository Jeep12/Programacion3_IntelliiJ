package PracticaParciales.parcial2024.backtraking;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // tu conjunto de letras
        List<String> conjunto = Arrays.asList("E","R","N","O","M","A","T");
        Backtracking bt = new Backtracking(conjunto);

        // genero todas las “palabras” de 4 letras que no empiecen con vocal
        List<List<String>> resultados = bt.backtracking(4);

        // las imprimo como strings
        for (List<String> palabra : resultados) {
            System.out.println(String.join("", palabra));
        }
    }
}
