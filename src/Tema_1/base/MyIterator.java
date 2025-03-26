package Tema_1.base;


import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
    Node<T> cursor;

    public MyIterator(Node<T> first) {
        this.cursor = first;
    }

    @Override
    public boolean hasNext() {
        // Si el cursor es valido
        return this.cursor != null;
    }

    @Override
    public T next() {
        // devuelve el actual y prepara para devolver el segundo

        T info = cursor.getInfo();
        cursor = cursor.getNext();
        return info;
    }

    public T getValue() {
        T info = cursor.getInfo();
        return info;
    }

    public void toNext() {
        cursor = cursor.getNext();
    }
}
