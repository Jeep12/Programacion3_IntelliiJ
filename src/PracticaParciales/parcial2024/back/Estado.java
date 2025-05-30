package PracticaParciales.parcial2024.back;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Estado {
    private Set<Character> visitados;
    private List<String> palabrasParcial;


    public Estado() {
        this.palabrasParcial = new ArrayList<>();
        this.visitados = new HashSet<>();
    }




    public List<String> getPalabrasParcial() {
        return palabrasParcial;
    }

    public void setPalabrasParcial(List<String> palabrasParcial) {
        this.palabrasParcial = palabrasParcial;
    }

    public Set<Character> getVisitados() {
        return visitados;
    }

    public void setVisitados(Set<Character> visitados) {
        this.visitados = visitados;
    }
}
