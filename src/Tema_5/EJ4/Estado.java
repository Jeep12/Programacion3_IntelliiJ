package Tema_5.EJ4;

import java.util.List;
import java.util.ArrayList;

public class Estado {
    int pos;
    int sumaSub;
    int cantSub;
    List<Integer> subconjunto;

    public Estado(int pos, int sumaSub, int cantSub, List<Integer> subconjunto) {
        this.pos = pos;
        this.sumaSub = sumaSub;
        this.cantSub = cantSub;
        this.subconjunto = new ArrayList<>(subconjunto);
    }
}
