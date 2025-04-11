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


        //tree.delete(30);
        //System.out.println("¿Tiene el 40? " + tree.hasElem(40));
        //System.out.println("¿Tiene el 90? " + tree.hasElem(90));
       // System.out.println("Raíz: " + tree.getRoot());
        //tree.delete(50);

        //System.out.println("Raíz: " + tree.getRoot());

        //boolean exists = tree.hasElem(40);
       // System.out.println("¿Existe 40? " + exists);

        //tree.delete(30);

        //System.out.println(tree.getHeight());
       // System.out.println("Post order " );
        //tree.printInOrder();

        //System.out.println(tree.getFrontGreat(20));
       // tree.delete(30);
        System.out.println(tree.isLeaf(70));
        tree.printTree();

    }
}
