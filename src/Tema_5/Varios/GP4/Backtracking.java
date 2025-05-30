package Tema_5.Varios.GP4;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    List<Integer> conjunto;
    Integer longitudSubConjunto;
    Integer sumaMaxima;

    public Backtracking(List<Integer> conjunto, Integer longitudSubConjunto, Integer sumaMaxima) {
        this.conjunto = conjunto;
        this.longitudSubConjunto = longitudSubConjunto;
        this.sumaMaxima = sumaMaxima;
    }

    public Solucion resolver() {
        Solucion solucion = new Solucion();
        Estado estado = new Estado();
        resolver(estado, solucion);
        return solucion;
    }

    private void resolver(Estado estado, Solucion solucion) {
        if (estado.getCaminoParcial().size() == longitudSubConjunto) {//estado final
            solucion.getResultado().add(new ArrayList<>(estado.getCaminoParcial()));
        } else {
            for (Integer numero : conjunto) {

                    boolean noEsIgualAlAnterior =
                            estado.getCaminoParcial().isEmpty()
                                    || !estado.getCaminoParcial()
                                    .get(estado.getCaminoParcial().size() - 1)
                                    .equals(numero);


                    if ((estado.getCaminoParcial().isEmpty() || noEsIgualAlAnterior)
                            && estado.getSumaParcial() + numero <= sumaMaxima) {
                        estado.getVisitados().add(numero);
                        estado.getCaminoParcial().add(numero);
                        estado.sumar(numero);

                        resolver(estado, solucion);

                        estado.getCaminoParcial().remove(estado.getCaminoParcial().size() - 1);
                        estado.sumar(-numero);
                        estado.getVisitados().remove(numero);
                    }


            }
        }
    }
}
