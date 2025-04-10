package Tema_2.arboles;

import Tema_2.arboles.base.Tree;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.add(50);//                               50
        tree.add(30);//                         30          70
        tree.add(70);//                     20      40  60      80
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        System.out.println("¿Tiene el 40? " + tree.hasElem(40));
        System.out.println("¿Tiene el 90? " + tree.hasElem(90));
        System.out.println("Raíz: " + tree.getRoot());
    }
}
