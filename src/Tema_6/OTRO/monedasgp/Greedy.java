package Tema_6.OTRO.monedasgp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Greedy {
    List<Integer> candidatosMonedas;
    Integer monto;


    public Greedy(List<Integer> candidatosMonedas, Integer monto) {
        this.candidatosMonedas = candidatosMonedas;
        this.monto = monto;
    }

    public List<Integer> cambio() {
        //Ordeno descendentemente
        candidatosMonedas.sort(Collections.reverseOrder());
        List<Integer> resolucion = new ArrayList<>();
        Integer cambio = monto;

        int i = 0;
        while (cambio > 0 && i < candidatosMonedas.size()) {
            if (cambio >= candidatosMonedas.get(i)) {
                resolucion.add(candidatosMonedas.get(i));
                cambio -= candidatosMonedas.get(i);
            } else {
                i++;
            }
        }

        return resolucion;
    }
}
