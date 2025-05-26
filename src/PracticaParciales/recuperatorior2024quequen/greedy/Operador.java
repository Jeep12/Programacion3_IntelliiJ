package PracticaParciales.recuperatorior2024quequen.greedy;

import java.util.ArrayList;
import java.util.List;

public class Operador  {

    List<Consulta> consultasPordDia;
    Integer maxConsultaTecnicaxDia;


    public Operador( Integer maxConsultaxDia) {
        this.consultasPordDia = new ArrayList<>();
        this.maxConsultaTecnicaxDia = maxConsultaxDia;
    }


    public boolean puedeAtender(Consulta c){
        if (!c.isEsConsultaTecnica()){
            return true;
        }else {

            return this.cantConsultasTecnicas()<maxConsultaTecnicaxDia;
        }

    }
    public void addConsulta(Consulta consulta){
        if (puedeAtender(consulta)){
            this.consultasPordDia.add(consulta);
        }



    }

    public Integer cantConsultasTecnicas(){
        int contadorConsultasTecnicas = 0;
        for (Consulta c:consultasPordDia){
            if (c.isEsConsultaTecnica()){
                contadorConsultasTecnicas++;
            }
        }
        return  contadorConsultasTecnicas;
    }

    public Integer getMaxConsultaxDia() {
        return maxConsultaTecnicaxDia;
    }

    public void setMaxConsultaxDia(Integer maxConsultaxDia) {
        this.maxConsultaTecnicaxDia = maxConsultaxDia;
    }

    public List<Consulta> getConsultasPordDia() {
        return consultasPordDia;
    }

    public void setConsultasPordDia(List<Consulta> consultasPordDia) {
        this.consultasPordDia = consultasPordDia;
    }
}
