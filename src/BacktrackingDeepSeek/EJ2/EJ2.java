package BacktrackingDeepSeek.EJ2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EJ2 {
    List<Integer> conjunto;

    public EJ2(List<Integer> conjunto) {
        this.conjunto = conjunto;
    }


    public Solucion combinaciones() {
        Solucion solucion = new Solucion();
        Collections.sort(conjunto);
        Estado estado = new Estado();
        combinaciones(estado, solucion);
        return solucion;
    }

    private void combinaciones(Estado estado, Solucion solucion) {
        if (estado.getCaminoParcial().size() == conjunto.size()) {
            solucion.getResultado().add(new ArrayList<>(estado.getCaminoParcial()));
            return;
        }

        Integer anterior = null;
        for (int i = 0; i < conjunto.size(); i++) {
            Integer actual = conjunto.get(i);

            if (!estado.getVisitados().contains(i)) {

                boolean puedeUsar = !actual.equals(anterior) || estado.getVisitados().contains(i - 1);

                if (puedeUsar) {

                    estado.getVisitados().add(i);
                    estado.getCaminoParcial().add(actual);

                    combinaciones(estado, solucion);

                    estado.getCaminoParcial().remove(estado.getCaminoParcial().size() - 1);
                    estado.getVisitados().remove(i);
                }
            }
            anterior = actual;
        }
    }
}


