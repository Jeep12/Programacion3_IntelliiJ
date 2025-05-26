package PracticaParciales.recuperatorior2024quequen.greedy;

public class Consulta {
    Integer tiempoEstimado;
    boolean esConsultaTecnica;


    public Consulta(boolean esConsultaTecnica, Integer tiempoEstimado) {
        this.esConsultaTecnica = esConsultaTecnica;
        this.tiempoEstimado = tiempoEstimado;
    }

    public boolean isEsConsultaTecnica() {
        return esConsultaTecnica;
    }

    public void setEsConsultaTecnica(boolean esConsultaTecnica) {
        this.esConsultaTecnica = esConsultaTecnica;
    }

    public Integer getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(Integer tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "esConsultaTecnica=" + esConsultaTecnica +
                ", tiempoEstimado=" + tiempoEstimado +
                '}';
    }
}
