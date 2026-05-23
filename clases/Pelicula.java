package taller.clases;

import java.util.Objects;

public class Pelicula {
    private String nombre, director;
    private String genero;
    private double duracion, rating;
    private int yearEstreno;

    public Pelicula() {}

    public Pelicula(String nombre, String director, String genero, double duracion) {
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
    }

    public Pelicula(String nombre, String director, double duracion, String genero, double rating, int yearEstreno) {
        this.nombre = nombre;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.rating = rating;
        this.yearEstreno = yearEstreno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getYearEstreno() {
        return yearEstreno;
    }

    public void setYearEstreno(int yearEstreno) {
        this.yearEstreno = yearEstreno;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nDirector: " + director +
                "\nGenero: " + genero +
                "\nDuracion: " + duracion +
                "\nRating: " + rating +
                "\nAno Estreno: " + yearEstreno;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Double.compare(duracion, pelicula.duracion) == 0 && Double.compare(rating, pelicula.rating) == 0 && yearEstreno == pelicula.yearEstreno && Objects.equals(nombre, pelicula.nombre) && Objects.equals(director, pelicula.director) && Objects.equals(genero, pelicula.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, director, genero, duracion, rating, yearEstreno);
    }
}
