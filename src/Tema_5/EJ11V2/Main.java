package Tema_5.EJ11V2;

public class Main {

    public static void main(String[] args) {
        int maxf = 3;
        int maxc = 5;
        Celda[][] matriz = new Celda[maxf][maxc];

        // Fila 0
        matriz[0][0] = new Celda(0, true, false, true, false, 0, 0);
        matriz[0][1] = new Celda(0, true, true, true, false, 0, 1);
        matriz[0][2] = new Celda(1, true, true, true, false, 0, 2);  // obstáculo
        matriz[0][3] = new Celda(0, true, true, true, false, 0, 3);
        matriz[0][4] = new Celda(0, true, true, false, false, 0, 4);

        // Fila 1
        matriz[1][0] = new Celda(0, true, false, true, true, 1, 0);
        matriz[1][1] = new Celda(0, true, true, true, true, 1, 1);
        matriz[1][2] = new Celda(0, true, true, true, true, 1, 2); // ROBOT
        matriz[1][3] = new Celda(1, true, true, true, true, 1, 3);  // obstáculo
        matriz[1][4] = new Celda(0, true, true, false, true, 1, 4);

        // Fila 2
        matriz[2][0] = new Celda(1, false, false, true, true, 2, 0);  // obstáculo
        matriz[2][1] = new Celda(0, false, true, true, true, 2, 1);
        matriz[2][2] = new Celda(0, false, true, true, true, 2, 2);
        matriz[2][3] = new Celda(0, false, true, true, true, 2, 3);
        matriz[2][4] = new Celda(0, false, true, false, true, 2, 4);

        Celda fuenteDeCarga = matriz[0][0];
        Celda posRobot = matriz[1][2];

        BackTracking back = new BackTracking(fuenteDeCarga,matriz);
        System.out.println(back.caminoACarga(posRobot));
    }
}
