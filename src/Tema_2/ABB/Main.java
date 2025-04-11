package Tema_2.ABB;

import Tema_2.ABB.base.Tree;

public class Main {
    public static void main(String[] args) {
        Tree t = new Tree();
        t.add(40);
        t.add(20);
        t.add(60);
        t.add(10);
        t.add(30);
        t.add(50);
        t.add(70);
        t.add(5);
        t.add(15);
        t.add(25);
        t.add(35);
        t.add(45);
        t.add(55);
        t.add(65);
        t.add(75);
        t.add(80);

        t.printTree();
        System.out.println(t.promedioTree());

    }
}
