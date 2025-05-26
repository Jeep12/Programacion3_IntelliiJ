package PracticaParciales.parcial2024quequen.ej4;

import java.util.List;

public class Mochila {

    Integer pesoMaximo;
    List<Producto> productos;


    public Mochila(Integer pesoMaximo, List<Producto> productos) {
        this.pesoMaximo = pesoMaximo;
        this.productos = productos;
    }
    public void addProducto(Producto p){
        if (pesoActual()<pesoMaximo && !(pesoActual()+p.getPeso() > pesoMaximo)){
            this.productos.add(p);
        }
    }
    public Integer pesoActual(){
        Integer suma = 0;
        for(Producto p: productos){
            suma+= p.getPeso();

        }

        return suma;
    }


    public Integer getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(Integer pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
