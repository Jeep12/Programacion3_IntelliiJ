package PracticaParciales.parcial2024.backtraking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
Dado un conjunto C de letras (que tiene más de 4 elementos), se desean generar todas las palabras válidas que
contengan exactamente 4 letras sin repetir y no empiecen con una letra vocal. Se supone que contamos con una
clase Diccionario que nos permite verificar si una secuencia de letras es una palabra válida
<Diccionario.esPalabraValida(string)>.
        Por ejemplo, con C={E, R, N, O, M, A, T} se debería generar una solución compuesta por {MANO, MONA, REMO,
        MORA, RAMO, ROEN, TOMA, ROTA, etc… }
a) Dibuje el árbol de exploración del algoritmo, indicando qué decisiones se toman en cada paso y qué
información se lleva en los estados.
b) Escriba un algoritmo en pseudo-java que resuelva el problema mediante la técnica de Backtracking.
c) ¿Se podría plantear alguna poda que minimice la cantidad de estados generados por el Backtracking? */

public class Backtracking {

    private List<String> conjuntoLetras;
    private List<List<String>> solucion;

    public Backtracking(List<String> conjuntoLetras) {
        this.conjuntoLetras = conjuntoLetras;
        this.solucion = new ArrayList<>();
    }


    public List<List<String>> backtracking(Integer maxLetras) {
        Estado estado = new Estado();
        backtracking(estado, maxLetras);
        return solucion;
    }

    private void backtracking(Estado estado, Integer maxLetras) {
        if (estado.getVisitados().size() == maxLetras) {
            solucion.add(new ArrayList<String>(estado.getVisitados()));
        } else {
            for (String letra : conjuntoLetras) {
                if (!estado.getVisitados().contains(letra) && esVocal(letra)   && !(estado.getVisitados().isEmpty())){
                    estado.agregarElemento(letra);
                    backtracking(estado, maxLetras);
                    estado.quitarUltimo();
                }
            }
        }
    }

    public boolean esVocal(String letra) {
        String l = letra.toUpperCase();
        return l.equals("A")
                || l.equals("E")
                || l.equals("I")
                || l.equals("O")
                || l.equals("U");
    }

}
