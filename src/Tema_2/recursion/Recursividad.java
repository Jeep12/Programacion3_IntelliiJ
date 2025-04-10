package Tema_2.recursion;

import java.util.Arrays;

public class Recursividad {

    //EJERCICIO 1
    //1 Tiene una complejidad de O(n) porque tiene que recorrer n veces el arreglo
    public boolean esOrdenado(int arr[]) {
        return esOrdenado(arr, arr.length - 1);//ultima posicion

    }

    public boolean esOrdenado(int arr[], int index) {
        //Llegamos al final de la recursion entonces nunca corto y estaria ordenado
        if (index == 0) {
            return true;
        }
        //Si el actual es menor al anterior esta desornado
        //Ej en la primera iteracion arr[index] es el ultimo elemento
        // si el ultimo elemento es menor al ante ultimo significa que no esta ordenado
        if (arr[index] < arr[index - 1]) {
            return false;
        }

        //llamado recursivo
        return esOrdenado(arr, index - 1);
    }


    //La variable "a" solo se usa para imprimir,
    public void imprimirFibonnacci(int cursor, int a, int b) {
        if (cursor > 0) {
            System.out.println(a);
            //en el llamado recursivo a+b el segundo parametro toma el lugar de la suma
            //como cambio los parametros, a (parametro del metodo) va a valer el resultado de la suma enviada en el llamado recursivo

            imprimirFibonnacci(cursor - 1, b, a + b);
        }
    }

    public int buscarElemento(int[] arr, int elem) {
        return buscarElemento(arr, arr.length - 1, elem);
    }

    private int buscarElemento(int[] arr, int cursor, int elem) {
        if (cursor < 0) {
            return -1;
        }
        if (!this.esOrdenado(arr)) {
            return -1;
        }
        if (arr[cursor] == elem) {
            return cursor;
        }

        return buscarElemento(arr, cursor - 1, elem);
    }

    public boolean esIgualAPos(int[] arr) {

        return esIgualAPos(arr, arr.length - 1);
    }

    private boolean esIgualAPos(int[] arr, int cursor) {
        //Llego al final
        if (cursor < 0) {
            return false;
        }
        if (arr[cursor] == cursor) {
            System.out.println("Es igual en Arr[" + cursor + "] = " + arr[cursor] + ", y la posicion en el arreglo es: " + cursor);
            return true;
        }

        return esIgualAPos(arr, cursor - 1);
    }

    public void imprimirBinario(int numero) {
        if (numero == 0) return;
        int contador = 0;
        imprimirBinario(numero / 2);
        System.out.print(numero % 2);

    }

    public int sumaAcumulativa(int limit) {
        return sumaAcumulativa(limit, 0);
    }

    private int sumaAcumulativa(int limit, int contador) {

        if (limit == 0) {
            return contador;
        } else {
            return sumaAcumulativa(limit - 1, contador + limit);
        }
    }

    public int buscarMinimoDeUnArray(int[] array) {
        return buscarMinimoDeUnArray(array, array.length - 1, array[array.length - 1]);
    }

    private int buscarMinimoDeUnArray(int[] array, int cursor, int min) {
        //Si el cursor es ==0, ultima iteracion re la recursion
        if (cursor == 0) {
            //agarramos el primer elemento del arreglo y lo comparamos con el minimo que nos dejo la  de recursion por:
            //    if (array[cursor] < min) {
            //            min = array[cursor];
            //        } y si lo es devolver ese sino seguimos devolviendo el minimo
            if (array[0] < min) {
                return array[0];
            } else {
                return min;
            }
        }

        if (array[cursor] < min) {
            min = array[cursor];
        }
        return buscarMinimoDeUnArray(array, cursor - 1, min);
    }

    public int sumaRecursiva(int limit) {
        return sumaRecursiva(limit, 0);
    }

    private int sumaRecursiva(int limit, int contador) {
        System.out.println(limit);
        if (limit == 0) {
            return contador;
        }
        return sumaRecursiva(limit - 1, contador + limit);
    }

    public int calcularFactorial(int n) {
        return calcularFactorial(n, 1);
    }

    private int calcularFactorial(int n, int current) {
        if (n == 0) {
            return current;
        }
        return calcularFactorial(n - 1, n * current);


    }

    public boolean esPalindromo(String palabra) {
        return esPalindromo(palabra, palabra.length() - 1, 0, palabra.length() / 2);
    }

    private boolean esPalindromo(String palabra, int size, int contador, int limit) {
        if (contador == limit || size == limit) {
            return true;
        }
        if (palabra.charAt(contador) != palabra.charAt(size)) {
            return false;
        }
        return esPalindromo(palabra, size - 1, contador + 1, limit);
    }

    public void subconjunto(int [] arr, int target){
            subconjunto(arr,target,0,arr.length-1);
    }
    private void subconjunto(int [] arr, int target,int cont, int size ){
    //arr{2, 4, 6, 8}
        //target 8
        // encontrar sub conjuntos que sumen el targget
        if(size==0){
            return;
        }
        if(arr[size] + arr[size-1] == target ){
            subconjunto(arr,target,cont,size-1);
        }

    }


    public static void main(String[] args) {
        Recursividad recursividad = new Recursividad();
        // recursividad.imprimirAscendente(1);
        // System.out.println(Math.pow(5, 3));

        //recursividad.imprimirDescendente(5);
        //recursividad.imprimirFibonnacci(5,0,1);
        int arr[] = {-3, -1, 0, 2, 4, 6, 10};
        //System.out.println(recursividad.esOrdenado(arr));

        //System.out.println(recursividad.buscarElemento(arr,3));
        //recursividad.imprimirBinario(26);
        //System.out.println(recursividad.esIgualAPos(arr));

        // System.out.println(recursividad.sumaAcumulativa(5));
        //System.out.println(recursividad.buscarMinimoDeUnArray(arr));
        //System.out.println(recursividad.sumaRecursiva(5));
        //System.out.println(recursividad.calcularFactorial(5));
        System.out.println(recursividad.esPalindromo("reconocer"));
    }
}

