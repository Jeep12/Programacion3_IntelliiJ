package Tema_6.EJ2;

import java.util.*;

public class Mochila {
    List<Objeto> mochila;
    Integer maxPeso;
    Double pesoActual;

    public Mochila(Integer maxPeso) {
        this.maxPeso = maxPeso;
        this.mochila = new ArrayList<>();
        this.pesoActual = 0.0;

    }

    public void addObjecto(Objeto elem){
        if (pesoActual + elem.getPeso() <= maxPeso) {
            pesoActual+= elem.getPeso();
            mochila.add(elem);
        }
    }


    public Double precio(){
       Double suma = 0.0;
        for (Objeto o : this.mochila){
            suma+=o.getValor();
        }
        return suma;
    }


    public Integer getMaxPeso() {
        return maxPeso;
    }

    public void setMaxPeso(Integer maxPeso) {
        this.maxPeso = maxPeso;
    }

    public List<Objeto> getMochila() {
        return mochila;
    }

    public void setMochila(List<Objeto> mochila) {
        this.mochila = mochila;
    }

    public Double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Double pesoActual) {
        this.pesoActual = pesoActual;
    }
}
