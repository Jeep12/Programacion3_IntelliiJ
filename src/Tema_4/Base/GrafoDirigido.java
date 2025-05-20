package Tema_4.Base;

import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {



    private final Map<Integer, List<Arco<T>>> listaDeAdyacencia;

    public GrafoDirigido() {
        this.listaDeAdyacencia = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!contieneVertice(verticeId)) {
            this.listaDeAdyacencia.put(verticeId, new ArrayList<>());
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        for (Integer clave : this.listaDeAdyacencia.keySet()) {
            List<Arco<T>> listaArcos = this.listaDeAdyacencia.get(clave);
            Iterator<Arco<T>> itArco = listaArcos.iterator();
            while (itArco.hasNext()) {
                Arco<T> value = itArco.next();
                if (value.getVerticeDestino() == verticeId) {
                    itArco.remove();
                    break;
                }
            }
        }

        this.listaDeAdyacencia.remove(verticeId);
    }

    @Override
    public void agregarArco(int verticesId1, int verticesId2, T etiqueta) {
        //VerticeId1 origen
        //VerticeId2 destino
        if (contieneVertice(verticesId1) && contieneVertice(verticesId2)) {

            Arco<T> nuevoArco = new Arco<T>(verticesId1, verticesId2, etiqueta);
            this.listaDeAdyacencia.get(verticesId1).add(nuevoArco);

        }


    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
            List<Arco<T>> listaArcos = this.listaDeAdyacencia.get(verticeId1);
            Iterator<Arco<T>> itArco = listaArcos.iterator();

            // Iteramos sobre los arcos y eliminamos el que coincide con los ids
            while (itArco.hasNext()) {
                Arco<T> arco = itArco.next();
                if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
                    itArco.remove();  // Eliminar el arco usando el Iterator
                    break; // Salir del bucle una vez que se haya eliminado el arco
                }
            }
        }
    }


    @Override
    public boolean contieneVertice(int verticeId) {
        return this.listaDeAdyacencia.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {

            List<Arco<T>> listaArcos = this.listaDeAdyacencia.get(verticeId1);
            Iterator<Arco<T>> it = listaArcos.iterator();
            while (it.hasNext()) {
                Arco<T> value = it.next();
                if ((value.getVerticeDestino() == verticeId2) && (value.getVerticeOrigen() == verticeId1)) {
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
            List<Arco<T>> arcos = listaDeAdyacencia.get(verticeId1);
            for (Arco<T>arco:arcos){
                if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
                    return arco;
                }
            }

        }
            return null;
    }

    @Override
    public int cantidadVertices() {
        return this.listaDeAdyacencia.size();
    }

    @Override
    public int cantidadArcos() {
        int count = 0;
        for (List<Arco<T>> arcos : listaDeAdyacencia.values()) {
            count += arcos.size();
        }
        return count;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        // el metodo keySet devuelve con conjunto de set(Clase Collecion no repetidos) y
        return this.listaDeAdyacencia.keySet().iterator();
    }


    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        if (!contieneVertice(verticeId)) {
            return null;
        } else {
            List<Arco<T>> list = this.listaDeAdyacencia.get(verticeId);
            // obtengo la lista de adyacentes de dicho arco, pero como el iterator
            // es de tipo entero, tiene que ser de una lista de ese tipo.
            List<Integer> adyacentes = new ArrayList<>();
            for(Arco<T> arco: list){
                adyacentes.add(arco.getVerticeDestino());
            }
            // de la lista de arcos cargo en adyacentes el destino del arco.
            return adyacentes.iterator();
        }
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        List<Arco<T>> listTotal = new ArrayList<>();

        for (Integer clave : listaDeAdyacencia.keySet()) {
            listTotal.addAll(listaDeAdyacencia.get(clave));
        }
        return listTotal.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return null;
    }








}