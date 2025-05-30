package Tema_5.EJ7;

/*
Tablero mágico. Dado un tablero de tamaño n x n, construir un algoritmo que ubique (si es posible)
n*n números naturales diferentes, entre 1 y un cierto k (con k>n*n), de manera tal que la suma de las
columnas y de las filas sea igual a S

Tablero n*n = matriz cuadrada

Input S;

 */
public class Main {
    public static void main(String[] args) {
        int n = 3;
        int [][]matriz = new int [n][n];
        int k = n*n+1;
        int s= 15;

        Backtracking back = new Backtracking(matriz,k);




    }
}
