package Tema_5.EJ7;

public class Estado {
    private int fila;
    private int columna;
    private int[][] matriz;
    private boolean[] usados;
    private int[] sumaFilas;
    private int[] sumaColumnas;

    // Constructor
    public Estado(int n, int k) {
        matriz = new int[n][n];
        usados = new boolean[k + 1];  // índices del 1 a k
        sumaFilas = new int[n];
        sumaColumnas = new int[n];
        fila = 0;
        columna = 0;
    }

    // Getters y setters
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public boolean[] getUsados() {
        return usados;
    }

    public void setUsados(boolean[] usados) {
        this.usados = usados;
    }

    public int[] getSumaFilas() {
        return sumaFilas;
    }

    public void setSumaFilas(int[] sumaFilas) {
        this.sumaFilas = sumaFilas;
    }

    public int[] getSumaColumnas() {
        return sumaColumnas;
    }

    public void setSumaColumnas(int[] sumaColumnas) {
        this.sumaColumnas = sumaColumnas;
    }

    public int sumaFilas(int fila) {
        int suma = 0;
        for (int i = 0; i < matriz[fila].length; i++) {
            suma += matriz[fila][i];
        }
        return suma;
    }

    public int sumaColumnas(int columna) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i][columna];
        }
        return suma;
    }
}
