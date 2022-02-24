package models;

public class Estudiante extends Persona4{
    private char nivel;

    public Estudiante(String nombre, String dni, String email, char nivel) {
        super(nombre, dni, email);
        this.nivel = nivel;
    }

    public char getNivel() {
        return nivel;
    }

    public void setNivel(char nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Estudiante { " +
                super.toString() +
                "nivel = " + nivel +
                 " }";
    }
}
