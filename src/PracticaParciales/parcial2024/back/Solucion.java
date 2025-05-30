package PracticaParciales.parcial2024.back;

import java.util.List;

public class Solucion {
    List<List<String>>resultado;


    public Solucion(List<List<String>> resultado) {
        this.resultado = resultado;
    }

    public List<List<String>> getResultado() {
        return resultado;
    }

    public void setResultado(List<List<String>> resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Solucion:\n");
        for (List<String> lista : resultado) {
            sb.append(lista.toString()).append("\n");
        }
        return sb.toString();
    }

}
