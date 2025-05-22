package Tema_5.EJ3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Backtracking {

    private List<Integer> conjunto;
    private List<List<Integer>>solucion;


    public Backtracking(List<Integer>conjunto) {
        this.conjunto = conjunto;
        this.solucion =new ArrayList<>();
    }

    public List<List<Integer>>subconjuntos(Integer sumaBuscada){
        Estado estado = new Estado(new ArrayList<>());
        subconjuntos(estado, sumaBuscada);

        return solucion;
    }

    private void subconjuntos(Estado estado,Integer sumaBuscada){
        if (estado.esSolucion(sumaBuscada)){
            solucion.add(new ArrayList<>(estado.getSumaParcial()));
        }else {
            Iterator<Integer> it = conjunto.iterator();

            while (it.hasNext()) {
                Integer elem = it.next();
                if (!estado.getSumaParcial().contains(elem)) {
                    estado.agregarElemento(elem);
                    subconjuntos(estado,sumaBuscada);
                    estado.quitarUltimo();
                }

            }

        }
    }



}
