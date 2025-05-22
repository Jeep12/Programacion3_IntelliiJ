package PracticaParciales.parcialej4;

import java.util.List;

public class Estado {
    List<Integer> visitados;

    public Estado(List<Integer> caminoParcial) {
        this.visitados = caminoParcial;
    }

    public List<Integer> getCaminoParcial() {
        return visitados;
    }

    public void setCaminoParcial(List<Integer> caminoParcial) {
        this.visitados = caminoParcial;
    }

    public void agregarElemento(int elem) {
        visitados.add(elem);
    }

    public void quitarUltimo() {
        if (!visitados.isEmpty())
            visitados.remove(visitados.size() - 1);
    }
}
