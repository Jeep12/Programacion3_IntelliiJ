package pp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solucion {
    Set<List<Integer>> resultado;

    public Solucion() {
        this.resultado = new HashSet<>();
    }


    public Set<List<Integer>> getResultado() {
        return resultado;
    }

    public void setResultado(Set<List<Integer>> resultado) {
        this.resultado = resultado;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resultado:\n");
        for (List<Integer> lista : resultado) {
            sb.append(lista).append("\n");
        }
        return sb.toString();
    }


}
