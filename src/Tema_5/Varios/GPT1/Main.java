package Tema_5.Varios.GPT1;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Plato> platos = new ArrayList<>();
        platos.add(new Plato(400, 500, 7));  // precio, calorías, sabor
        platos.add(new Plato(250, 300, 5));
        platos.add(new Plato(600, 700, 9));
        platos.add(new Plato(150, 200, 3));
        platos.add(new Plato(500, 600, 8));
        platos.add(new Plato(300, 400, 6));
        platos.add(new Plato(350, 350, 7));


        Backtracking back = new Backtracking(2000,18,1000, platos);


        System.out.println(back.menuDelDia());
    }
}
