package PracticaParciales.parcial2024.back;

import java.util.List;

public class Diccionario {
    List<String> palabrasValidas;

    public Diccionario(List<String> palabrasValidas) {
        this.palabrasValidas = palabrasValidas;
    }

    public boolean esPalabraValida(String palabra){
        return this.palabrasValidas.contains(palabra);
    }

}
