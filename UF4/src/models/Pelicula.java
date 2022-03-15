package models;

import java.util.Arrays;

public class Pelicula {
    private String titulo;
    private String director;
    private String[] actoresPrincipales;
    private String fechaEstreno;
    private String paisOrigen;
    private long presupuesto;

    /**
     * Constructor con los atributos que no pueden ser null
     * @param titulo título de la película
     * @param director director de la película
     * @param actoresPrincipales actores principales de la película
     */
    public Pelicula(String titulo, String director, String[] actoresPrincipales) {
        this.titulo = titulo;
        this.director = director;
        this.actoresPrincipales = actoresPrincipales;
    }

    /**
     * Constructor con todos los atributos
     * @param titulo título de la película
     * @param director director de la película
     * @param actoresPrincipales actores principales de la película
     * @param fechaEstreno fecha en la que se estrenó la película
     * @param paisOrigen país de origen de la película
     * @param presupuesto presuspuesto gastado para realizar la película
     */
    public Pelicula(String titulo, String director, String[] actoresPrincipales, String fechaEstreno, String paisOrigen, long presupuesto) {
        this.titulo = titulo;
        this.director = director;
        this.actoresPrincipales = actoresPrincipales;
        this.fechaEstreno = fechaEstreno;
        this.paisOrigen = paisOrigen;
        this.presupuesto = presupuesto;
    }

    /**
     * Método para coger el valor del título de la película
     * @return devuelve el valor del título
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método para cambiar el valor del título de la película
     * @param titulo título de la película que quieres poner
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método para coger el valor del director de la película
     * @return devuelve el valor del director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Método para cambiar el valor del director de la película
     * @param director valor del director que quieres poner
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Método para coger el valor de los actores principales de la película
     * @return devuelve un array de strings con los actores principales
     */
    public String[] getActoresPrincipales() {
        return actoresPrincipales;
    }

    /**
     * Método para cambiar el valor de los actores principales
     * @param actoresPrincipales actores principales de la película que quieres poner
     */
    public void setActoresPrincipales(String[] actoresPrincipales) {
        this.actoresPrincipales = actoresPrincipales;
    }

    /**
     * Método para coger el valor de la fecha de estreno
     * @return devuelve el valor de la fecha de estreno
     */
    public String getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Método para cambiar la fecha de estreno
     * @param fechaEstreno fecha de estreno que queremos poner
     */
    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public long getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(long presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * Método para escribir el contenido de la clase
     * @return devuelve un string con el contenido de la clase
     */
    @Override
    public String toString() {
        return "Película{\n\t" +
                "El título es '" + titulo + '\'' +
                ", \n\tel director es '" + director + '\'' +
                ", \n\tlos actores principales son " + Arrays.toString(actoresPrincipales) +
                ", \n\tse estrenó el '" + fechaEstreno + '\'' +
                ", \n\tel país de origen es '" + paisOrigen + '\'' +
                ", \n\tsu presupuesto es de " + presupuesto +
                "\n}";
    }
}
