package PracticaParciales.parcial2024.greedy;

/*
Se tiene un conjunto de N tareas que deben ser ejecutadas de manera secuencial (una
                                                                                        detrás de la otra). Hay un único procesador. Se sabe que:
        - Cada tarea tarda 1 segundo en ejecutar (todas tardan lo mismo 1 segundo).
        - Cada tarea posee un puntaje asociado que se nos otorga luego de ejecutarla (la tarea i tiene un puntaje Pi).
        - Cada tarea posee un valor de caducidad C que indica que se tiene que ejecutar entre las primeras C tareas
        (la tarea i tiene una caducidad Ci). Por ej., si una tarea tiene C = 3, entonces para ser ejecutada debe estar
dentro de las primeras 3 tareas a ejecutar sino ya no podrá ser ejecutada.
Diseñe un algoritmo greedy que permita encontrar una secuencia S de tareas a ejecutar tal que se maximice el
puntaje total obtenido. Puede que NO todas las N tareas formen parte de S debido a la restricción de caducidad.
        Por ejemplo, suponiendo las tareas T1 (P=10, C=2); T2 (P=20, C=1); T3 (P=8, C=2), la secuencia óptima S sería [T2,
T1] sumando 30 puntos (20 puntos de T2, 10 puntos de T1). La tarea T3 no forma parte de la secuencia porque su
caducidad C=2 no lo permite (ya que las primeras dos posiciones de la secuencia se encuentran ocupadas).
a) ¿Explique cuál sería la estrategia greedy que seguiría?.
b) Escriba un algoritmo en pseudo-java que lo resuelva mediante la estrategia greedy.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreedyParcial2024 {

    private List<Tarea> secuencia;


    public GreedyParcial2024() {
        this.secuencia = new ArrayList<>();
    }

    public List<Tarea> solucionar(List<Tarea> tareas) {
        Collections.sort(tareas);
        for (Tarea t : tareas) {
            if (t.getCaducidad() > secuencia.size()) {
                secuencia.add(t);
            }
        }

        return secuencia;
    }


}
