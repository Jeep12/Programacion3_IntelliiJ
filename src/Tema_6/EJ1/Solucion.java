package Tema_6.EJ1;

import java.util.ArrayList;
import java.util.List;

public class Solucion {
    private List<Integer> solucion = new ArrayList<>();

    public void addBillete(Integer billete) {
        solucion.add(billete);
    }

    public int sumaActual() {
        int suma = 0;
        for (int i = 0; i < solucion.size(); i++) {
            suma += solucion.get(i);
        }
        return suma;
    }

    public boolean esSolucion(int montoObjetivo) {
        return sumaActual() == montoObjetivo;
    }

    @Override
    public String toString() {
        return solucion.toString();
    }
}
