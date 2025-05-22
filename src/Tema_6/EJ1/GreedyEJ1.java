package Tema_6.EJ1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GreedyEJ1 {

    private Solucion solucion;
    private List<Integer> conjuntoBilletes;
    int montoAPagar;

    public GreedyEJ1(List<Integer> conjuntoBilletes, Integer montoAPagar) {
        this.solucion = new Solucion();
        this.conjuntoBilletes = conjuntoBilletes;
        this.montoAPagar = montoAPagar;

    }


    public Solucion ej1() {
        // Ordeno las monedas/billetes de mayor a menor para usar primero las más grandes
        conjuntoBilletes.sort(Collections.reverseOrder());

        // Creo un iterador para recorrer la lista de billetes ordenada
        Iterator<Integer> it = conjuntoBilletes.iterator();

        // montoRestante es lo que falta pagar; inicialmente es todo el monto a pagar
        int montoRestante = montoAPagar;

        // Mientras haya billetes para revisar y todavía quede monto por pagar
        while (it.hasNext() && montoRestante > 0) {
            // Tomo el siguiente billete más grande disponible
            Integer billete = it.next();

            // Mientras pueda usar este billete sin pasarse del monto que falta pagar
            while (montoRestante >= billete) {
                // Agrego el billete a la solución (lo uso)
                solucion.addBillete(billete);

                // Resto el valor del billete al monto restante
                montoRestante -= billete;
            }
        }

        // Retorno la solución con los billetes usados para pagar el monto
        return this.solucion;
    }



}
