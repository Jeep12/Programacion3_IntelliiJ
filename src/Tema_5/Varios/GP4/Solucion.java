package Tema_5.Varios.GP4;
import java.util.*;

public class Solucion {
    List<List<Integer>>resultado;

    public Solucion() {
        this.resultado = new ArrayList<>();
    }

    public List<List<Integer>> getResultado() {
        return resultado;
    }

    public void setResultado(List<List<Integer>> resultado) {
        this.resultado = resultado;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Solucion:\n");
        for (List<Integer> lista : resultado) {
            sb.append(lista.toString()).append("\n");
        }
        return sb.toString();
    }
}
