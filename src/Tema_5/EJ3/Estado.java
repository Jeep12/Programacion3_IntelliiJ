package Tema_5.EJ3;

import java.util.List;

public class Estado {
    private List<Integer> sumaParcial;


    public Estado(List<Integer> sumaParcial) {
        this.sumaParcial = sumaParcial;
    }

    public List<Integer> getSumaParcial() {
        return sumaParcial;
    }

    public void setSumaParcial(List<Integer> sumaParcial) {
        this.sumaParcial = sumaParcial;
    }

    public void agregarElemento(int elem) {
        sumaParcial.add(elem);
    }

    public void quitarUltimo() {
        if (!sumaParcial.isEmpty())
            sumaParcial.remove(sumaParcial.size() - 1);
    }

    public boolean esSolucion(Integer sumabuscada) {
        int suma = 0;

        for (int i = 0;i<sumaParcial.size();i++){
            suma+= this.sumaParcial.get(i);
        }
        return sumabuscada == suma;
    }
}
