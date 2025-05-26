package Tema_6.EJ3V2;

import java.util.Arrays;
import java.util.List;
/*Las actividades i y j son
compatibles si los intervalos [ci, fi) y [cj, fj) no se superponen (es decir, ci > fj o cj > fi).
ci=2  fi =5
cj = 6 fj = 7
*/


public class Main {
    public static void main(String[] args) {
        // Creo algunas actividades (comienzo, fin)
        Actividad a1 = new Actividad(1, 3);
        Actividad a2 = new Actividad(2, 5);
        Actividad a3 = new Actividad(4, 6);
        Actividad a4 = new Actividad(6, 7);
        Actividad a5 = new Actividad(7, 9);

        List<Actividad> actividades = Arrays.asList(a1, a2, a3, a4, a5);

        // Creo instancia del greedy
        GreedyEJ3V2 greedy = new GreedyEJ3V2(actividades);

        // Obtengo actividades compatibles
        List<Actividad> resultado = greedy.actividadesCompatibles();

        // Imprimo resultado
        System.out.println("Actividades compatibles seleccionadas:");
        for (Actividad a : resultado) {
            System.out.println("Inicio: " + a.getComienzo() + ", Fin: " + a.getFin());
        }
    }
}
