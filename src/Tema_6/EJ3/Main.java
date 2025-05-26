package Tema_6.EJ3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GreedyEJ3 greedy = new GreedyEJ3();

        List<Actividad> actividades = new ArrayList<>();
        actividades.add(new Actividad(1, 4));
        actividades.add(new Actividad(3, 5));
        actividades.add(new Actividad(0, 6));
        actividades.add(new Actividad(5, 7));
        actividades.add(new Actividad(8, 9));
        actividades.add(new Actividad(5, 9));

        List<Actividad> resultado = greedy.seleccionarActividades(actividades);

        System.out.println("Actividades seleccionadas:");
        for (Actividad a : resultado) {
            System.out.println(a);
        }
    }
}
