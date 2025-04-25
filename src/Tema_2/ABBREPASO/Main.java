package Tema_2.ABBREPASO;

import Tema_2.ABBREPASO.base.Tree;

public class Main {

    public static void main(String[] args) {
        Tree abb = new Tree();

        int[] valores = {
                16, 8, 24, 4, 12, 20, 28,
                2, 6, 10, 14, 18, 22, 26, 30,
                1, 3, 5, 7, 9, 11, 13, 15,
                17, 19, 21, 23, 25, 27, 29, 31
        };

        for (int v : valores) {
            abb.add(v);
        }

        abb.add(34);


        abb.printTree();
        System.out.println(abb.sumarAPartir(31));
    }
}
