package Tema_2.recursion;

import java.util.Arrays;

public class Recursividad {

    public void imprimirAscendente(int limit) {
        if (limit > 5) {
            return;
        }
        System.out.println(limit);
        imprimirAscendente(limit + 1);
    }

    public void imprimirDescendente(int limit) {
        if (limit > 0) {
            System.out.println(limit);
            imprimirDescendente(limit - 1);

        }

    }

    //La variable a solo se usa para imprimir,

    public void imprimirFibonnacci(int cursor, int a, int b) {
        if (cursor > 0) {
            System.out.println(a);
            //en el llamado recursivo a+b el segundo parametro toma el lugar de la suma
            //como cambio los parametros, a (parametro del metodo) va a valer el resultado de la suma enviada en el llamado recursivo

            imprimirFibonnacci(cursor - 1, b, a + b);
        }
    }

    public void invertir(String palabra) {
            if(palabra.length()>0){
                invertir(palabra);
            }
    }


    public static void main(String[] args) {
        Recursividad recursividad = new Recursividad();
        // recursividad.imprimirAscendente(1);
        // System.out.println(Math.pow(5, 3));

        //recursividad.imprimirDescendente(5);
        //recursividad.imprimirFibonnacci(5,0,1);
        String palabra = "juan";
       recursividad.invertir(palabra);

    }
}

