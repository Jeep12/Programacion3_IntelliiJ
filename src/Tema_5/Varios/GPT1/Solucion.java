package Tema_5.Varios.GPT1;

import java.util.ArrayList;
import java.util.List;

public class Solucion {
    List<Plato> menu;
    Integer caloriasActual;
    Integer valorActual;
    Integer saborActual;

    public Solucion( List<Plato> menu) {
        this.caloriasActual = 0;
        this.menu = menu;
        this.saborActual = 0;
        this.valorActual = 0;
    }

    public Integer getCaloriasActual() {
        return caloriasActual;
    }

    public void setCaloriasActual(Integer caloriasActual) {
        this.caloriasActual = caloriasActual;
    }

    public Integer getSaborActual() {
        return saborActual;
    }

    public void setSaborActual(Integer saborActual) {
        this.saborActual = saborActual;
    }

    public Integer getValorActual() {
        return valorActual;
    }

    public void setValorActual(Integer valorActual) {
        this.valorActual = valorActual;
    }



    public List<Plato> getMenu() {
        return menu;
    }

    public void setMenu(List<Plato> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Menú del Día:\n");
        for (Plato p : menu) {
            sb.append(" - Calorías: ").append(p.getCalorias())
                    .append(", Precio: ").append(p.getPrecio())
                    .append(", Sabor: ").append(p.getSabor()).append("\n");
        }
        sb.append("Total calorías: ").append(caloriasActual).append("\n");
        sb.append("Total precio: ").append(valorActual).append("\n");
        sb.append("Total sabor: ").append(saborActual).append("\n");
        return sb.toString();
    }

}
