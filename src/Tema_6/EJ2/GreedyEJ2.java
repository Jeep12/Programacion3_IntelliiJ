package Tema_6.EJ2;

import java.util.*;

public class GreedyEJ2 {

    private Mochila mochila;

    public GreedyEJ2(Mochila mochila) {
        this.mochila = mochila;
    }

    public List<Objeto> mochila(List<Objeto> objetos) {
        List<Objeto> disponibles = new ArrayList<>(objetos);

        //Ordenaria de mayor a menor
        //disponibles.sort(Collections.reverseOrder());

        Double peso = 0.0;

        while (peso < mochila.getMaxPeso() && !disponibles.isEmpty()) {
            Objeto o = seleccionar(disponibles);
            System.out.println("Seleccionado: " + o + " con valor/peso = " + (o.getValor()/o.getPeso()));

            disponibles.remove(o); // importante!
            System.out.println("Objetos restantes: " + disponibles.size());

            if (peso + o.getPeso() < mochila.getMaxPeso()) {
                mochila.addObjecto(o);
                peso += o.getPeso();
                System.out.println("Agregado completo: " + o);
                System.out.println("Peso total ahora: " + peso);
            } else {
                double espacio = mochila.getMaxPeso() - peso; // ESPACIO QUE LE MOCHILA
                double fraccion = espacio / o.getPeso();
                double valorFraccion = o.getValor() * fraccion;

                Objeto fraccionado = new Objeto(valorFraccion, espacio);
                mochila.addObjecto(fraccionado);
                peso += espacio;
                System.out.println("Agregado fraccionado: " + fraccionado);
                System.out.println("Peso total ahora: " + peso);
            }
        }

        System.out.println("Mochila llena con peso: " + peso);
        System.out.println("Objetos en mochila: " + mochila.getMochila().size());

        return mochila.getMochila();
    }

    public Objeto seleccionar(List<Objeto> objetos) {
        Objeto o = objetos.get(0);
        Double mejor = o.getValor() / o.getPeso();
        System.out.println("Seleccionando mejor relación valor/peso...");

        for (Objeto objetoACTUAL : objetos) {
            Double relacionActual = objetoACTUAL.getValor() / objetoACTUAL.getPeso();
            System.out.println("Objeto: " + objetoACTUAL + ", relación: " + relacionActual);
            if (relacionActual > mejor) {
                o = objetoACTUAL;
                mejor = relacionActual;
            }
        }

        System.out.println("Mejor objeto seleccionado: " + o + " con relación: " + mejor);
        return o;
    }


}
