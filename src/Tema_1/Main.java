package Tema_1;
import Tema_1.base.MySimpleLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        MySimpleLinkedList<Integer> list = new MySimpleLinkedList<Integer>();

        list.insertFront(10);
        list.insertFront(20);
        list.insertFront(30);
        list.insertLast(40);

        MySimpleLinkedList<Integer> list2 = new MySimpleLinkedList<Integer>();
        list2.insertLast(60);
        list2.insertLast(50);
        list2.insertLast(70);
        list2.insertLast(100);
        list2.insertLast(910);

        // Integer extract = list.extractFront();

        // System.out.println(extract);

        // list.remove(0);

        //System.out.println(list.mergeInOrder(list2));
        // System.out.println(list.get(1));

        // System.out.println(list.indexOf(10));

        // System.out.println(list.size());

        System.out.println(list.mergeListSort(list2));

    }
}
