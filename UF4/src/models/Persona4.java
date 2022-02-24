package models;

public class Persona4 {
    private String nombre;
    private String dni;
    private String email;

    public Persona4(String nombre, String dni, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "nombre = '" + nombre + '\'' +
                ", dni = '" + dni + '\'' +
                ", email = '" + email + '\'' +
                " }";
    }
}
