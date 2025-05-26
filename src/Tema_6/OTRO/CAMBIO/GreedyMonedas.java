package Tema_6.OTRO.CAMBIO;

import java.util.*;

public class GreedyMonedas {
    List<Integer> monedas;

    public GreedyMonedas(List<Integer> monedas) {
        this.monedas = monedas;
    }

    public Solucion cambio(Integer monto) {
        Solucion solucion = new Solucion(new ArrayList<>());

        // Ordenamos de mayor a menor
        monedas.sort(Collections.reverseOrder());
        List<Integer> copiaMonedas = new ArrayList<>(monedas);

        while (!copiaMonedas.isEmpty()) {
            Integer moneda = copiaMonedas.get(0); // Agarro la más grande disponible
            if (monto >= moneda) {
                solucion.addMoneda(moneda);
                monto -= moneda;
            }
            copiaMonedas.remove(0); // No entra, paso a la siguiente más chica

        }

        return solucion;
    }
}
