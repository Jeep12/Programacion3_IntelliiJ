package PracticaParciales.parcial2024.back;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> palabrasValidas = Arrays.asList("MANO", "MONA", "REMO", "MORA", "RAMO", "ROEN", "TOMA", "ROTA");
        Diccionario diccionario = new Diccionario(palabrasValidas);
        List<Character>letras = Arrays.asList('E','R','N','O','M','A','T');

        Backtracking back = new Backtracking(letras,diccionario);

        System.out.println(back.ejercicio(4));


    }
}
