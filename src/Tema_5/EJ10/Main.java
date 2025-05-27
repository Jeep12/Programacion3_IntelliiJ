package Tema_5.EJ10;

import java.util.Arrays;
import java.util.List;

/*
Utilizando la técnica Backtracking, escriba un algoritmo que dado un conjunto de números enteros,
devuelva (si existen) todos los subconjuntos de tamaño N (dado como parámetro), cuyas sumas
sean exactamente cero. Por ejemplo dado el conjunto {-7, -3, -2, -1, 5, 8 } y N = 3, los subconjuntos
que suman cero son: {-7, -1, 8} y {-3, -2, 5}.

 Input: Conjunto de numeros enteros, Tamañno N

*/
public class Main {

    public static void main(String[] args) {
        List<Integer> conjunto = Arrays.asList(-7, -3, -2, -1, 5, 8);
        Integer N = 3;

        Backtracking b = new Backtracking(conjunto);

        System.out.println(b.ejercicio(N));

    }

}
