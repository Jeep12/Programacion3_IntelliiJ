package Tema_6.OTRO.CAMBIO;

import java.util.List;

public class Solucion {
    List<Integer> monedas;

    public Solucion(List<Integer> monedas) {
        this.monedas = monedas;
    }
    public void addMoneda(Integer moneda){
        this.monedas.add(moneda);
    }

    public List<Integer> getMonedas() {
        return monedas;
    }

    public void setMonedas(List<Integer> monedas) {
        this.monedas = monedas;
    }

    @Override
    public String toString() {
        String result = "";
        for (Integer moneda:monedas){
            result+= " "+moneda + ", ";
        }

        return result.toString();
    }
}
