package PracticaParciales.recuperatorio2022;


import PracticaParciales.recuperatorio2022.base.Tree;

public class Main {

    public static void main(String[] args) {
        Tree t = new Tree();
        t.add(10);

        t.add(8);
        t.add(13);

        t.add(4);
        t.add(9);

        t.add(12);
        t.add(20);

        t.add(2);
        t.add(11);

        System.out.println(t.cumplePropiedad(5));

        t.printTree();

    }

}
