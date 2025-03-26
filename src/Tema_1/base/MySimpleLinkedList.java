package Tema_1.base;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MySimpleLinkedList<T> implements Iterable<T> {

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

//		String text = "";
//
//		if (this._size == 0) {
//			text = "[ ]";
//		}
//		text += "[ ";
//		while (count < this._size) {
//			text += aux.getInfo();
//
//			if (aux.getNext() != null) {
//				text += ",";
//			}
//			aux = aux.getNext();
//			count++;
//		}
//		text += " ] ";

        // return text;
    }

    // a) Las listas están desordenadas y la lista resultante debe quedar ordenada.
    public MySimpleLinkedList<T> mergeInOrder(MySimpleLinkedList<T> newList) {
        MySimpleLinkedList<T> result = new MySimpleLinkedList<>();
        Node<T> aux = this.first;

        // O(n^2)
        while (aux.getNext() != null) {
            result.insertLast(aux.getInfo());
            aux = aux.getNext();
        }
        int count = 0;
        // O(n^2)
        while (count < newList.size()) {
            result.insertLast(newList.get(count));
            count++;
        }

        // Crear lista temporal para ordenar

        List<T> tempList = new ArrayList<>();
        int countTemp = 0;

        // O(n^2)
        // Pasar los elementos a tempList para ordenarlos
        while (countTemp < result.size()) {

            // O(n^2)
            tempList.add(result.get(countTemp));
            countTemp++;
        }

        //
        tempList.sort(null);

        // O(n^2)
        // borro los elementos,
        while (result.size() > 0) {
            result.remove(0); // Elimina el primer elemento repetidamente
        }

        // O(n^2)
        // inserto denuevo los elementos
        tempList.stream().forEach(item -> result.insertLast(item));

        return result;
    }

    public MySimpleLinkedList<?> mergeListSort(MySimpleLinkedList<T> newList) {
        MySimpleLinkedList<T> result = new MySimpleLinkedList<T>();

        Iterator<T> it1 = this.iterator();

        //Usando el insertFront puedo mejorar la complejidad porque insertLast es O(1) y el iterator es O(n), entonces queda O(n)
        while (it1.hasNext()) {
            T value = it1.next();
            result.insertFront(value);

        }

        Iterator<T> it2 = newList.iterator();
        while (it2.hasNext()) {
            T value = it2.next();
            result.insertFront(value);

        }


        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(first);

    }

}



















