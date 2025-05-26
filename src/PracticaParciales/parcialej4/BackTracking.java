package PracticaParciales.parcialej4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BackTracking {
    List<Integer> conjunto;
    List<List<Integer>> solucion;

    public BackTracking(List<Integer> conjunto) {
        this.conjunto = conjunto;
        this.solucion = new ArrayList<>();
    }


    public List<List<Integer>> solucionar() {

        Estado estado = new Estado(new ArrayList<>());

        solucionar(estado);

        return solucion;
    }


    private void solucionar(Estado estado) {

        if (estado.getCaminoParcial().size() == conjunto.size()) {//estado final
            solucion.add(new ArrayList<>(estado.getCaminoParcial()));
        } else {
            //generacion hijos
            Iterator<Integer> it = conjunto.iterator();

            while (it.hasNext()) {
                Integer elem = it.next();

                if (!estado.getCaminoParcial().contains(elem)) {
                    estado.agregarElemento(elem);
                    solucionar(estado);
                    estado.quitarUltimo();
                }

            }


        }
    }




}
