package Tema_2.arboles_ej5;

import Tema_2.arboles_ej5.base.Tree;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add("M", "");
        tree.add("A", "L");
        tree.add("I", "R");
        tree.add("L", "LL");
        tree.add("N", "LR");
        tree.add("A", "LRL");
        tree.add("O", "LRR");

        tree.add("S","RL");
        tree.add("O","RR");
        tree.add("A","RLR");
        tree.printTree();

        System.out.println(tree.formarPalabra(1));
    }
}
