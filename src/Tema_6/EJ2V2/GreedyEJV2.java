package Tema_6.EJ2V2;
import java.util.ArrayList;
import java.util.List;

public class GreedyEJV2 {

    private Mochila mochila;

    public GreedyEJV2(Mochila mochila) {
        this.mochila = mochila;
    }



    public List<Objeto> mochila(List<Objeto> objetos) {
        List<Objeto> disponibles = new ArrayList<>(objetos);

        // Ordenar de mayor a menor valor/peso
        disponibles.sort((o1, o2) -> Double.compare(o2.getValor() / o2.getPeso(), o1.getValor() / o1.getPeso()));

        Double peso = 0.0;

        while (peso < mochila.getMaxPeso() && !disponibles.isEmpty()) {
            Objeto o = disponibles.remove(0); // ya está ordenado, el mejor es el primero

            if (peso + o.getPeso() <= mochila.getMaxPeso()) {
                mochila.addObjecto(o);
                peso += o.getPeso();
            } else {
                double espacio = mochila.getMaxPeso() - peso;
                double fraccion = espacio / o.getPeso();
                double valorFraccion = o.getValor() * fraccion;

                Objeto fraccionado = new Objeto(valorFraccion, espacio);
                mochila.addObjecto(fraccionado);
                peso += espacio;
            }
        }

        return mochila.getMochila();
    }

}
