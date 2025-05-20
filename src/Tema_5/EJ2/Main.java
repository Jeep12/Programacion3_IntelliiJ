package Tema_5.EJ2;


public class Main {

    public static void main(String[] args) {
        //Como es cuadrada tiene la misma cantidad de filas y columnas

        int n = 3;
        Casilla[][] lab = new Casilla[n][n];

        lab[0][0] = new Casilla(false, true, false, true, 1, 0, 0);  // esquina sup-izq
        lab[0][1] = new Casilla(false, true, true, true, 32, 0, 1);
        lab[0][2] = new Casilla(false, false, true, true, 12, 0, 2);  // esquina sup-der

        lab[1][0] = new Casilla(true, true, false, true, 32, 1, 0);
        lab[1][1] = new Casilla(true, true, true, true, 42, 1, 1);
        lab[1][2] = new Casilla(true, false, true, true, 24, 1, 2);

        lab[2][0] = new Casilla(true, true, false, false, 65, 2, 0);  // esquina inf-izq
        lab[2][1] = new Casilla(true, true, true, false, 142, 2, 1);
        lab[2][2] = new Casilla(true, false, true, false, 22, 2, 2);  // esquina inf-der


        int filaInicio = 0, columnaInicio = 0;

        int filaFin = 2, columnaFin = 2;




    }

}
