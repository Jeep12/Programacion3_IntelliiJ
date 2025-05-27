package PracticaParciales.parcial2024quequen.ej4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Productos
        Producto p1 = new Producto(10, 5);
        Producto p2 = new Producto(15, 8);
        Producto p3 = new Producto(7, 1);
        Producto p4 = new Producto(20, 14);

        List<Producto> productos = new ArrayList<>();
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);

        Mochila mochila = new Mochila(15, new ArrayList<>());

        BacktrackingParcial backtracking = new BacktrackingParcial(mochila, productos);


        System.out.println(backtracking.back());

    }
}

