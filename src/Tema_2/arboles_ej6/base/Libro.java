package Tema_2.arboles_ej6.base;

import java.util.List;

public class Libro {

    private Integer id;
    private String titulo;
    private String autor;
    private List<String> generos;
    private Integer añoPublicacion;
    private Integer cantidadEjemplares;

    public Libro(Integer id, String titulo, String autor, List<String> generos, Integer añoPublicacion, Integer cantidadEjemplares) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.generos = generos;
        this.añoPublicacion = añoPublicacion;
        this.cantidadEjemplares = cantidadEjemplares;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(Integer añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public Integer getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(Integer cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Libro {\n")
                .append("  id = ").append(id).append(",\n")
                .append("  titulo = '").append(titulo).append("',\n")
                .append("  autor = '").append(autor).append("',\n")
                .append("  generos = ").append(generos).append(",\n")
                .append("  añoPublicacion = ").append(añoPublicacion).append(",\n")
                .append("  cantidadEjemplares = ").append(cantidadEjemplares).append("\n")
                .append('}');
        return sb.toString();
    }


}
