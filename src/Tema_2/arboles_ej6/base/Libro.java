package Tema_2.arboles_ej6.base;

import java.util.List;

public class Libro {

    private Integer id;
    private String titulo;
    private String autor;
    private List<String> generos;
    private Integer añoPublicacion;
    private Integer cantidadEjemplares;

    public Libro(String autor, Integer añoPublicacion, Integer cantidadEjemplares, List<String> generos, Integer id, String titulo) {
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.cantidadEjemplares = cantidadEjemplares;
        this.generos = generos;
        this.id = id;
        this.titulo = titulo;
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
}
