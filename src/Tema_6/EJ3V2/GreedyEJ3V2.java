package Tema_6.EJ3V2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*Las actividades i y j son
compatibles si los intervalos [ci, fi) y [cj, fj) no se superponen (es decir, ci > fj o cj > fi).
ci=2  fi =5
cj = 6 fj = 7
*/
public class GreedyEJ3V2 {
    List<Actividad> actividades;

    public GreedyEJ3V2 (List<Actividad> actividades){
        this.actividades = actividades;
    }


    public List<Actividad> actividadesCompatibles(){
        Collections.sort(actividades);
        List<Actividad>resultado = new ArrayList<>();
        Integer tiempoFinActividadAnterior = 0;
        for (Actividad actividad:actividades){
            if (actividad.getComienzo()>tiempoFinActividadAnterior){
                tiempoFinActividadAnterior = actividad.getFin();
                resultado.add(actividad);
            }
        }

        return  resultado;
    }
}
