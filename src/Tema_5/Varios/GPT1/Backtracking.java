package Tema_5.Varios.GPT1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
Enunciado - Combinación de platos
Tenés una lista de platos para un menú, y cada plato tiene:

un precio 💰

una cantidad de calorías 🔥

Querés armar un menú del día que:

No se pase de un presupuesto máximo (por ejemplo, $1000)

No supere un límite de calorías (por ejemplo, 2000 cal)

Y que maximice el total de sabor (cada plato tiene un puntaje de sabor)

 */
public class Backtracking {

    private Integer presupuestoMax;
    private Integer caloriasMax;
    private Integer puntuacionSabor;
    private List<Plato> platos;
    private Solucion mejorSolucion;

    public Backtracking(Integer caloriasMax, Integer puntuacionSabor, Integer presupuestoMax, List<Plato> platos) {
        this.caloriasMax = caloriasMax;
        this.puntuacionSabor = puntuacionSabor;
        this.presupuestoMax = presupuestoMax;
        this.platos = platos;
        this.mejorSolucion = new Solucion(new ArrayList<>());

    }

    public Solucion menuDelDia() {

        Estado estado = new Estado();
        menuDelDia(estado);

        return this.mejorSolucion;
    }

    public void menuDelDia(Estado estado) {

        if (estado.getValorActual() < presupuestoMax && estado.getCaloriasActual() < caloriasMax && estado.getSaborActual()> mejorSolucion.getSaborActual()) {//estado final
            mejorSolucion.setMenu(new ArrayList<>(estado.getVisitados()));
            mejorSolucion.setValorActual(estado.getValorActual());
            mejorSolucion.setCaloriasActual(estado.getCaloriasActual());
            mejorSolucion.setSaborActual(estado.getSaborActual());
        } else {

            Iterator<Plato> itPlatos = platos.iterator();

            while (itPlatos.hasNext()) {
                Plato plato = itPlatos.next();
                if (!estado.getVisitados().contains(plato)){
                    estado.addVisitado(plato);

                    estado.setCaloriasActual(plato.getCalorias());
                    estado.setValorActual(plato.getPrecio());
                    estado.setSaborActual(plato.getSabor());

                    menuDelDia(estado);

                    estado.setCaloriasActual(-plato.getCalorias());
                    estado.setValorActual(-plato.getPrecio());
                    estado.setSaborActual(-plato.getSabor());

                    estado.removerUltimo();
                }

            }


        }
    }
}
