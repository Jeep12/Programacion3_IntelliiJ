package Tema_5.EJ8;

import java.util.ArrayList;
import java.util.HashSet;

public class Back {
    Integer base;
    Integer k;
    Integer totalElementos = (base * (base + 1) / 2);

    public Back(Integer base, Integer k) {
        this.base = base;
        this.k = k;
    }

    public Solucion resultado() {
        Solucion solucion = new Solucion();

        Estado estado = new Estado(new ArrayList<>(), new HashSet<>());
        for (int i = 1; i <= base; i++) {
            estado.getCaminoParcial().add(i);
            estado.getVisitados().add(i);
        }
        Integer base = this.base - 1;

        return solucion;

    }

    private void resultado(Estado estado, Solucion solucion, Integer nivelesRestante) {
        if (estado.caminoParcial.size() == totalElementos && nivelesRestante == 0) {//estado final
            solucion.getRespuesta().add(new ArrayList<>(estado.caminoParcial));

        } else {

            for (int num = 1; num < k; num++) {
                if (!estado.getVisitados().contains(num)) {
                    // Lo agrego
                    estado.getCaminoParcial().add(num);
                    estado.getVisitados().add(num);

                    resultado(estado, solucion, nivelesRestante - 1);

                    // Backtrack
                    estado.getVisitados().remove(num);
                    estado.getCaminoParcial().remove(estado.getCaminoParcial().size() - 1);
                }
            }
        }
    }


}
