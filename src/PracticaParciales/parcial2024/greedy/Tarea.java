package PracticaParciales.parcial2024.greedy;

public class Tarea implements Comparable<Tarea> {

    private Integer puntaje;
    private Integer caducidad;

    public Tarea(Integer caducidad, Integer puntaje) {
        this.caducidad = caducidad;
        this.puntaje = puntaje;
    }

    public Integer getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Integer caducidad) {
        this.caducidad = caducidad;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return " P: " + this.getPuntaje()+ ", C: " + this.getCaducidad() + " ";
    }

    @Override
    public int compareTo(Tarea otra) {
        if (this.puntaje < otra.puntaje) {
            return 1; // this es menor, va después
        } else if (this.puntaje > otra.puntaje) {
            return -1; // this es mayor, va antes
        } else {
            return 0; // son iguales
        }
    }

}
