package PracticaParciales.parcial2024Tresa;

import PracticaParciales.parcial2024Tresa.base.Tree;

public class Enuniado {
    public static void main(String[] args) {
        Tree arbol = new Tree();

        arbol.add(20);

        arbol.add(10);
        arbol.add(30);
        arbol.add(5);
        arbol.add(15);

        arbol.add(25);
        arbol.add(40);
        arbol.add(7);
        arbol.add(50);

        arbol.printTree();
    }
}
