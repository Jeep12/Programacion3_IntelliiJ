package Tema_6.EJ2;

import java.util.*;

public class GreedyEJ2 {

    private Mochila mochila;

    public GreedyEJ2(Mochila mochila) {
        this.mochila = mochila;
    }

    public List<Objeto> mochila(List<Objeto> objetos) {


        Double peso = 0.0;

        while (peso < mochila.getMaxPeso()) {
            Objeto o = seleccionar(objetos);
            if (peso + o.getPeso() < mochila.getMaxPeso()) {
                mochila.addObjecto(o);
                peso += o.getPeso();
            }else {

                double espacio = mochila.getMaxPeso() - mochila.getPesoActual();
                double fraccion = espacio / o.getPeso();
                double valorFraccion = o.getValor() * fraccion;

                Objeto fraccionado = new Objeto(valorFraccion, espacio);
                mochila.add(fraccionado);
                pesoActual += espacio;
                valorTotal += valorFraccion;
                break;
            }


        }

        return mochila.getMochila();
    }

    public Objeto seleccionar(List<Objeto> objetos) {
        Objeto o = objetos.get(0);
        Double mejor = o.getValor()/o.getPeso();

        for (Objeto objetoACTUAL :objetos){
            Double relacionActual =objetoACTUAL.getValor()/objetoACTUAL.getPeso();
            if (relacionActual>mejor){
                o = objetoACTUAL;
                mejor = relacionActual;
            }
        }

        return o;

    }


}
