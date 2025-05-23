package Tema_2.arboles_ej6;

import Tema_2.arboles_ej6.base.Libro;
import Tema_2.arboles_ej6.base.Tree;

import java.util.Arrays;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {


        Libro libro1 = new Libro(1, "Harry Potter y la piedra filosofal", "J.K. Rowling", Arrays.asList("Fantasía", "Aventura"), 1997, 10);
        Libro libro2 = new Libro(2, "Cien años de soledad", "Gabriel García Márquez", Arrays.asList("Realismo mágico", "Ficción"), 1967, 5);
        Libro libro3 = new Libro(3, "El hobbit", "J.R.R. Tolkien", Arrays.asList("Fantasía", "Aventura"), 1937, 8);
        Libro libro4 = new Libro(4, "1984", "George Orwell", Arrays.asList("Distopía", "Ciencia ficción"), 1949, 6);
        Libro libro5 = new Libro(5, "Fahrenheit 451", "Ray Bradbury", Arrays.asList("Distopía", "Ciencia ficción"), 1953, 7);
        Libro libro6 = new Libro(6, "Orgullo y prejuicio", "Jane Austen", Arrays.asList("Romance", "Drama"), 1813, 4);
        Libro libro7 = new Libro(7, "Don Quijote de la Mancha", "Miguel de Cervantes", Arrays.asList("Aventura", "Clásico"), 1605, 3);

        Tree tree = new Tree();

        tree.add(libro4);
        tree.add(libro2);
        tree.add(libro3);
        tree.add(libro6);
        tree.add(libro5);
        tree.add(libro7);
        tree.add(libro1);

//        System.out.println(tree.getBookById(1));
        Hashtable<Integer, String> tabla = new Hashtable<Integer, String>();
        tabla.put(30, "Juan");
        int M = 9;
        System.out.println("40 mod 9 = " + (40 % M)); // Output: 4

        //  System.out.println(tabla.get(30));
        //int num = 167;
        // System.out.println(libro1.hashCode());
        // System.out.println(tree.getBooksByGenre("Ciencia ficción"));

        //System.out.println(tree.getBookBeetwenYears(1606,2000));
        //System.out.println(tree.getBooksByGenre("drama"));
        tree.printTree();
    }
}
