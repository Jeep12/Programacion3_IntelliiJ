package PracticaParciales.parcial2024quequen.ej4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BacktrackingParcial {

    List<Producto> productos;
    Mochila mochila;
    Solucion mejorSolucion;

    public BacktrackingParcial(Mochila mochila, List<Producto> productos) {
        this.mochila = mochila;
        this.productos = productos;
        this.mejorSolucion = new Solucion(new ArrayList<>(), 0);
    }


    public Solucion back() {
        Estado estado = new Estado();
        backVISIT(estado);


        return mejorSolucion;
    }

    private void backVISIT(Estado estado) {
        if (estado.valorActual() > mejorSolucion.valorActual() && estado.pesoActual() <= mochila.getPesoMaximo()) {

            mejorSolucion.setSubconjunto(new ArrayList<>(estado.getVisitados()));

        } else {

            Iterator<Producto> itProducto = productos.iterator();

            while (itProducto.hasNext()) {
                Producto producto = itProducto.next();
                if (!estado.getVisitados().contains(producto)) {


                    int nuevoPeso = estado.pesoActual() + producto.getPeso();
                    if (nuevoPeso <= mochila.getPesoMaximo()) {
                        estado.addVisitado(producto);

                        backVISIT(estado);

                        // Backtrack
                        estado.removerUltimo();
                    }
                }

            }
        }
    }
}
