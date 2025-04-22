package Tema_3.EJ4;

import java.util.Date;
import java.util.Objects;

public class Cliente {
    private Integer dni;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private Integer cp;
    private String ciudad_origen;
    private Double saldo_cuenta;
    private String nombre_carrera;


    public Cliente(
            Integer dni,
            String nombre,
            String apellido,
            Double saldo_cuenta,
            String nombre_carrera,
            Date fecha_nacimiento,
            Integer cp,
            String ciudad_origen) {

        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo_cuenta = saldo_cuenta;
        this.nombre_carrera = nombre_carrera;
        this.fecha_nacimiento = fecha_nacimiento;
        this.cp = cp;
        this.ciudad_origen = ciudad_origen;
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getSaldo_cuenta() {
        return saldo_cuenta;
    }

    public void setSaldo_cuenta(Double saldo_cuenta) {
        this.saldo_cuenta = saldo_cuenta;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getCiudad_origen() {
        return ciudad_origen;
    }

    public void setCiudad_origen(String ciudad_origen) {
        this.ciudad_origen = ciudad_origen;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public boolean equals(Object obj) {
        // Si es el mismo objeto en memoria, son iguales
        if (this == obj) {
            return true;
        }
        // Si el objeto es nulo o no es de la misma clase, no son iguales
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Lo casteo a Cliente y comparo los DNI
        Cliente c = (Cliente) obj;
        return this.dni.equals(c.getDni());
    }

    @Override
    public int hashCode() {
        // Devuelve el código hash del DNI.
        // Si dos objetos Cliente tienen el mismo DNI, su hashCode va a ser igual.
        // Esto es importante para que funcione bien en estructuras como HashMap o HashSet.
        return Objects.hash(this.dni);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("DNI: ").append(this.getDni()).append("\n")
                .append("Nombre: ").append(this.getDni()).append("\n")
                .append("Apellido: ").append(this.getApellido()).append("\n")
                .append("CP: ").append(this.getCp()).append("\n")
                .append("Ciudad: ").append(this.getCiudad_origen());

        return result.toString();
    }
}
