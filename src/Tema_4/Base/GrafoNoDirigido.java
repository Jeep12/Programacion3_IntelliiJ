package Tema_4.Base;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

    @Override
    public void agregarArco(int verticesId1, int verticesId2, T etiqueta) {
        super.agregarArco(verticesId1, verticesId2, etiqueta);
        super.agregarArco(verticesId2, verticesId1, etiqueta);
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        super.borrarArco(verticeId1, verticeId2);
        super.borrarArco(verticeId2, verticeId1);
    }

    @Override
    public int cantidadArcos() {
        return super.cantidadArcos() / 2;
    }

}