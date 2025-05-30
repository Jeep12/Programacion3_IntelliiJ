package BacktrackingDeepSeek.EJ3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EJ3 {
    List<Integer> conjunto;

    public EJ3(List<Integer> conjunto) {
        this.conjunto = conjunto;

    }

    public Solucion subsecuencia(Integer k) {
        Solucion solucion = new Solucion();
        Estado estado = new Estado();

        subsecuencia(estado, solucion, k, 0);
        return solucion;
    }

    private void subsecuencia(Estado estado, Solucion solucion, Integer k, Integer indice) {
        if (estado.getCaminoParcial().size() == k) {
            solucion.getResultado().add(new ArrayList<>(estado.getCaminoParcial()));
        } else {

            for (int i = indice; i < conjunto.size(); i++) {
                Integer numero = conjunto.get(i);
                estado.getCaminoParcial().add(numero);
                subsecuencia(estado, solucion, k, i + 1);
                estado.getCaminoParcial().remove(estado.getCaminoParcial().size() - 1);
            }
        }
    }

    public Solucion prueba2(Integer k) {
        Solucion solucion = new Solucion();
        Estado estado = new Estado();

        prueba2(estado, solucion, k, 0);
        return solucion;
    }

    private void prueba2(Estado estado, Solucion solucion, Integer k, Integer indice) {
        if (estado.getSumaParcial().equals(k)) {
            if (solucion.getResultado().size() < 4) {

                solucion.getResultado().add(new ArrayList<>(estado.getCaminoParcial()));
                Estado nuevoEstado = new Estado();
                nuevoEstado.setVisitados(estado.getVisitados());
                nuevoEstado.setSumaParcial(0);
                prueba2(nuevoEstado, solucion, k, 0);
            }
        } else {

            for (int i = indice; i < conjunto.size(); i++) {
                Integer numero = conjunto.get(i);
                if (!estado.getVisitados().contains(numero)) {
                    if (estado.getSumaParcial() < k) {


                        estado.getVisitados().add(numero);
                        estado.getCaminoParcial().add(numero);
                        estado.sumarActual(numero);

                        prueba2(estado, solucion, k, 0);

                        estado.getVisitados().remove(numero); // Corregido
                        estado.sumarActual(-numero);
                        estado.getCaminoParcial().remove(estado.getCaminoParcial().size() - 1);

                    }
                }
            }
        }
    }

}
