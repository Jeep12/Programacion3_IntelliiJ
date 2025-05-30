package Tema_5.EJ7;
/*
Tablero mágico. Dado un tablero de tamaño n x n, construir un algoritmo que ubique (si es posible)
n*n números naturales diferentes, entre 1 y un cierto k (con k>n*n), de manera tal que la suma de las
columnas y de las filas sea igual a S

Tablero n*n = matriz cuadrada

Input S;

 */


public class Backtracking {

    private int[][] matriz;
    private int k;

    public Backtracking(int[][] matriz, int k) {
        this.matriz = matriz;
        this.k = k;
    }

    public Solucion ejercicio(int entrada, int n) {
        Solucion solucion = new Solucion(new int[n][n]);
        Estado estado = new Estado(n, k);
        ejercicio(estado, solucion,entrada);
        return solucion;
    }

    public void ejercicio(Estado estado, Solucion solucion, int entrada) {
        if (estado.sumaFilas(estado.getFila()) == entrada  && estado.sumaColumnas(estado.getColumna()) == entrada){
            solucion.setMatriz(matriz);
        }else {


        }

    }
}
