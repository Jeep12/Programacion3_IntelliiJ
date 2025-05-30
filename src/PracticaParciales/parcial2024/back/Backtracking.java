package PracticaParciales.parcial2024.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {
    List<Character> letras;
    Solucion solucion;
    Diccionario diccionario;

    public Backtracking(List<Character> letras, Diccionario diccionario) {
        this.solucion = new Solucion(new ArrayList<>());
        this.letras = letras;
        this.diccionario = diccionario;
    }


    public Solucion ejercicio(Integer maxLetras) {
        Estado estado = new Estado();
        ejercicio(estado, maxLetras);
        return this.solucion;
    }

    private void ejercicio(Estado estado, Integer maxLetras) {
        if (estado.getPalabrasParcial().size() == maxLetras) {
            String palabra = crearPalabra(estado.getPalabrasParcial());
            if (diccionario.esPalabraValida(palabra)) {
                solucion.getResultado().add(new ArrayList<>(estado.getPalabrasParcial()));
            }
        } else {//Generacion final

            for (Character letra : letras) {
                if (!estado.getVisitados().contains(letra)) {

                    if (! (estado.getPalabrasParcial().isEmpty() && esVocal(letra)) ) {
                        estado.getVisitados().add(letra);
                        estado.getPalabrasParcial().add("" + letra);
                        ejercicio(estado, maxLetras);
                        estado.getVisitados().remove(letra);
                        estado.getPalabrasParcial().remove(estado.getPalabrasParcial().size() - 1);
                    }
                }

            }
        }

    }


    public boolean esVocal(Character letra) {
        return letra.equals('A') || letra.equals('E') || letra.equals('I') || letra.equals('O') || letra.equals('U') ||
                letra.equals('a') || letra.equals('e') || letra.equals('i') || letra.equals('o') || letra.equals('u');

    }

    public String crearPalabra(List<String> listString) {
        StringBuilder palabra = new StringBuilder();
        for (int i = 0; i < listString.size(); i++) {
            palabra.append(listString.get(i));
        }
        return palabra.toString();
    }
}
