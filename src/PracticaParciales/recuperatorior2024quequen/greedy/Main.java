package PracticaParciales.recuperatorior2024quequen.greedy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Consulta> consultas = new ArrayList<>();
        consultas.add(new Consulta(true, 30));  // Técnica
        consultas.add(new Consulta(true, 10)); // Administrativa
        consultas.add(new Consulta(true, 20));  // Técnica
        consultas.add(new Consulta(false, 15)); // Administrativa
        consultas.add(new Consulta(true, 25));  // Técnica
        consultas.add(new Consulta(true, 10));  // Técnica
        consultas.add(new Consulta(false, 5));  // Administrativa

        // Creo operadores con un máximo de 2 consultas técnicas por día
        List<Operador> operadores = new ArrayList<>();
        operadores.add(new Operador(2));
        operadores.add(new Operador(2));

        GreedyR2024Quequen gd = new GreedyR2024Quequen(consultas,operadores);

        System.out.println(gd.operadoresRequeridos().operadoresRequeridos());

    }
}
