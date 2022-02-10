package models;

import java.util.Arrays;

public class Llibre {
    private String isbn;
    private String titol;
    private String editorial;
    private float preu;
    private String[] temes;
    private int numPags;
    private String[] autors;

    //Creem el constructor

    public Llibre(String isbn, String titol, String editorial, float preu, String[] temes, int numPags, String[] autors) {
        this.isbn = isbn;
        this.titol = titol;
        this.editorial = editorial;
        this.preu = preu;
        this.temes = temes;
        this.numPags = numPags;
        this.autors = autors;
    }

    @Override
    public String toString() {
        return "Llibre{" +
                "isbn='" + isbn + '\'' +
                ", titol='" + titol + '\'' +
                ", editorial='" + editorial + '\'' +
                ", preu=" + preu +
                ", temes=" + Arrays.toString(temes) +
                ", numPags=" + numPags +
                ", autors=" + Arrays.toString(autors) +
                '}';
    }
}
