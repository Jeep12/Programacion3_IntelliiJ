package Tema_5.Varios.GPT3;

import java.util.ArrayList;
import java.util.List;

public class Back {
    List<Integer> conjunto;

    public Back(List<Integer> conjunto) {
        this.conjunto = conjunto;
    }

    public Solucion resolver(Integer objetivo) {
        Solucion solucion = new Solucion();
        Estado estado = new Estado();
        resolver(estado, solucion, objetivo);
        return solucion;
    }

    private void resolver(Estado estado, Solucion solucion, Integer objetivo) {
        if (estado.suma().equals(objetivo)) {
            solucion.addResultado(new ArrayList<>(estado.getCaminoParcial()));

            Estado nuevoEstado = new Estado();
            nuevoEstado.setVisitados(estado.getVisitados());
            nuevoEstado.setSumaActual(0);
            resolver(nuevoEstado, solucion, objetivo);

        } else {

            for (Integer value : conjunto) {
                if (!estado.getVisitados().contains(value)) {
                    estado.getVisitados().add(value);
                    estado.getCaminoParcial().add(value);
                    estado.sumarActual(value);

                    resolver(estado, solucion, objetivo);

                    estado.sumarActual(-value);
                    estado.removerUltimoVisitado();
                    estado.getCaminoParcial().remove(estado.getCaminoParcial().size() - 1);
                }
            }
        }
    }
}


