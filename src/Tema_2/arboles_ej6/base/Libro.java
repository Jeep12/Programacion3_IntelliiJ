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
    public String toString() {
        return "Libro {\n" +
                "  id = " + id + ",\n" +
                "  titulo = '" + titulo + "',\n" +
                "  autor = '" + autor + "',\n" +
                "  generos = " + generos + ",\n" +
                "  añoPublicacion = " + añoPublicacion + ",\n" +
                "  cantidadEjemplares = " + cantidadEjemplares + "\n" +
                '}';
    }


}
