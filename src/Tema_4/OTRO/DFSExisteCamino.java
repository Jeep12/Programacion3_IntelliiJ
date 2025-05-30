package Tema_4.OTRO;

import Tema_4.Base.Grafo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DFSExisteCamino {
    private Grafo<?> grafo;
    private Set<Integer> visitados;


    public DFSExisteCamino(Grafo<?> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
    }


    public boolean existeCamino(Integer origen, Integer destino) {
        this.visitados.clear();
        boolean ida = existeCaminoDFS(origen,destino);

        this.visitados.clear();
        boolean vuelta = existeCaminoDFS(destino,origen);
        return ida &&vuelta;
    }

    private boolean existeCaminoDFS(Integer origen, Integer destino) {
        this.visitados.add(origen);
        if (origen.equals(destino)) {
            return true;
        } else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(origen);

            while(adyacentes.hasNext()){
                Integer adyacente = adyacentes.next();
                if (!visitados.contains(adyacente)){
                    boolean resultado = existeCaminoDFS(adyacente,destino);
                    if (resultado){
                        return true;
                    }

                }

            }

        }

        return false;
    }

}
