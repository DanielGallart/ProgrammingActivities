package models;

public class Profesor extends Persona4{
    private float horasLectivas;

    public Profesor(String nombre, String dni, String email, float horasLectivas) {
        super(nombre, dni, email);
        this.horasLectivas = horasLectivas;
    }

    public double getHorasLectivas() {
        return horasLectivas;
    }

    public void setHorasLectivas(float horasLectivas) {
        this.horasLectivas = horasLectivas;
    }

    @Override
    public String toString() {
        return "Profesor { " +
                super.toString() +
                " horasLectivas = " + horasLectivas +
                " }";
    }
}
