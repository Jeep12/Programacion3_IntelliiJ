package Tema_1.base;


import java.util.*;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> first;
    private Integer _size;

    public MySimpleLinkedList() {
        this.first = null;
        this._size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, this.first);
        // tmp.setNext(this.first);
        this.first = tmp;
        this._size++;
    }

    // (n)
    public void insertLast(T info) {
        Node<T> aux = this.first;

        // Creamos el nodo a insertar
        Node<T> nuevoNodo = new Node<T>(info, null);

        if (aux == null) {
            insertFront(info);
            return;
        }

        // Avanzamos aux hasta el ultimo nodo (Avanza mientras haya un nodo (siguiente)
        while (aux.getNext() != null) {
            aux = aux.getNext();
        }

        // insertamos el nuevo nodo
        aux.setNext(nuevoNodo);

        // incrementamos el tamaño de la lista
        this._size++;

    }

    // O(n) donde n es el index (hasta donde recorre en el peor de los casos)
    public void remove(int index) {

        if (this.isEmpty()) {
            System.out.println("Lista vacia");
            return;
        }
        if (index == 0) {
            this.extractFront();
            return;
        }

        // Guardar el nodo anterior para conectarlo con el siguiente
        int contador = 0;
        Node<T> aux = this.first;
        Node<T> anterior = null;

        // Recorro la lista hasta llegar al nodo en la posición "index".
        while (contador < index) {
            // guardo el anterior para acomodar el siguiente mas tarde
            anterior = aux;
            aux = aux.getNext();
            contador++;

        }

        // Si el nodo actual "Aux" no tiene siguiente es el ultimo por ende podemos
        // borrarlo
        if (aux.getNext() == null) {
            aux.setInfo(null);
            anterior.setNext(null);
        } else {
            // si no es el ultimo al anterior le ponemos el siguiente del borrado
            anterior.setNext(aux.getNext());
        }

        this._size--;

    }

    // (1)
    public T extractFront() {
        T response = null;
        if (this.first != null) {

            // guardo el primero para devolverlo
            response = this.first.getInfo();
            // el primero ahora es el siguiente
            this.first = this.first.getNext();

            // descuento una extraccion
            this._size--;
        }

        return response;
    }

    // O(1)
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // O(n)
    public T get(int index) {
        Node<T> aux = this.first;
        int contador = 0;

        if (this.isEmpty()) {
            return null;
        }
        if (index < 0 || index >= this.size()) {
            return null;
        }

        while (contador < index) {
            aux = aux.getNext();
            contador++;

        }

        return aux.getInfo();
    }

    // O(n) donde n es el tamaño del arreglo
    public int indexOf(Integer value) {
        int contador = 0;
        Node<T> aux = this.first;

        // Podria ponerse como aux!=null ya que en un punto va a ser nulo aux =
        // aux.getNext(); "No va a tener siguiente"
        while (contador < this._size) {

            if (aux.getInfo().equals(value)) {
                return contador;
            }

            aux = aux.getNext();
            contador++;
        }

        return -1;
    }

    // O(1)
    public Integer size() {

        return this._size;
    }
    // O(n) donde n es el tamaño del arreglo

    @Override
    public String toString() {
        int count = 0;
        Node<T> aux = this.first;
        StringBuilder message = new StringBuilder();

        if (this._size == 0) {
            message.append("[]");
        } else {

            message.append("[");

            while (count < this.size()) {
                message.append(aux.getInfo());

                if (aux.getNext() != null) {
                    message.append(",");
                }

                aux = aux.getNext();
                count++;
            }

            message.append("]");
        }
        return message.toString();


    }


    public MySimpleLinkedList<?> mergeListSort(MySimpleLinkedList<T> newList) {
        MySimpleLinkedList<T> result = new MySimpleLinkedList<T>();

        Iterator<T> it1 = this.iterator();
        while (it1.hasNext()) {
            T value = it1.next();
            result.insertFront(value);  // Cambié insertFront por insertLast
        }

        Iterator<T> it2 = newList.iterator();
        while (it2.hasNext()) {
            T value = it2.next();
            result.insertFront(value);  // Cambié insertFront por insertLast
        }

        result = mergeSort(result);  // Llamamos al mergeSort

        return result;
    }

    // Método auxiliar que implementa el algoritmo Merge Sort para ordenar una lista.
    private MySimpleLinkedList<T> mergeSort(MySimpleLinkedList<T> list) {
        if (list.size() <= 1) {  // Si la lista tiene 1 o menos elementos, ya está ordenada.
            return list;
        }

        // Creamos dos nuevas listas para dividir la lista original.
        MySimpleLinkedList<T> left = new MySimpleLinkedList<>();
        MySimpleLinkedList<T> right = new MySimpleLinkedList<>();
        int middle = list.size() / 2;  // Calculamos el punto medio para dividir la lista.

        // Recorremos la lista original y agregamos los primeros 'middle' elementos a la lista 'left'.
        Iterator<T> it = list.iterator();
        for (int i = 0; i < middle; i++) {
            left.insertLast(it.next());  // Insertamos al final de 'left'.
        }

        // Los elementos restantes se agregan a la lista 'right'.
        while (it.hasNext()) {
            right.insertLast(it.next());  // Insertamos al final de 'right'.
        }

        // Llamamos recursivamente a 'mergeSort' para ordenar las dos mitades.
        left = mergeSort(left);
        right = mergeSort(right);

        // Combinamos las dos mitades ordenadas y retornamos el resultado.
        return merge(left, right);
    }

    // Método auxiliar para combinar dos listas ordenadas.
    private MySimpleLinkedList<T> merge(MySimpleLinkedList<T> left, MySimpleLinkedList<T> right) {
        MySimpleLinkedList<T> result = new MySimpleLinkedList<>();  // Creamos una lista vacía para almacenar el resultado combinado.
        Iterator<T> leftIt = left.iterator();  // Iterador para la lista 'left'.
        Iterator<T> rightIt = right.iterator();  // Iterador para la lista 'right'.

        // Obtenemos el primer elemento de cada lista.
        T leftItem = leftIt.hasNext() ? leftIt.next() : null;
        T rightItem = rightIt.hasNext() ? rightIt.next() : null;

        // Mientras haya elementos en ambas listas, comparamos y agregamos el más pequeño.
        while (leftItem != null && rightItem != null) {
            if (((Comparable<T>) leftItem).compareTo(rightItem) <= 0) {  // Si leftItem es menor o igual a rightItem.
                result.insertLast(leftItem);  // Insertamos leftItem en el resultado.
                leftItem = leftIt.hasNext() ? leftIt.next() : null;  // Obtenemos el siguiente elemento de 'left'.
            } else {
                result.insertLast(rightItem);  // Insertamos rightItem en el resultado.
                rightItem = rightIt.hasNext() ? rightIt.next() : null;  // Obtenemos el siguiente elemento de 'right'.
            }
        }

        // Si quedan elementos en 'left', los agregamos al resultado.
        while (leftItem != null) {
            result.insertLast(leftItem);  // Insertamos leftItem en el resultado.
            leftItem = leftIt.hasNext() ? leftIt.next() : null;  // Obtenemos el siguiente elemento de 'left'.
        }

        // Si quedan elementos en 'right', los agregamos al resultado.
        while (rightItem != null) {
            result.insertLast(rightItem);  // Insertamos rightItem en el resultado.
            rightItem = rightIt.hasNext() ? rightIt.next() : null;  // Obtenemos el siguiente elemento de 'right'.
        }

        return result;  // Retornamos la lista combinada y ordenada.
    }


    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(first);

    }

    public MySimpleLinkedList<T> mergeListSort2(MySimpleLinkedList<T> newList) {
        MySimpleLinkedList<T> result = new MySimpleLinkedList<>();

        Iterator<T> it1 = this.iterator();
        while (it1.hasNext()) {
            T value = it1.next();
            result.insertInOrder(value);
        }

        Iterator<T> it2 = newList.iterator();

        while (it2.hasNext()) {
            T value = it2.next();
            result.insertInOrder(value);
        }


        return result;

    }


    public void insertInOrder(T value) {
        Node<T> aux = this.first;
        //Si la lista esta vacia insertarmos al frente O
        // el valor del argumento es menor al  (this.first)
        if (aux == null || value.compareTo(aux.getInfo()) < 0) {
            insertFront(value);
            return;
        }
        while (aux.getNext() != null) {
            //Encontramos la pos
            //Si el valor del argumento es mayoro igual al actual y menor o igual al valor del siguiente es donde tenemos que insertar
            if (value.compareTo(aux.getNext().getInfo()) <= 0) {
                break;
            }
            aux = aux.getNext();
        }
        //Creamos un nuevo nodo con el valor del argumento y le seteamos el siguiente del actual
        Node<T> newNode = new Node<T>(value, aux.getNext());
        aux.setNext(newNode);
        this._size++;

    }
//Se podria utilizar el insertInOrder
    public MySimpleLinkedList<T> mezclarListasYaOrdenadas(MySimpleLinkedList<T> newList) {
        MySimpleLinkedList<T> result = new MySimpleLinkedList<T>();

        Node<T> aux;
        aux = this.first;
        while (aux.getNext() != null) {
            aux = aux.getNext();
        }
        Iterator<T>it1 = this.iterator();
        Iterator<T>it2 = newList.iterator();
        if (newList.get(0).compareTo(aux.getInfo())>0) {

            while(it1.hasNext()){
                result.insertLast(it1.next());
            }
            while(it2.hasNext()){
                result.insertLast(it2.next());
            }
        }else {
            while(it2.hasNext()){
                result.insertLast(it2.next());
            }
            while(it1.hasNext()){
                result.insertLast(it1.next());
            }
        }


        return result;
    }

}



















