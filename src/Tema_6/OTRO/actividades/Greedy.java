package Tema_6.OTRO.actividades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Greedy {
    List<Actividad> actividades;

    public Greedy(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public List<Actividad> greedy() {
        //Ordeno por el tiempo de finalizacion de cada actividad de manera descendente.
        Collections.sort(actividades);
        List<Actividad> resolucion = new ArrayList<>();
        Integer tiempoFinAnterior = 0;


        int contador = 0;
        while (!this.actividades.isEmpty()) {
            Actividad actividad = actividades.remove(0);
            if (actividad.getTiempoInicio() >= tiempoFinAnterior) {
                resolucion.add(actividad);
                tiempoFinAnterior = actividad.getTiempoFin();
            }

        }

        return resolucion;
    }
}
