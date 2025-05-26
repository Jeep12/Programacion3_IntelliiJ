package PracticaParciales.recuperatorior2024quequen.greedy;

import java.util.List;

public class Solucion {

    List<Operador> operadores;


    public Solucion(List<Operador> operadores) {
        this.operadores = operadores;
    }

    public void addOperador(Operador op){
        this.operadores.add(op);
    }


    public Integer operadoresRequeridos(){
        return this.operadores.size();
    }
}
