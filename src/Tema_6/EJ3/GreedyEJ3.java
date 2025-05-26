package Tema_6.EJ3;

/*
Maximizar el número de actividades compatibles. Se tienen n actividades que necesitan utilizar un
recurso, tal como una sala de conferencias, en exclusión mutua. Cada actividad i tiene asociado un
tiempo de comienzo ci y un tiempo de finalización fi de utilización del recurso, con ci < fi. Si la
actividad i es seleccionada se llevará a cabo durante el intervalo [ci, fi). Las actividades i y j son
compatibles si los intervalos [ci, fi) y [cj, fj) no se superponen (es decir, ci > fj o cj > fi). El problema
consiste en encontrar la cantidad máxima de actividades compatibles entre sí.

Actividades:Tiempo comienz ci, tiempo finalizacion fi.
Recurso

Objetivo: Maximizar el numero de actividades compatibles


*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreedyEJ3 {


    public List<Actividad> seleccionarActividades(List<Actividad> actividades) {
        Collections.sort(actividades); // ordeno por fin

        List<Actividad> seleccionadas = new ArrayList<>();
        int tiempoFinUltima = -1;

        for (Actividad a : actividades) {
            if (a.comienzo >= tiempoFinUltima) {
                seleccionadas.add(a);
                tiempoFinUltima = a.fin;
            }
        }

        return seleccionadas;
    }

}
