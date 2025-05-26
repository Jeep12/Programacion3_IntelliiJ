package PracticaParciales.recuperatorior2024quequen.greedy;

import java.util.ArrayList;
import java.util.List;

public class GreedyR2024Quequen {

    List<Operador> operadoresDisponibles;
    List<Consulta> consultasDelDia;

    public GreedyR2024Quequen(List<Consulta> consultasDelDia, List<Operador> operadoresDisponibles) {
        this.consultasDelDia = consultasDelDia;
        this.operadoresDisponibles = operadoresDisponibles;
    }

    public Solucion operadoresRequeridos() {
        Solucion solucion = new Solucion(new ArrayList<>());
        //Ordeno las consultas tecnicas primero
        consultasDelDia.sort((c1, c2) -> Boolean.compare(!c1.isEsConsultaTecnica(), !c2.isEsConsultaTecnica()));

        List<Consulta> consultas = new ArrayList<>(this.consultasDelDia);

        for (Consulta c : consultas) {
            boolean asignada = false;

            for (Operador op : operadoresDisponibles) {
                if (op.puedeAtender(c)) {
                    op.addConsulta(c);
                    asignada = true;

                    break;
                }
            }
            if (!asignada) {
                // Si nadie puede, creo uno nuevo
                Operador nuevo = new Operador(2); // asumimos 2 técnicas x día
                nuevo.addConsulta(c);
                operadoresDisponibles.add(nuevo);
            }
        }


        for (Operador op : operadoresDisponibles){
            if (!op.getConsultasPordDia().isEmpty()){
                solucion.addOperador(op);
            }
        }



        return solucion;
    }


}
