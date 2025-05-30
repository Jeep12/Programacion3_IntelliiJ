package Tema_5.Varios.GPT2;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingPermutaciones {
    List<Integer> conjunto;

    public BacktrackingPermutaciones( List<Integer> conjunto){
        this.conjunto = conjunto;

    }

    public Solucion resolver(){
        Solucion solucion = new Solucion(new ArrayList<>());
        Estado estado = new Estado();
        resolver(estado,solucion);
        return solucion;
    }
    public void resolver(Estado estado,Solucion solucion){
        if (estado.getVisitados().size() == conjunto.size()){
            solucion.addSolucion(new ArrayList<>(estado.getVisitados()));
        }else {

            for (Integer value:conjunto){
                if (!estado.getVisitados().contains(value)){
                    estado.addVisitado(value);

                    resolver(estado,solucion);
                    estado.getVisitados().remove(value);
                }

            }
        }
    }



}
