package Tema_5.EJ10;

import java.util.List;

public class Estado {

    List<Integer> visitados;
    List<Integer>caminoParcial;

    public Estado(List<Integer> caminoParcial, List<Integer> visitados) {
        this.caminoParcial = caminoParcial;
        this.visitados = visitados;
    }

    public List<Integer> getCaminoParcial() {
        return caminoParcial;
    }

    public void setCaminoParcial(List<Integer> caminoParcial) {
        this.caminoParcial = caminoParcial;
    }



    public List<Integer> getVisitados() {
        return visitados;
    }

    public void setVisitados(List<Integer> visitados) {
        this.visitados = visitados;
    }
    public boolean esCero(){
        Integer suma = 0;
        for(Integer i : caminoParcial){
            suma+=i;
        }
        return suma==0;
    }
}
