package Tema_6.OTRO.actividades;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(4, 1));
        lista.add(new Actividad(5, 3));
        lista.add(new Actividad(6, 0));
        lista.add(new Actividad(7, 5));
        lista.add(new Actividad(8, 3));
        lista.add(new Actividad(9, 5));
        lista.add(new Actividad(10, 6));
        lista.add(new Actividad(11, 8));
        lista.add(new Actividad(12, 8));
        lista.add(new Actividad(13, 2));
        lista.add(new Actividad(14, 12));

        Greedy g = new Greedy(lista);

        System.out.println(g.greedy());

    }
}
